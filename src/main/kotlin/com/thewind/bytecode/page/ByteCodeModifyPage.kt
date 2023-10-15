package com.thewind.bytecode.page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thewind.bytecode.core.FunctionPatcher
import com.thewind.bytecode.editor.ByteCodeAssist
import com.thewind.theme.LocalColors
import javassist.ClassPool
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Preview
@Composable
fun ByteCodeModifyPage() {

    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier.wrapContentSize().align(Alignment.Center)
                .background(color = LocalColors.current.AdobeBlue, shape = RoundedCornerShape(1000.dp))
        ) {
            Text(
                text = "点此尝试修改jar包",
                fontSize = 18.sp,
                color = LocalColors.current.AdobeMediumBlue,
                modifier = Modifier.padding(15.dp).wrapContentSize().align(Alignment.Center).clickable {
                    scope.launch {
                        patch()
                    }
                }
            )
        }
    }
}

suspend fun patch() = withContext(Dispatchers.IO) {

    val jarPath = "E:\\core.jar"
    println("start generate class")
    ClassPool.getDefault()
        .insertClassPath("C:\\Users\\read\\AppData\\Local\\Programs\\IntelliJ IDEA Ultimate\\lib\\app-client.jar")
    ClassPool.getDefault()
        .insertClassPath("C:\\Users\\read\\AppData\\Local\\Programs\\IntelliJ IDEA Ultimate\\lib\\util-8.jar")
    val patchedList = listOf(
        FunctionPatcher.mockLoginStatus(jarPath),
        FunctionPatcher.mockLoginStatusParser(jarPath),
        FunctionPatcher.enableAllCopilotFeature(jarPath),
        FunctionPatcher.mockLoginTypeParser(jarPath),
        FunctionPatcher.mockAgentGitHubService(jarPath)
    )
    println("start pack to jar")
    ByteCodeAssist.packageClassToJar(originalJarPath = jarPath, patchedList = patchedList)
    println("end pack to jar")
}
