package com.example.dev_intenseve.Models

class UserView(
    val id :String,
    val fullName:String,
    val nickName:String,
    var avatar:String? = null,
    var status: String? = "offline",
    val initials:String?
) {
}