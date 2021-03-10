package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val theCatApiService = NetworkModule.theDota2ApiService

    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var playersRv : RecyclerView
    private lateinit var playersAdapter: PlayersAdapter

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeRefresh = findViewById(R.id.swipe_refresh)

        playersRv = findViewById(R.id.cats_rv)
        playersRv.setHasFixedSize(true)

        playersAdapter = PlayersAdapter()
        playersRv.adapter = playersAdapter

        progressBar = findViewById(R.id.loading)
    }

    override fun onResume() {
        super.onResume()
            progressBar.isVisible = true
            val playersCall : Call<List<ProPlayerResponse>> = theCatApiService.getPlayers()
                playersCall.enqueue(object : Callback<List<ProPlayerResponse>>{
                @SuppressLint("ResourceType")
                override fun onFailure(call: Call<List<ProPlayerResponse>>, t: Throwable) {
                    progressBar.isVisible = false
                    toast(5)
                }

                override fun onResponse(
                    call: Call<List<ProPlayerResponse>>,
                    response: Response<List<ProPlayerResponse>>
                ) {
                    val players : List<ProPlayerResponse> = response.body() ?: emptyList()
                    progressBar.isVisible =false
                    playersAdapter.addPlayers(players)
                }
            })


        swipeRefresh.setOnRefreshListener {
            playersAdapter.clearPlayers()
                swipeRefresh.isRefreshing = true
                val playersCall: Call<List<ProPlayerResponse>> = theCatApiService.getPlayers()
                    playersCall.enqueue(object : Callback<List<ProPlayerResponse>>{
                    @SuppressLint("ResourceType")
                    override fun onFailure(call: Call<List<ProPlayerResponse>>, t: Throwable) {
                        swipeRefresh.isRefreshing = false
                        toast(5)
                    }

                    override fun onResponse(
                        call: Call<List<ProPlayerResponse>>,
                        response: Response<List<ProPlayerResponse>>
                    ) {
                        val players: List<ProPlayerResponse> = response.body() ?: emptyList()
                        swipeRefresh.isRefreshing = false
                        playersAdapter.addPlayers(players)
                    }
                })
        }
    }
}