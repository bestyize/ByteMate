import com.thewind.copilotmate.core.FunctionPatcher
import com.thewind.copilotmate.editor.ByteCodeAssist
import javassist.ClassPool
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//fun main() = application {
//    Window(onCloseRequest = ::exitApplication) {
//        App()
//    }
//}

suspend fun main() = withContext(Dispatchers.IO) {

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
