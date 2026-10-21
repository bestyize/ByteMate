package com.thewind.bytecode.business.inteiilj.page

import com.thewind.i18n.I18n

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.thewind.bytecode.business.inteiilj.vm.IntellijPatchPageViewModel
import com.thewind.theme.LocalColors
import com.thewind.widget.FileSelectField
import kotlinx.coroutines.launch

@Composable
@Preview
fun IntellijPatchPage() {
    val scope = rememberCoroutineScope()
    val vm: IntellijPatchPageViewModel = viewModel { IntellijPatchPageViewModel() }
    val pageState by vm.pageState.collectAsState()


    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            FileSelectField(
                modifier = Modifier.padding(20.dp).fillMaxWidth(), path = pageState.installPath, onPathChange = {
                    vm.updateInstallPath(it)
                }, hint = I18n.text("Enter an IDE installation directory", "输入或选择 IDE 安装路径")
            )
            Box(modifier = Modifier.padding(20.dp)
                .background(color = LocalColors.current.AdobeBlue, shape = RoundedCornerShape(100.dp)).fillMaxWidth()
                .wrapContentHeight().clickable {
                    scope.launch {
                        vm.patchLicenseDialog()
                    }
                }) {
                Text(
                    text = I18n.text("Apply patch", "执行破解"),
                    fontSize = 18.sp,
                    color = LocalColors.current.AdobeMediumBlue,
                    modifier = Modifier.padding(vertical = 15.dp).wrapContentSize().align(Alignment.Center)
                )
            }
            LazyColumn(modifier = Modifier.padding(20.dp).fillMaxSize().background(color = LocalColors.current.Ga1)) {
                items(count = pageState.notices.size) { index ->
                    NoticeTips(pageState.notices[index])
                }
            }
        }
    }
}

@Composable
@Preview
private fun NoticeTips(notice: String) {
    Text(
        text = I18n.translate(notice),
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
        color = LocalColors.current.Text2,
        fontSize = 11.sp
    )
}