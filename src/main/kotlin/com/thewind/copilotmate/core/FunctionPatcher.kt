package com.thewind.copilotmate.core

import com.thewind.copilotmate.editor.ByteCodeAssist
import com.thewind.copilotmate.editor.ByteCodeAssist.makeClassName
import com.thewind.copilotmate.model.PatchClass
import com.thewind.copilotmate.model.PatchConstructor
import com.thewind.copilotmate.model.PatchMethod
import com.thewind.copilotmate.model.PatchedClass
import javassist.ClassPool
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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
                    PatchMethod(
                        "forFailedToGetToken", """
                        return new com.github.copilot.lang.agent.commands.AuthStatusResult(${
                            makeClassName(
                                className,
                                "Status"
                            )
                        }.Ok, "yize", null);
                    """.trimIndent()
                    ),
                    PatchMethod(
                        "forError", """
                        return new com.github.copilot.lang.agent.commands.AuthStatusResult(${
                            makeClassName(
                                className,
                                "Status"
                            )
                        }.Ok, "yize", null);
                    """.trimIndent()
                    )
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
                    ),
                    PatchConstructor(
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
                        this.status = com.github.copilot.lang.agent.commands.AuthStatusResult.forFailedToGetToken();
                    """.trimIndent()
                    ),
                    PatchMethod(
                        "getStatus",
                        "return com.github.copilot.lang.agent.commands.AuthStatusResult.forFailedToGetToken();"
                    ),
                    PatchMethod(
                        "confirmSignIn",
                        "return com.github.copilot.lang.agent.commands.AuthStatusResult.forFailedToGetToken();"
                    )
                )
            )
        )
    }
}