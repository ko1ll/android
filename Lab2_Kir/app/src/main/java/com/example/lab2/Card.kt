package com.example.lab2

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class Card : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_android_detail, container, false)
        v.findViewById<TextView>(R.id.title).text=arguments!!.getString("title")
        v.findViewById<ImageView>(R.id.image).setImageResource(arguments!!.getString("logo")!!.toInt())
        v.findViewById<ImageView>(R.id.poster).setImageResource(arguments!!.getString("poster")!!.toInt())
        v.findViewById<TextView>(R.id.desc).text=arguments!!.getString("desc")
        v.findViewById<TextView>(R.id.rel2).text=arguments!!.getString("date")
        val btn : Button = v.findViewById(R.id.btn)
        btn.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(arguments!!.getString("url")));
            startActivity(browserIntent)
        }
        return v
    }


}