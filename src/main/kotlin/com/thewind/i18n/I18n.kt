package com.thewind.i18n

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.Locale

/**
 * Shared presentation language. Observed by Compose via snapshot state.
 * Chinese is selected for any zh-* system locale; otherwise English is used.
 */
object I18n {
    enum class Language { ENGLISH, CHINESE }

    var language by mutableStateOf(
        if (Locale.getDefault().language.equals("zh", ignoreCase = true)) Language.CHINESE else Language.ENGLISH
    )
        private set

    val switchLabel: String
        get() = if (language == Language.CHINESE) "English" else "中文"

    fun toggle() {
        language = if (language == Language.CHINESE) Language.ENGLISH else Language.CHINESE
    }

    fun text(english: String, chinese: String): String =
        if (language == Language.CHINESE) chinese else english

    // Adapt messages emitted by legacy scanners/view models without changing their binary-processing logic.
    private val messages = mapOf(
        "提示" to "Notice",
        "确定" to "OK",
        "正在搜索中,请稍后" to "Searching; please wait",
        "开始搜索..." to "Starting search...",
        "文件目录不存在" to "File or directory does not exist",
        "文件不存在" to "File does not exist",
        "目标文件/目录不存在" to "Target file or directory does not exist",
        "字符串无效" to "Invalid string",
        "特征码无效" to "Invalid hex pattern",
        "特征码不符合规范，不能以??开头" to "Hex pattern cannot start with ??",
        "未扫描到目标文件" to "No matching files found",
        "未扫描到符合特征的目标文件" to "No matching pattern found",
        "扫描成功" to "Scan completed",
        "正在转换中，请勿重复点击" to "Conversion in progress; please wait",
        "转换失败，非真正数据库文件" to "Conversion failed: not a valid database",
        "开始写入到本地" to "Writing output file",
        "保存成功!" to "Saved successfully",
        "保存失败" to "Save failed",
        "写入本地失败，权限不足" to "Unable to write output: insufficient permissions",
        "输入安装地址" to "Enter installation directory",
        "输入地址" to "Enter path",
        "正在处理中，请勿重复点击" to "Operation in progress; please wait",
        "未发现文件，破解失败" to "Required file not found; operation failed",
        "正在应用补丁" to "Applying patch",
        "成功生成补丁文件!" to "Patch file generated",
        "破解失败" to "Operation failed",
        "开始备份原文件" to "Backing up original file",
        "开始替换原文件" to "Replacing original file"
    )

    fun translate(message: String): String {
        if (language == Language.CHINESE) return message
        messages[message]?.let { return it }
        return when {
            message.startsWith("发现文件：") -> message.replaceFirst("发现文件：", "Found file: ")
            message.startsWith("备份原文件成功") -> message.replaceFirst("备份原文件成功", "Original file backed up")
            message.startsWith("备份原文件失败") -> message.replaceFirst("备份原文件失败", "Original file backup failed")
            message.startsWith("破解成功") -> message.replaceFirst("破解成功", "Operation succeeded")
            message.startsWith("破解失败") -> message.replaceFirst("破解失败", "Operation failed")
            else -> message
        }
    }
}
