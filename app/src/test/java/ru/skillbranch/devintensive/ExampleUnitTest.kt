package ru.skillbranch.devintensive

import org.junit.Test
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.TextMessage

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun test_instance() {
        val user = User("1", "Ivan", "Petrovich")
        val user2 = User("2", "Oleg", "Ivanovich")
        val user3 = User("3", "Sergei", "Ivanovich")

        println("$user $user2 $user3")

        user.printMy()
    }
    @Test
    fun test_factory() {
        val user = User.makeUser(null)
        val user2 = User.makeUser("Oleg Ivanovich")
        val user3 =user.copy("2", lastName = "Cean")
            print("$user \n$user3")
    }
    @Test
    fun test_decomposition(){
        val user = User.makeUser("Jon Week")
        fun getUserInfo() = user

        var (id, firstName, lastName) = getUserInfo()

        println("${user.component1()}, ${user.component2()}, $lastName")

    }
    @Test
    fun test_copy(){
        val user = User.makeUser("Jon Week")
        val user2 = user.copy(LastVisit = Date().add(-2,TimeUnits.SECOND))
        val user3 = user.copy(lastName = "Cean", LastVisit = Date().add(2, TimeUnits.HOUR))

        val user4 = user.copy(lastName = "Cean", LastVisit = Date().add(5, TimeUnits.HOUR))
        

        println("""
             ${user.LastVisit?.format()} 
            ${user2.LastVisit?.format()}
            ${user3.LastVisit?.format()}
            ${user4.LastVisit?.format()}
        """.trimIndent())

    }

    @Test
    fun test_dataq_mapping(){
        val user = User.makeUser("Savateeva")

        val userView = user.toUserView()

        userView.printMe()
        println(Utils.transliteration("Иванова Пе тр Сергеевич", "_"))
    }

    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("Savateeva Ludmila")
        val textMessage = BaseMessage.makeMessage(user,Chat("0"),date = Date(), type = "text", payload = "any text message")
        val imageMessage = BaseMessage.makeMessage(user,Chat("0"),date = Date(), type = "image", payload = "any image url")
        println(textMessage.formatMessage())
        println(imageMessage.formatMessage())
    }
}