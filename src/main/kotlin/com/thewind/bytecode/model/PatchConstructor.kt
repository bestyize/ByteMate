package com.thewind.bytecode.model

data class PatchConstructor(val parameterTypes: List<String> = listOf(), val body: String = "")