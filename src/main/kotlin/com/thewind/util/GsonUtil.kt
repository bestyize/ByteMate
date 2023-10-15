package com.thewind.util

import com.google.gson.GsonBuilder
import java.lang.reflect.Type
import java.net.URLEncoder

private val gson by lazy {
    GsonBuilder().disableHtmlEscaping().create()
}

fun Any?.print() {
    println(toJson())
}


fun Any?.toJson(): String {
    this ?: return "null"
    return gson.toJson(this)
}

fun <T> String?.toObject(clazz: Class<T>): T? {
    this ?: return null
    runCatching {
        return gson.fromJson(this, clazz)
    }
    return null
}

fun <T> String?.toArray(type: Type): T? {
    this ?: return null
    runCatching {
        return gson.fromJson(this, type)
    }
    return null
}


val String.urlEncode: String
    get() = URLEncoder.encode(this, "UTF-8")