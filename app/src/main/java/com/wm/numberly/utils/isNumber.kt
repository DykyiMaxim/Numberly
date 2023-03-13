package com.wm.numberly.utils

fun String.isInteger(s: String): Boolean {
    return try {
        s.toLong()
        true
    } catch (e: NumberFormatException) {
        false
    }
}