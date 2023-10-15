package com.thewind.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.thewind.theme.LocalColors

@Composable
fun NoticeDialog(
    title: String,
    content: String,
    okText: String = "确定",
    cancelText: String? = null,
    onOk: () -> Unit = {},
    onCancel: () -> Unit = {}
) {
    Dialog(properties = DialogProperties(usePlatformDefaultWidth = false), onDismissRequest = {
        onCancel.invoke()
    }) {
        Box(
            modifier = Modifier.fillMaxWidth(0.8f).wrapContentHeight()
                .background(color = LocalColors.current.Bg1, shape = RoundedCornerShape(15.dp))
                .clickable(
                    indication = null,
                    interactionSource = MutableInteractionSource(),
                    onClick = { onCancel.invoke() })
        ) {
            Column(
                modifier = Modifier.wrapContentSize()
                    .clickable(indication = null, interactionSource = MutableInteractionSource(), onClick = {})
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    color = LocalColors.current.Text1,
                    modifier = Modifier.padding(vertical = 10.dp).wrapContentSize().align(
                        Alignment.CenterHorizontally
                    )
                )
                Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(color = LocalColors.current.Bg3))
                val scrollableState = rememberScrollState()
                if (content.length > 80) {
                    var text by remember { mutableStateOf(content) }
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
                        textStyle = LocalTextStyle.current.copy(fontSize = 12.sp),
                        maxLines = 10,
                        value = text, onValueChange = {
                            text = it
                        },
                        modifier = Modifier.padding(10.dp).fillMaxWidth()
                    )
                } else {
                    SelectionContainer {
                        Text(
                            text = content,
                            fontSize = 14.sp,
                            color = LocalColors.current.Text2,
                            modifier = Modifier.padding(20.dp).wrapContentSize().align(
                                Alignment.CenterHorizontally
                            )
                        )

                    }
                }

                Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(color = LocalColors.current.Bg3))

                Row(
                    modifier = Modifier.padding(vertical = 15.dp).fillMaxWidth().wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    cancelText.takeIf { !it.isNullOrBlank() }?.let {
                        Text(
                            text = it,
                            fontSize = 16.sp,
                            color = LocalColors.current.Text1,
                            modifier = Modifier.wrapContentSize().weight(1f).clickable(
                                indication = null,
                                interactionSource = MutableInteractionSource(),
                                onClick = onCancel
                            )
                        )
                    }

                    Text(
                        text = okText,
                        fontSize = 16.sp,
                        color = LocalColors.current.Text1,
                        modifier = Modifier.wrapContentSize().weight(1f).clickable(
                            indication = null,
                            interactionSource = MutableInteractionSource(),
                            onClick = onOk
                        )
                    )
                }

            }
        }
    }
}
