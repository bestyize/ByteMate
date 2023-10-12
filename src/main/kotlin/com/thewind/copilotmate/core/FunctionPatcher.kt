package com.thewind.copilotmate.core

import com.thewind.copilotmate.editor.ByteCodeAssist
import com.thewind.copilotmate.editor.ByteCodeAssist.makeClassName
import com.thewind.copilotmate.model.PatchClass
import com.thewind.copilotmate.model.PatchConstructor
import com.thewind.copilotmate.model.PatchMethod
import com.thewind.copilotmate.model.PatchedClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun main() = withContext(Dispatchers.IO) {

    val jarPath = "E:\\core.jar"
    println("start generate class")
    val patchedList = listOf(
        FunctionPatcher.mockLoginStatus(jarPath),
//        FunctionPatcher.mockLoginStatusParser(jarPath),
        FunctionPatcher.enableAllCopilotFeature(jarPath),
//        FunctionPatcher.mockLoginTypeParser(jarPath)
    )
    println("start pack to jar")
    ByteCodeAssist.packageClassToJar(originalJarPath = jarPath, patchedList = patchedList)
    println("end pack to jar")
}

object FunctionPatcher {

    fun mockLoginStatusParser(jarPath: String): PatchedClass {
        val className = "com.github.copilot.lang.agent.commands.AuthStatusResult\$Status"
        return ByteCodeAssist.modifyClass(
            jarPath = jarPath,
            className = className,
            patchClass = PatchClass(
                patchMethods = listOf(
                    PatchMethod("findById", "return $className.Ok; ")
                )
            )
        )
    }

    fun mockLoginTypeParser(jarPath: String): PatchedClass {
        val className = "com.github.copilot.lang.agent.commands.AuthStatusResult\$TypeAdapter"
        return ByteCodeAssist.modifyClass(
            jarPath = jarPath,
            className = className,
            patchClass = PatchClass(
                patchMethods = listOf(
                    PatchMethod(
                        "deserialize",
                        "return new com.github.copilot.lang.agent.commands.AuthStatusResult(null, null, null);"
                    )
                )
            )
        )
    }

    fun mockLoginStatus(jarPath: String): PatchedClass {
        val className = "com.github.copilot.lang.agent.commands.AuthStatusResult"
        return ByteCodeAssist.modifyClass(
            jarPath = jarPath,
            className = className,
            patchClass = PatchClass(
                patchMethods = listOf(
                    PatchMethod("setStatus", "this.status = ${makeClassName(className, "Status")}.Ok;"),
                    PatchMethod(
                        "setUser"
                    ),
                    PatchMethod("setErrorMessage"),
                    PatchMethod("getErrorMessage", "return null;"),
                    PatchMethod("isSignedIn", "return true;"),
                    PatchMethod("isUnauthorized", "return false;"),
                    PatchMethod("getStatus", "return ${makeClassName(className, "Status")}.Ok;"),
                    PatchMethod(
                        "getUser", """
                        return "yize";
                    """.trimIndent()
                    ),
                    PatchMethod("isError", "return false;"),
                    PatchMethod("forFailedToGetToken", """
                        return new com.github.copilot.lang.agent.commands.AuthStatusResult(${makeClassName(className, "Status")}.Ok, "yize", null);
                    """.trimIndent()),
                    PatchMethod("forError", """
                        return new com.github.copilot.lang.agent.commands.AuthStatusResult(${makeClassName(className, "Status")}.Ok, "yize", null);
                    """.trimIndent())
                ),
                patchConstructors = listOf(
                    PatchConstructor(
                        parameterTypes = listOf(
                            makeClassName(className, "Status"),
                            String::class.java.name,
                            String::class.java.name
                        ),
                        body = """
                            this.user = "yize";
                            this.status = ${makeClassName(className, "Status")}.Ok;
                            this.errorMessage = null;
                        """.trimIndent()
                    )
                )
            )
        )
    }

    fun enableAllCopilotFeature(jarPath: String): PatchedClass {
        val classPath = "com.github.copilot.featureflags.CopilotFeatureFlags"
        val methodNames = listOf(
            "isSelfSignedCertificatesEnabled",
            "isRestrictedTelemetryEnabled",
            "isSnippyEnabled",
            "isChatEnabled",
            "isChatJetBrainsEnabled"
        )
        return ByteCodeAssist.modifyClass(jarPath = jarPath, className = classPath, patchClass = PatchClass(
            patchMethods = methodNames.map { method ->
                PatchMethod(
                    name = method,
                    body = "return true;"
                )
            }
        ))
    }


    fun mockAgentGitHubService(jarPath: String): PatchedClass {
        val classPath = "com.github.copilot.lang.agent.AgentGitHubService"
        return ByteCodeAssist.modifyClass(
            jarPath = jarPath,
            className = classPath,
            patchClass = PatchClass(
                patchMethods = listOf(
                    PatchMethod("isSignedIn", "return true;"),
                    PatchMethod(
                        "refreshStatus", """
                        this.status = new com.github.copilot.lang.agent.commands.AuthStatusResult(null, null, null);
                    """.trimIndent()
                    ),
                    PatchMethod(
                        "getStatus",
                        "return new com.github.copilot.lang.agent.commands.AuthStatusResult(null, null, null);"
                    ),
                    PatchMethod(
                        "confirmSignIn",
                        "return new com.github.copilot.lang.agent.commands.AuthStatusResult(null, null, null);"
                    )
                )
            )
        )
    }
}