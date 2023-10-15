package com.thewind.widget.model

data class NoticeContent(
    val title: String = "温馨提示",
    val content: String = "新通知",
    val okText: String = "确定",
    val cancelText: String? = null
)