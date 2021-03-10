package com.example.dev_intenseve.Models

import com.example.dev_intenseve.utils.Utils
import java.util.*

data class User (
    val id:String,
    var firstName:String?,
    var secondName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int = 0,
    var lastVisit:Date? = null,
    var isOnline:Boolean = false
){
    var introBit:String
    constructor(id:String,firstName: String?, lastName:String? ): this(
                id = id,
                firstName = firstName,
                secondName = lastName,
                avatar = null
            )
    constructor(id:String) : this(
        id = id,
        firstName = "John",
        lastName = "Doe"
    )
    init{
        introBit = getIntro()
        println("I'm alive.\n" +
                "${if(secondName==="Doe") "His name is $firstName $secondName" else "And his name is $firstName $secondName"}\n" +
                "${getIntro()}")
    }

    private fun getIntro() = "sdgsg" +
            "sfgsdfg" +
            "sfg" +
            "sfg" +
            ("sg" +
                    " $firstName $secondName"+
                    "${"\n\n\n\n"}"
                    ).trimIndent()
    fun printMe() =
        println("""
                    id: $id
                    firstName: $firstName
                    secondName: $secondName
                    avatar: $avatar
                    rating: $rating
                    respect: $respect
                    lastVisit: $lastVisit
                    isOnline: $isOnline
                """.trimIndent())
    companion object Factory{
        private var lastId : Int =  -1
        fun makeUser(fullName:String?): User {
            lastId++

            val (firstName,secondName) = Utils.parseFullName(fullName)

            return User(
                id = "$lastId",
                firstName = firstName,
                lastName = secondName,
            )
        }
    }
}