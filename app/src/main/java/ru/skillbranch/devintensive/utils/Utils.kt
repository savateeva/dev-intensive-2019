package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.extensions.toChar

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        //TODO FIX ME
        var delimiters = " "
        val parts:List<String>? = (fullName?:"No FullName").split(delimiters)
        val firstName =  parts?.getOrNull(index = 0)
        val lastName  =  parts?.getOrNull(index = 1)
        return Pair(firstName , lastName )
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var initialLastName = lastName?.getOrNull(0) ?: ""
        var initialFirstName = firstName?.getOrNull(0) ?: ""
        var initials:Pair<String?, String?> = Pair(initialFirstName.toString(), initialLastName.toString())



        return when(initials){
            Pair(null,null) -> null
            Pair("","") -> null
            else -> "${initials.first}${initials.second}"
        }
    }

    fun transliteration(paylod:String , devider:String = " "){
        var transliterationString  = paylod.lowercase();
        if(devider != null){
            transliterationString  = transliterationString.replace(" ",devider )
        }
        for (c in paylod){
            var cStr = c.toString().lowercase()

            var cReplacment = when(cStr){
            "а"-> "a"
            "б"-> "b"
            "в"-> "v"
            "г"-> "g"
            "д"-> "d"
            "е"-> "e"
            "ё"-> "e"
            "ж"-> "zh"
            "з"-> "z"
            "и"-> "i"
            "й"-> "i"
            "к"-> "k"
            "л"-> "l"
            "м"-> "m"
            "н"-> "n"
            "о"-> "o"
            "п"-> "p"
            "р"-> "r"
            "с"-> "s"
            "т"-> "t"
            "у"-> "u"
            "ф"-> "f"
            "х"-> "h"
            "ц"-> "c"
            "ч"-> "ch"
            "ш"-> "sh"
            "щ"-> "sh"
            "ъ"-> ""
            "ы"-> "i"
            "ь"-> ""
            "э"-> "e"
            "ю"-> "yu"
            "я"-> "ya"
             else -> cStr
            }
             cReplacment = if(c.isUpperCase()) cReplacment.uppercase() else cReplacment
             transliterationString = transliterationString.replace(cStr,cReplacment.toString() )
        }
        println(transliterationString)
    }
}