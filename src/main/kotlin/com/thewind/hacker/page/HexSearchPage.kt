package com.thewind.hacker.page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thewind.hacker.editor.HackHexEditor.suspendScanTargetFile
import com.thewind.hacker.vm.HexHackPageViewModel
import com.thewind.theme.LocalColors
import com.thewind.util.toJson
import com.thewind.widget.ComposeFileChooser
import com.thewind.widget.FileSelectionMode
import com.thewind.widget.NoticeDialog
import kotlinx.coroutines.*
import java.io.File

@OptIn(DelicateCoroutinesApi::class)
@Composable
@Preview
fun HexSearchPage(
    vm: HexHackPageViewModel = remember { HexHackPageViewModel.INSTANCE },
    scope: CoroutineScope = remember { GlobalScope }
) {
    val pageState by vm.hexHackPageState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {

            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    textColor = LocalColors.current.Text1,
                    disabledTextColor = LocalColors.current.Text1,
                    backgroundColor = LocalColors.current.Bg3,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    placeholderColor = LocalColors.current.Text3
                ),
                maxLines = 10,
                value = pageState.path, onValueChange = {
                    vm.updatePath(path = it)
                }, placeholder = {
                    Text(
                        text = "点击此处输入目标软件的根目录，例如C:\\Program Files\\Adobe\\Adobe Photoshop 2024",
                        fontSize = 14.sp
                    )
                }, trailingIcon = {
                    Box(
                        modifier = Modifier
                            .background(color = LocalColors.current.AdobeBlue, shape = RoundedCornerShape(100.dp))
                            .wrapContentSize().padding(5.dp)
                    ) {
                        ComposeFileChooser(
                            textSize = 14.sp,
                            text = "选择",
                            textColor = LocalColors.current.AdobeMediumBlue,
                            modifier = Modifier.wrapContentSize().align(Alignment.BottomEnd),
                            selectionMode = FileSelectionMode.FILES_AND_DIRECTORIES,
                            onSelected = {
                                vm.updatePath(it)
                            })
                    }
                },
                modifier = Modifier.padding(20.dp).fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    textColor = LocalColors.current.Text1,
                    disabledTextColor = LocalColors.current.Text1,
                    backgroundColor = LocalColors.current.Bg3,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    placeholderColor = LocalColors.current.Text3
                ),
                maxLines = 10,
                value = pageState.featureCode, onValueChange = {
                    vm.updateFeatureCode(it)
                }, placeholder = {
                    Text(
                        text = "点击此处输入特征码，如有通配符请用??替代，例如\nC7 41 04 05 00 00 00 ?? 01 00 00 00",
                        fontSize = 14.sp
                    )
                },
                modifier = Modifier.padding(20.dp).fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier.padding(20.dp)
                    .background(color = LocalColors.current.AdobeBlue, shape = RoundedCornerShape(100.dp))
                    .fillMaxWidth().wrapContentHeight().clickable {
                        if (!pageState.enable) {
                            vm.updateNoticeContent(notice = "正在搜索中,请稍后")
                            vm.updateOperateLog("开始搜索...")
                            return@clickable
                        }
                        scope.launch(Dispatchers.IO) {
                            vm.updateClickable(false)
                            val content = if (!File(pageState.path).exists()) {
                                "文件目录不存在"
                            } else {
                                val result = suspendScanTargetFile(
                                    path = pageState.path,
                                    featureFlag = pageState.featureCode,
                                    onScan = {
                                        scope.launch(Dispatchers.IO) {
                                            vm.updateOperateLog(it)
                                        }
                                    })
                                if (result.list.isEmpty()) result.msg else result.list.toJson()
                            }
                            vm.updateNoticeContent(content ?: "")
                            vm.updateClickable(true)
                            vm.updateOperateLog("")
                        }
                    }
            ) {
                Text(
                    text = "搜索文件/文件夹特征码",
                    fontSize = 18.sp,
                    color = LocalColors.current.AdobeMediumBlue,
                    modifier = Modifier.padding(vertical = 15.dp).wrapContentSize().align(Alignment.Center)
                )
            }
        }

        if (pageState.operateLog.isNotEmpty()) {
            Text(
                text = pageState.operateLog,
                fontSize = 12.sp,
                color = LocalColors.current.AdobeMediumBlue,
                maxLines = 5,
                modifier = Modifier.padding(30.dp).wrapContentSize().align(Alignment.BottomCenter)
            )
        }
    }
    pageState.noticeContent.takeIf { it.isNotEmpty() }?.let {
        NoticeDialog(title = "提示", content = it, onOk = {
            vm.updateNoticeContent("")
        })
    }

}