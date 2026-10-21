package com.thewind.main.vm

import com.thewind.i18n.I18n

import com.thewind.widget.model.NoticeContent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainPageViewModel {

    private val _noticeState: MutableStateFlow<NoticeContent?> = MutableStateFlow(null)

    val noticeState = _noticeState.asStateFlow()

    val tabs: List<String>
        get() = listOf(
            I18n.text("Hex search", "特征码搜索"),
            I18n.text("String search", "字符串搜索"),
            I18n.text("Database", "数据库解析"),
            I18n.text("Bytecode", "字节码修改"),
            I18n.text("IntelliJ patch", "Intellij补丁")
        )

    fun updateNotice(noticeContent: NoticeContent?) {
        _noticeState.value = noticeContent
    }


    companion object {
        val INSTANCE = MainPageViewModel()
    }
}