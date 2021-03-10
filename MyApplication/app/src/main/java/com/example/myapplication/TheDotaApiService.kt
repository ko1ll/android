package com.example.myapplication


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header



interface TheDotaApiService{
    @GET("proPlayers")
    fun getPlayers() : Call<List<ProPlayerResponse>>
}