package com.taetae98.codelab.data.ktor

import java.io.BufferedReader

fun Any.fileAsText(fileName: String): String {
    return javaClass.classLoader.getResourceAsStream(fileName)!!
        .bufferedReader()
        .use(BufferedReader::readText)
}
