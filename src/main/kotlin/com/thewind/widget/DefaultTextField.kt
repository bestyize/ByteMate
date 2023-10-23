package com.thewind.widget

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.thewind.theme.LocalColors

@Composable
fun DefaultTextField(
    modifier: Modifier,
    text: String,
    hint: String = "",
    onTextChange: (String) -> Unit = {}
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
        value = text, onValueChange = onTextChange, placeholder = {
            Text(
                text = hint,
                fontSize = 14.sp
            )
        },
        modifier = modifier
    )
}