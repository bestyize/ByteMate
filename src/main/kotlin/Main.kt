import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.thewind.bytecode.core.FunctionPatcher
import com.thewind.bytecode.editor.ByteCodeAssist
import com.thewind.main.MainPage
import com.thewind.theme.AppTheme
import com.thewind.theme.LocalColors
import com.thewind.widget.TopAppBar
import javassist.ClassPool
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun main() = application {
    val windowSize = remember { DpSize(380.dp, 700.dp) }
    val windowState = rememberWindowState(size = windowSize, position = WindowPosition(Alignment.Center))
    Window(
        onCloseRequest = ::exitApplication,
        resizable = true,
        transparent = true,
        undecorated = true,
        alwaysOnTop = true,
        state = windowState,
        icon = painterResource("drawable/icon.webp")
    ) {
        AppTheme(darkTheme = true) {
            Column(
                modifier = Modifier.fillMaxSize().clip(shape = RoundedCornerShape(10.dp))
                    .border(width = 0.5.dp, color = LocalColors.current.Ga3, shape = RoundedCornerShape(10.dp))
            ) {
                WindowDraggableArea(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
                    TopAppBar(title = "ByteMate", onMin = {}, onClose = {
                        exitApplication()
                    })
                }
                MainPage()
            }
        }
    }
}