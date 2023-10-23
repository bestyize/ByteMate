package com.thewind.database.repo

import com.thewind.database.model.DataColumn
import com.thewind.database.model.DataRow
import com.thewind.database.model.DataTable
import com.thewind.util.toJson
import java.io.File
import java.io.RandomAccessFile
import java.sql.DriverManager
import kotlin.system.measureTimeMillis


fun main() {
    val dbPath = "/Users/read/Desktop/mitmproxy_addons.db"

    val data = DatabaseReader.parseDatabase(dbPath)
    val cost = measureTimeMillis {
        DatabaseReader.exportToJson(data, "/Users/read/Desktop/json")
    }

    println("success, cost: $cost ms)")
}

object DatabaseReader {

    fun parseDatabase(dbFilePath: String): List<DataTable> {
        val conn = DriverManager.getConnection("jdbc:sqlite:$dbFilePath")
        val tables = mutableListOf<String>()
        val tableRs = conn.metaData.getTables(null, null, null, null)
        while (tableRs.next()) {
            if (tableRs.getString("TABLE_TYPE").equals("TABLE")) {
                tables.add(tableRs.getString("TABLE_NAME"))
            }
        }
        val statement = conn.createStatement()
        val tabs = mutableListOf<DataTable>()

        tables.forEach { tbName ->
            val columnRs = conn.metaData.getColumns(null, null, tbName, null)
            val columns = mutableListOf<DataColumn>()
            val rowData = mutableListOf<Any?>()
            while (columnRs.next()) {
                val columnName = columnRs.getString("COLUMN_NAME")
                val columnType = columnRs.getString("TYPE_NAME")
                columns.add(DataColumn(columnName, columnType))
                rowData.add(columnName)

            }
            tabs.add(DataTable(tableName = tbName, rows = listOf(DataRow(0, rowData)), columns = columns))
        }
        val res = mutableListOf<DataTable>()
        tabs.forEach { tb ->
            val resultSet = statement.executeQuery("SELECT * FROM ${tb.tableName}")
            val rows = tb.rows.toMutableList()
            var index = 1
            while (resultSet.next()) {
                val rowData = mutableListOf<Any?>()
                tb.columns.forEach { column ->
                    val value = resultSet.getObject(column.name)
                    rowData.add(value)
                }
                rows.add(DataRow(index++, rowData))
            }
            res.add(tb.copy(rows = rows))

        }
        return res
    }

    fun exportToJson(tables: List<DataTable>, savePath: String): Boolean {
        if (tables.isEmpty()) return false
        tables.forEach { table ->
            if (table.columns.isEmpty()) return@forEach
            val file = File("$savePath${File.separator}${table.tableName}.json")
            val folder = File(savePath)
            if (!folder.exists()) {
                if (!folder.mkdirs()) {
                    return false
                }
            }
            runCatching {
                RandomAccessFile(file, "rw").apply {
                    write(table.rows.map { it.toKv(table.columns) }.toJson().toByteArray())
                    close()
                }
            }
        }
        return true
    }

    fun exportToCsv(tables: List<DataTable>, savePath: String): Boolean {
        if (tables.isEmpty()) return false
        tables.forEach { table ->
            if (table.columns.isEmpty()) return@forEach
            val file = File("$savePath${File.separator}${table.tableName}.csv")
            val folder = File(savePath)
            if (!folder.exists()) {
                if (!folder.mkdirs()) {
                    return false
                }
            }
            val count = table.columns.size
            val sb = StringBuilder()
            table.rows.forEachIndexed { index, dataRow ->
                dataRow.data.forEachIndexed { i, data ->
                    sb.append(data.toJson())
                    if (i < count - 1) {
                        sb.append(",")
                    }
                }
                if (index != table.rows.size - 1) {
                    sb.append("\n")
                }
            }
            runCatching {
                RandomAccessFile(file, "rw").apply {
                    write(sb.toString().toByteArray())
                    close()
                }
            }
        }
        return true
    }

}


private fun DataRow.toKv(columns: List<DataColumn>): Map<String, Any?> {
    val map = mutableMapOf<String, Any?>()
    columns.forEachIndexed { index, dataColumn ->
        map[dataColumn.name] = data[index]
    }
    return map
}