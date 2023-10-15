package com.thewind.hacker.editor

import com.thewind.hacker.model.TargetFileScanResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.RandomAccessFile
import java.nio.file.Files
import java.nio.file.StandardCopyOption

object HackHexEditor {

    suspend fun suspendScanTargetString(
        path: String,
        targetString: String,
        fileTypeFilterSet: Set<String> = setOf(),
        onScan: (String) -> Unit
    ) = withContext(Dispatchers.IO) {
        if (targetString.isBlank()) return@withContext TargetFileScanResult(msg = "字符串无效")
        val targetInfoList = HackHexScanner.concurrentScanString(
            path = path,
            targetString = targetString,
            fileTypeFilterSet = fileTypeFilterSet,
            onScan = onScan
        )
        return@withContext TargetFileScanResult(
            msg = if (targetInfoList.isEmpty()) "未扫描到目标文件" else "扫描成功",
            list = targetInfoList
        )
    }


    suspend fun suspendScanTargetFile(
        path: String,
        featureFlag: String,
        fileTypeFilterSet: Set<String> = setOf(".exe", ".dll"),
        onScan: (String) -> Unit
    ) = withContext(Dispatchers.IO) {
        if (featureFlag.startsWith("??")) TargetFileScanResult(msg = "特征码不符合规范，不能以??开头")
        val file = File(path)
        if (!file.exists()) return@withContext TargetFileScanResult(msg = "目标文件/目录不存在")
        if (!featureFlag.isValidFeatureString) return@withContext TargetFileScanResult(msg = "特征码无效")

        val targetInfoList = HackHexScanner.concurrentScan(
            path = path,
            featureFlag = featureFlag,
            fileTypeFilterSet = fileTypeFilterSet,
            onScan = onScan
        )
        return@withContext TargetFileScanResult(
            msg = if (targetInfoList.isEmpty()) "未扫描到符合特征的目标文件" else "扫描成功",
            list = targetInfoList
        )
    }

    fun replaceBytesInFileGeneric(file: File, featureFlag: String?, patchBytePattern: String?): Boolean {
        if (featureFlag == null || patchBytePattern == null) return false
        if (!featureFlag.isValidFeatureString || !patchBytePattern.isValidFeatureString) return false
        val patchSkipPosition = patchBytePattern.skipPosition
        val patchByteArr = patchBytePattern.generalHexToBytes

        val featureByteArr = featureFlag.generalHexToBytes
        val featurePosSet = HackHexScanner.checkFeatureFlagGeneric(
            file = file,
            featureByteArr = featureByteArr,
            skipPosition = featureFlag.skipPosition
        )
        if (featurePosSet.isEmpty()) return false


        val lastModifyTime = file.lastModified()
        val raf = RandomAccessFile(file, "rwd")
        runCatching {
            backupFile(file)
            featurePosSet.forEach {
                raf.seek(it)
                val bArr = ByteArray(patchByteArr.size)
                raf.read(bArr)
                bArr.forEachIndexed { index, byte ->
                    val newByte = patchByteArr[index]
                    if (byte != newByte && !patchSkipPosition[index]) {
                        bArr[index] = newByte
                    }
                }
                raf.seek(it)
                raf.write(bArr)
            }
            raf.close()
            file.setLastModified(lastModifyTime)
            return featurePosSet.isNotEmpty()
        }.onFailure {
            raf.close()
        }
        return false
    }

    private fun backupFile(file: File) {
        runCatching {
            val backupFile = File("${file.absolutePath}.bak")
            if (backupFile.exists()) return
            Files.copy(file.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
        }.onFailure {
            it.printStackTrace()
        }

    }

    fun restoreFile(file: File): Boolean {
        runCatching {
            val backupFile = File("${file.absolutePath}.bak")
            if (!file.exists()) return false
            file.delete()
            Files.copy(backupFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING)
            return true
        }.onFailure {

        }
        return false
    }

}
