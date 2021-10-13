package ru.skillbranch.devintensive

import org.junit.Test

import ru.skillbranch.devintensive.models.User

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
        val user = User.makeUser("Ivan Petrovich")
        val user2 = User.makeUser("Oleg Ivanovich")
        val user3 = User.makeUser("Sergei Ivanovich")

    }
}