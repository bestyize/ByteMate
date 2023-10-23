package com.thewind.database.page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thewind.database.vm.DatabaseParsePageViewModel
import com.thewind.theme.LocalColors
import com.thewind.widget.DefaultOptionBanner
import com.thewind.widget.FileSelectField

@Composable
@Preview
fun DatabaseParsePage(vm: DatabaseParsePageViewModel = remember { DatabaseParsePageViewModel.INSTANCE }) {

    val pageState by vm.pageState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            FileSelectField(
                modifier = Modifier.padding(20.dp).fillMaxWidth(),
                path = pageState.path,
                hint = remember { "输入或选择.db文件路径" },
                onPathChange = {
                    vm.updatePath(it)
                })
            Spacer(modifier = Modifier.height(10.dp))
            DefaultOptionBanner(title = "导出为Json", onClick = {
                vm.startConvert(pageState.path)
            })
            Spacer(modifier = Modifier.height(10.dp))
            DefaultOptionBanner(title = "导出为Excel", onClick = {
                vm.startConvert(pageState.path, isJson = false)
            })
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


}