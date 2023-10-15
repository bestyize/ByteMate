package com.thewind.bytecode.model

data class PatchedClass(val className: String, val classFilePath: String)

val PatchedClass.entryName: String
    get() = className.replace(".", "/") + ".class"
