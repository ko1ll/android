package com.example.myapplication

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class  ProPlayerResponse (
    @Json(name = "avatarfull")
    val avatar: String,
    @Json(name = "profileurl")
    val profile_url: String,
    @Json(name = "personaname")
    val person_name: String,
)