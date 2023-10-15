package com.thewind.bytecode.model

data class PatchClass(
    val patchMethods: List<PatchMethod> = emptyList(),
    val patchConstructors: List<PatchConstructor> = emptyList()
)