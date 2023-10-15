package com.thewind.hacker.editor

import com.thewind.hacker.model.TargetFileInfo
import com.thewind.util.print
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import java.io.File
import java.io.RandomAccessFile


suspend fun main() {
    HackHexScanner.concurrentScanString("F:\\Edrawsoft\\EdrawMax（简体中文）", "subscription/max").print()
}

object HackHexScanner {

    suspend fun concurrentScanString(
        path: String,
        targetString: String,
        fileTypeFilterSet: Set<String> = emptySet(),
        onScan: (String) -> Unit = {}
    ) = concurrentScan(
        path = path,
        featureFlag = targetString.toByteArray().hexStrSplit,
        fileTypeFilterSet = fileTypeFilterSet,
        onScan = onScan,
        isString = true
    )

    suspend fun concurrentScan(
        path: String,
        featureFlag: String,
        fileTypeFilterSet: Set<String> = emptySet(),
        onScan: (String) -> Unit = {},
        isString: Boolean = false
    ) = withContext(Dispatchers.IO) {
        val matchFileInfo = mutableListOf<TargetFileInfo>()
        val files = findAllFile(path = path, fileTypeFilterSet = fileTypeFilterSet)
        val jobList = mutableListOf<Job>()
        if (!isString && !featureFlag.isValidFeatureString) return@withContext matchFileInfo
        val skipPosition = if (isString) BooleanArray(featureFlag.length) else featureFlag.skipPosition
        val featureByteArr = featureFlag.generalHexToBytes

        files.forEach {
            jobList.add(async(Dispatchers.IO) {
                onScan.invoke(it.name)
                val targetInfo = scanTargetFile(file = it, featureByteArr = featureByteArr, skipPosition = skipPosition)
                if (targetInfo.targetOffset.isNotEmpty()) {
                    matchFileInfo.add(targetInfo)
                }
                println("concurrentScan, file = ${targetInfo.fullPath} finished")
            })
        }
        jobList.forEach {
            it.join()
        }
        return@withContext matchFileInfo
    }

    internal fun checkFeatureFlagGeneric(file: File, featureByteArr: ByteArray, skipPosition: BooleanArray): Set<Long> {
        var raf: RandomAccessFile? = null
        runCatching {
            val buffer = ByteArray(4096)
            var pos: Long = 0
            val matchPosSet: MutableSet<Long> = mutableSetOf()
            var bytesRead: Int
            raf = RandomAccessFile(file, "r")
            while (raf!!.read(buffer).also { bytesRead = it } != -1) {
                for (i in 0 until bytesRead - featureByteArr.size + 1) {
                    val fileArr = buffer.sliceArray(i until i + featureByteArr.size)
                    if (fileArr[0] == featureByteArr[0] && !skipPosition[0]) {
                        if (featureByteArr.isMatch(fileArr, skipPosition)) {
                            val matchPos = pos + i
                            matchPosSet.add(matchPos)
                            println("matchPos = $matchPos")
                        }
                    }
                }
                pos += bytesRead
            }
            raf?.close()
            return matchPosSet
        }.onFailure {
            raf?.close()
        }
        return emptySet()
    }

    private suspend fun scanTargetFile(file: File, featureByteArr: ByteArray, skipPosition: BooleanArray) =
        withContext(Dispatchers.IO) {
            return@withContext TargetFileInfo(
                fullPath = file.absolutePath,
                targetOffset = checkFeatureFlagGeneric(
                    file = file,
                    featureByteArr = featureByteArr,
                    skipPosition = skipPosition
                )
            )
        }


    fun findAllFile(path: String, fileTypeFilterSet: Set<String> = emptySet()): List<File> {
        val file = File(path)
        val result = mutableListOf<File>()
        dfsScan(file = file, fileTypeFilterSet = fileTypeFilterSet, result = result)
        return result
    }

    private fun dfsScan(file: File, fileTypeFilterSet: Set<String>, result: MutableList<File>) {
        if (file.isDirectory) {
            file.listFiles()?.forEach { childFile ->
                dfsScan(childFile, fileTypeFilterSet, result)
            }
            return
        }
        if (file.exists() && (fileTypeFilterSet.isEmpty() || fileTypeFilterSet.contains(file.postFix))) {
            result.add(file)
        }
    }


}

@OptIn(ExperimentalStdlibApi::class)
private val ByteArray.hexStrSplit: String
    get() {
        val sb = StringBuilder()
        forEachIndexed { index, byte ->
            sb.append(byte.toHexString(HexFormat.UpperCase))
            if (index != size - 1) {
                sb.append(" ")
            }
        }
        return sb.toString()
    }

private val String.hexToByte: Byte
    get() = toInt(16).toByte()

private val File.postFix: String
    get() = if (name.contains(".")) name.substring(name.lastIndexOf(".")) else name


val String.isValidFeatureString: Boolean
    get() {
        if (length < 2) return false
        split(" ").forEach { str ->
            if (str.length != 2) return false
            if (str != "??") {
                runCatching {
                    str.hexToByte
                }.onFailure {
                    it.printStackTrace()
                    return false
                }
            }
        }
        return true
    }

internal val String.skipPosition: BooleanArray
    get() {
        val featureStringArr = split(" ")
        val skipPosition = BooleanArray(featureStringArr.size)
        featureStringArr.forEachIndexed { index, str ->
            if (str == "??") {
                skipPosition[index] = true
            }
        }
        return skipPosition
    }

private fun ByteArray.isMatch(originArr: ByteArray, skipPosition: BooleanArray): Boolean {
    if (size != originArr.size) return false
    val featureArr = this
    originArr.forEachIndexed { index, byte ->
        if (featureArr[index] != byte && !skipPosition[index]) {
            return false
        }
    }
    return true
}

val String.generalHexToBytes: ByteArray
    get() {
        val magicGenericPatchHex: Byte = 77
        val bArr = ByteArray(uppercase().split(" ").size)

        uppercase().split(" ").forEachIndexed { itemIndex, item ->
            if (item.length != 2) return ByteArray(0)

            bArr[itemIndex] = if (item == "??") magicGenericPatchHex else item.toInt(16).toByte()
        }

        return bArr
    }