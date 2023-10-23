package com.thewind.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thewind.theme.LocalColors

@Composable
fun FileSelectField(
    modifier: Modifier,
    path: String,
    hint: String? = null,
    onPathChange: (String) -> Unit,
    selectionMode: FileSelectionMode = FileSelectionMode.FILES_AND_DIRECTORIES
) {
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
        value = path, onValueChange = onPathChange, placeholder = {
            Text(
                text = hint ?: "点击此处输入目标软件的根目录，例如C:\\Program Files\\Adobe\\Adobe Photoshop 2024",
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
                    selectionMode = selectionMode,
                    onSelected = onPathChange
                )
            }
        },
        modifier = modifier
    )
}