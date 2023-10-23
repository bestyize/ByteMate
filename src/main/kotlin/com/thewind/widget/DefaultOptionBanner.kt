package com.thewind.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thewind.theme.LocalColors

@Composable
fun DefaultOptionBanner(
    modifier: Modifier = Modifier.padding(horizontal = 20.dp).fillMaxWidth().wrapContentHeight()
        .background(color = LocalColors.current.AdobeBlue, shape = RoundedCornerShape(5.dp)),
    title: String,
    titleColor: Color = LocalColors.current.AdobeMediumBlue,
    icon: ImageVector = Icons.Default.ArrowForward,
    onClick: () -> Unit = {}
) {

    Box(modifier = modifier.clickable {
            onClick.invoke()
        }) {
        Text(
            text = title,
            color = titleColor,
            fontSize = 15.sp,
            modifier = Modifier.wrapContentSize().padding(horizontal = 15.dp, vertical = 10.dp)
        )
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = titleColor,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp).size(24.dp).align(Alignment.CenterEnd)

        )
    }
}