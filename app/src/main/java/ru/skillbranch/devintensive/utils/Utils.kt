package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        //TODO FIX ME
        var delimiters = " "
        val parts:List<String>? = (fullName?:"No FullName").split(delimiters)
        val firstName =  parts?.getOrNull(index = 0)
        val lastName  =  parts?.getOrNull(index = 1)
        return Pair(firstName , lastName )
    }
}