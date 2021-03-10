package com.example.dev_intenseve.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?,String?>{
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val secondName = parts?.getOrNull(1)
        return firstName to secondName
    }
}