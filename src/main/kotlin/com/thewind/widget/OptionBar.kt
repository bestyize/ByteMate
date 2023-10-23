package com.thewind.widget

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thewind.theme.LocalColors
import com.thewind.widget.model.OptionItem

@Composable
fun OptionBar(options: List<OptionItem> = emptyList(), onSelected: (OptionItem) -> Unit = {}) {
    Row(modifier = Modifier.wrapContentSize()) {
        options.forEach { option ->
            MenuField(optionItem = option, onSelected = onSelected)
            DropdownMenu(
                expanded = option.isSelected,
                modifier = Modifier.background(color = LocalColors.current.AdobeBlue),
                onDismissRequest = {
                    onSelected.invoke(option.copy(isSelected = false))
                }) {
                option.subOptionItems.forEach { subOption ->
                    MenuField(optionItem = subOption, onSelected = onSelected)
                }
            }
        }
    }
}

@Composable
private fun MenuField(optionItem: OptionItem, onSelected: (OptionItem) -> Unit) {
    Box(
        modifier = Modifier.wrapContentSize()
            .padding(vertical = 5.dp, horizontal = 10.dp)
            .clip(RoundedCornerShape(5.dp)).clickable {
                onSelected.invoke(optionItem)
            }
    ) {
        Text(
            text = optionItem.name,
            fontSize = 14.sp,
            color = LocalColors.current.Text1,
            fontWeight = if (optionItem.isSelected) FontWeight.Bold else FontWeight.Normal,
            modifier = Modifier.wrapContentSize()
        )
    }
}


@Composable
@Preview
private fun PreviewBar() {
    val options = listOf(
        OptionItem(
            id = 0, name = "文件", isSelected = true, subOptionItems = listOf(
                OptionItem(id = 0, name = "新建"),
                OptionItem(id = 1, name = "打开"),
                OptionItem(id = 2, name = "保存"),
                OptionItem(id = 3, name = "另存为"),
                OptionItem(id = 4, name = "关闭"),
                OptionItem(id = 5, name = "退出")
            )
        ),
        OptionItem(id = 1, name = "编辑"),
        OptionItem(id = 2, name = "视图")
    )
    OptionBar(options = options) {

    }
}