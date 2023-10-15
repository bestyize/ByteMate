package com.thewind.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.ComposeWindow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.thewind.theme.LocalColors
import kotlinx.coroutines.launch
import javax.swing.JFileChooser

@Composable
fun ComposeFileChooser(
    modifier: Modifier,
    text: String = "选择文件夹",
    textColor: Color = LocalColors.current.Text1,
    textSize: TextUnit = 14.sp,
    title: String = "选择文件夹",
    selectionMode: FileSelectionMode = FileSelectionMode.FILES_AND_DIRECTORIES,
    onSelected: (String) -> Unit = {},
    onCancel: () -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    Text(text = text, color = textColor, fontSize = textSize, modifier = modifier.wrapContentSize().clickable {
        scope.launch {
            JFileChooser().apply {
                dialogTitle = title
                fileSelectionMode = selectionMode.mode
                val action = showDialog(ComposeWindow(), "选择")
                if (action == JFileChooser.APPROVE_OPTION) {
                    onSelected.invoke(selectedFile.absolutePath)
                } else {
                    onCancel.invoke()
                }
            }
        }
    })
}

enum class FileSelectionMode(val mode: Int) {
    FILES_ONLY(JFileChooser.FILES_ONLY),
    DIRECTORIES_ONLY(JFileChooser.DIRECTORIES_ONLY),
    FILES_AND_DIRECTORIES(JFileChooser.FILES_AND_DIRECTORIES)
}