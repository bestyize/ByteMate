package com.thewind.copilotmate.model

data class PatchedClass(val className: String, val classFilePath: String)

val PatchedClass.entryName: String
    get() = className.replace(".", "/") + ".class"
