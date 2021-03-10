package com.example.lab2_kirpichenko

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AndroidDetails : AppCompatActivity(){
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailsactivity)
            val image : ImageView = findViewById(R.id.image)
            image.setImageResource(intent.getStringExtra("img").toInt())
            val title : TextView = findViewById(R.id.title)
            title.text = intent.getStringExtra("title")
            val poster : ImageView = findViewById(R.id.poster)
            poster.setImageResource(intent.getStringExtra("poster").toInt())
            val description : TextView = findViewById(R.id.desc)
            description.text = intent.getStringExtra("desc")
            val release : TextView = findViewById(R.id.rel2)
            release.text = intent.getStringExtra("date")
            val btm : Button = findViewById(R.id.btm)
            btm.setOnClickListener {
                val url = intent.getStringExtra("youtube")
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
    }
}