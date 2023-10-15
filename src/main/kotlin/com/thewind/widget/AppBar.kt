package com.thewind.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.thewind.theme.LocalColors

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    textColor: Color = LocalColors.current.Text1,
    backgroundColor: Color = LocalColors.current.AdobeDark,
    onMin: () -> Unit = {},
    onClose: () -> Unit = {}
) {

    Box(
        modifier = modifier.fillMaxWidth().wrapContentHeight()
            .background(color = backgroundColor)
    ) {
        title.takeIf { !it.isNullOrBlank() }?.let { title ->
            Text(
                text = title,
                modifier = Modifier.padding(vertical = 10.dp).wrapContentSize().align(Alignment.Center),
                color = textColor
            )
        }

        Row(
            modifier = Modifier.padding(vertical = 10.dp).wrapContentSize().align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.height(20.dp)
                    .clickable(interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = {
                            onMin.invoke()
                        }),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier.height(1.5.dp).background(color = LocalColors.current.Text1).width(10.dp)
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                tint = LocalColors.current.Text1,
                modifier = Modifier.padding(end = 8.dp).size(20.dp)
                    .clickable(interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = {
                            onClose.invoke()
                        })
            )
        }
        Spacer(
            modifier = Modifier.background(color = LocalColors.current.Bg3).height(1.dp).fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }
}