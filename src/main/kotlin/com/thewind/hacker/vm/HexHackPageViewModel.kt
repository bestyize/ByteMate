package com.thewind.hacker.vm

import com.thewind.hacker.model.HexScanPageState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HexHackPageViewModel {

    private val _hexScanPageState: MutableStateFlow<HexScanPageState> = MutableStateFlow(HexScanPageState())

    val hexHackPageState = _hexScanPageState.asStateFlow()

    fun updatePath(path: String) {
        _hexScanPageState.value = _hexScanPageState.value.copy(path = path)
    }

    fun updateFeatureCode(featureCode: String) {
        _hexScanPageState.value = _hexScanPageState.value.copy(featureCode = featureCode)
    }

    fun updateNoticeContent(notice: String) {
        _hexScanPageState.value = _hexScanPageState.value.copy(noticeContent = notice)
    }

    fun updateClickable(enable: Boolean) {
        _hexScanPageState.value = _hexScanPageState.value.copy(enable = enable)
    }

    fun updateOperateLog(operateLog: String) {
        _hexScanPageState.value = _hexScanPageState.value.copy(operateLog = operateLog)
    }

    companion object {
        val INSTANCE = HexHackPageViewModel()
    }

}