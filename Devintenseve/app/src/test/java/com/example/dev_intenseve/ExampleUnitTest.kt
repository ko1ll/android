package com.example.dev_intenseve

import com.example.dev_intenseve.Models.User
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun test_instance(){
        val user1 = User("1")
        val user2 = User("2","Jhon","Smth")

//        val user2 = User("2","Jhon","Wick")
//        val user3 = User("3","Jhon","Silver",null, lastVisit = Date(), isOnline = true)
//
        user1.printMe()
//        user2.printMe()
//        user3.printMe()

        println("$user1")
    }
    @Test
    fun test_fac(){
//        val user = User.makeUser("Jhon Cena")
//        val user1 = User.makeUser("Jhon1 Cena");
        val user = User.makeUser("Jhon2 Cena");
        val user2 = user.copy(id="2",secondName = "Wick")
        println("$user\n$user2")
    }
    @Test
    fun test_decomp(){
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val (id, firstName,secondName) = getUserInfo()

        println("$id,$firstName,$secondName")
    }
    @Test
    fun test_copy(){
        val user = User.makeUser("John Wick")
        val user2 = user.copy()

        if(user == user2){
            println("equals")
        }
    }
}