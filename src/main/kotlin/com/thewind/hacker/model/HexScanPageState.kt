package com.thewind.hacker.model

data class HexScanPageState(
    val path: String = "",
    val featureCode: String = "",
    val noticeContent: String = "",
    val enable: Boolean = true,
    val operateLog: String = ""
)