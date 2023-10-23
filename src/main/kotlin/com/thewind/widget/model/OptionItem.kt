package com.thewind.widget.model

data class OptionItem(
    val id: Int = 0,
    val name: String,
    val type: Int = 0,
    val icon: String? = null,
    val isSelected: Boolean = false,
    val subOptionItems: List<OptionItem> = emptyList()
)