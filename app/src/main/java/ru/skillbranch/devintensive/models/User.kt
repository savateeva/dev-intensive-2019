package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 *
 */
data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val LastVisit: Date? = null,
    val isOnline: Boolean = false
) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName, lastName = lastName, avatar = null
    )
    constructor(id: String):this(id, firstName = "John", lastName = "Doe $id")

    init {
       // println("It's user $firstName $lastName ")
    }

    fun printMy():Unit{
        println("""new method
            $id
            $firstName
            $lastName
            $avatar
            $rating
            $respect
            $LastVisit
            $LastVisit
        """.trimIndent())
    }

    companion object Factory{
        private var lastId: Int = -1

        fun makeUser(fullName:String?): User{
            ++lastId
            var delimiters = " "
            val parts:List<String>? = fullName?.split(delimiters)
            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(id = "$lastId", firstName = firstName , lastName = lastName )
        }
    }

}