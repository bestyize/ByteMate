package com.thewind.copilotmate.editor

import com.thewind.copilotmate.model.PatchClass
import com.thewind.copilotmate.model.PatchedClass
import com.thewind.copilotmate.model.entryName
import javassist.ClassPool
import javassist.CtNewConstructor
import java.io.File
import java.util.jar.JarOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


object ByteCodeAssist {

    fun modifyClass(
        jarPath: String,
        className: String,
        patchClass: PatchClass
    ): PatchedClass {
        ClassPool.getDefault().insertClassPath(jarPath)
        val classToModify = ClassPool.getDefault().getCtClass(className)
        patchClass.patchConstructors.forEach { data ->
            val paramsTypes = data.parameterTypes.map {
                ClassPool.getDefault().get(it)
            }.toTypedArray()
            var cont = try {
                classToModify.getDeclaredConstructor(paramsTypes)
            } catch (_: Exception) {
                null
            }
            if (cont == null) {
                cont = CtNewConstructor.make(paramsTypes, null, "{ ${data.body} }", classToModify)
                classToModify.addConstructor(cont)
            } else {
                cont.setBody("{ ${data.body} }")
            }

        }
        patchClass.patchMethods.forEach { data ->
            val methodToModify = classToModify.getDeclaredMethod(data.name)
            methodToModify.setBody(data.body)
        }
        val exportClassFolder = File(jarPath).parent + File.separator + "crack"
        classToModify.writeFile(exportClassFolder)
        val path = exportClassFolder + File.separator + className.replace(".", File.separator) + ".class"
        return PatchedClass(className, path)
    }

    fun packageClassToJar(originalJarPath: String, patchedList: List<PatchedClass>): String? {
        val newJarPath = "$originalJarPath.crack.jar"
        try {
            val entrySet = patchedList.map { it.entryName }.toSet()
            // Create a new JAR file
            val newJar = JarOutputStream(File(newJarPath).outputStream())

            // Copy entries from the original JAR to the new JAR
            ZipInputStream(File(originalJarPath).inputStream()).use { originalZip ->
                while (true) {
                    val entry = originalZip.nextEntry ?: break
                    if (!entrySet.contains(entry.name)) {
                        newJar.putNextEntry(ZipEntry(entry.name))
                        newJar.write(originalZip.readBytes())
                        newJar.closeEntry()
                    }

                }
            }

            // Add the new class to the new JAR
            patchedList.forEach { data ->
                newJar.putNextEntry(ZipEntry(data.entryName))
                File(data.classFilePath).inputStream().use { input ->
                    newJar.write(input.readBytes())
                }
            }

            newJar.closeEntry()
            // Close the new JAR file
            newJar.close()
        } catch (e: Exception) {
            return null
        }
        return newJarPath
    }

    fun makeClassName(className: String, innerClassName: String) = "$className\$$innerClassName"
}