package com.thewind.database.vm

import com.thewind.database.model.DatabaseParsePageState
import com.thewind.database.repo.DatabaseReader
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File

class DatabaseParsePageViewModel {

    @OptIn(DelicateCoroutinesApi::class)
    private val scope = GlobalScope

    private var convertJob: Job? = null

    private val _pageState: MutableStateFlow<DatabaseParsePageState> = MutableStateFlow(DatabaseParsePageState())

    val pageState = _pageState.asStateFlow()

    fun updatePath(path: String) {
        _pageState.value = _pageState.value.copy(path = path)
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun startConvert(path: String, isJson: Boolean = true) {
        if (convertJob?.isActive == true) {
            updateOperateLog("正在转换中，请勿重复点击")
            return
        }
        convertJob = scope.launch {
            val file = File(path)
            if (!file.exists()) {
                updateOperateLog("文件不存在")
                convertJob = null
                return@launch
            }
            if (!file.parentFile.exists()) {
                file.parentFile.mkdirs()
            }
            val res = DatabaseReader.parseDatabase(path)
            if (res.isEmpty()) {
                updateOperateLog("转换失败，非真正数据库文件")
                convertJob = null
                return@launch
            }
            updateOperateLog("开始写入到本地")
            runCatching {
                val successful =
                    if (isJson) DatabaseReader.exportToJson(res, "$path.json") else DatabaseReader.exportToCsv(
                        res,
                        "$path.csv"
                    )
                if (successful) {
                    updateOperateLog("保存成功!")
                } else {
                    updateOperateLog("保存失败")
                }
            }.onFailure {
                updateOperateLog("写入本地失败，权限不足")
            }
            convertJob = null
        }
    }

    fun updateNoticeContent(content: String) {
        _pageState.value = _pageState.value.copy(noticeContent = content)
    }

    private fun updateOperateLog(log: String) {
        _pageState.value = _pageState.value.copy(operateLog = log)
    }


    companion object {
        val INSTANCE = DatabaseParsePageViewModel()
    }
}