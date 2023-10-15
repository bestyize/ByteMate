package com.thewind.util

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.HttpURLConnection
import java.net.Proxy
import java.net.URL
import java.nio.charset.StandardCharsets

internal fun get(link: String?, headerMap: Map<String?, String?>? = null): String {
    if (link == null || !link.startsWith("http")) {
        return ""
    }
    val sb = StringBuilder()
    try {
        val url = URL(link)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "GET"
        conn.readTimeout = 5000
        conn.connectTimeout = 5000
        if (headerMap != null) {
            for (key in headerMap.keys) {
                conn.addRequestProperty(key, headerMap[key])
            }
        }
        val reader = BufferedReader(InputStreamReader(conn.inputStream))
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            sb.append(line)
        }
        reader.close()
        conn.disconnect()
    } catch (_: Exception) {

    }
    return sb.toString()
}

/**
 * 做POST请求
 *
 * @param link      请求地址
 * @param params    请求体，类似于keyword=十年&num=100这样的格式
 * @param headerMap 请求头
 * @return 请求结果
 */
internal fun post(link: String?, params: String?, headerMap: Map<String?, String?>?): String? {
    if (link == null || !link.startsWith("http")) {
        return ""
    }
    var response: String? = null
    try {
        val url = URL(link)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "POST"
        conn.doInput = true
        conn.doOutput = true
        conn.connectTimeout = 10000
        conn.readTimeout = 10000
        if (headerMap != null && headerMap.keys.size > 0) {
            for (key in headerMap.keys) {
                conn.setRequestProperty(key, headerMap[key])
            }
        }
        val writer = PrintWriter(conn.outputStream)
        writer.print(params)
        writer.flush()
        val reader = BufferedReader(InputStreamReader(conn.inputStream, StandardCharsets.UTF_8))
        var line: String?
        val sb = StringBuilder()
        while (reader.readLine().also { line = it } != null) {
            sb.append(line)
        }
        writer.close()
        reader.close()
        conn.disconnect()
        response = sb.toString()
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return response
}

internal fun getHeader(link: String?): Map<String, List<String>> {
    val headerMap: Map<String, List<String>> = HashMap()
    if (link == null || !link.startsWith("http")) {
        return headerMap
    }
    try {
        val url = URL(link)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "GET"
        conn.readTimeout = 10000
        conn.connectTimeout = 10000
        val headerField = conn.headerFields
        conn.disconnect()
        return headerField
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return headerMap
}

internal fun get(link: String?, headerMap: Map<String?, String?>?, proxy: Proxy?): String {
    if (link == null || !link.startsWith("http")) {
        return ""
    }
    val sb = StringBuilder()
    try {
        val url = URL(link)
        val conn = url.openConnection(proxy) as HttpURLConnection
        conn.requestMethod = "GET"
        conn.readTimeout = 3000
        conn.connectTimeout = 3000
        if (headerMap != null) {
            for (key in headerMap.keys) {
                conn.addRequestProperty(key, headerMap[key])
            }
        }
        val reader = BufferedReader(InputStreamReader(conn.inputStream))
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            sb.append(line)
        }
        reader.close()
        conn.disconnect()
    } catch (_: Exception) {
    }
    return sb.toString()
}

internal fun buildGetUrl(baseUrl: String, map: Map<String?, Any?>?): String {
    return baseUrl + buildGetBody(map)
}

private fun buildGetBody(map: Map<String?, Any?>?): String {
    if (map == null) {
        return ""
    }
    val sb = StringBuilder()
    sb.append("?")
    val keySet = map.keys
    for (str in keySet) {
        sb.append(str)
        sb.append("=")
        sb.append(map[str])
        sb.append("&")
    }
    sb.deleteCharAt(sb.length - 1)
    return sb.toString()
}