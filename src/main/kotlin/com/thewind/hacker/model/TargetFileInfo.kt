package com.thewind.hacker.model

data class TargetFileInfo(val fullPath: String, val targetOffset: Set<Long> = emptySet())