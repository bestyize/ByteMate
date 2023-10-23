package com.thewind.database.model

data class DataTable(
    val tableName: String = "",
    val columns: List<DataColumn> = emptyList(),
    val rows: List<DataRow> = emptyList()
)