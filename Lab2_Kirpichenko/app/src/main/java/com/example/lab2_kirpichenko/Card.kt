package com.example.lab2_kirpichenko

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

class Card : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val v = inflater.inflate(R.layout.fragment_android_detail,container,false)
        val versions = DataStorage.getVersionsList()
        val data = versions[arguments!!.getInt("pos")]

        val poster = v.findViewById<ImageView>(R.id.poster)
        val image = v.findViewById<ImageView>(R.id.image)
        val name = v.findViewById<TextView>(R.id.title)
        val date = v.findViewById<TextView>(R.id.rel2)
        val desc = v.findViewById<TextView>(R.id.desc)
        val btm = v.findViewById<Button>(R.id.btm)

        if(arguments != null){
            poster.setImageResource(data.poster)
            image.setImageResource(data.imageAndroid)
            name.text = data.title
            date.text = data.s1
            desc.text = data.s
            btm.setOnClickListener {
                val url = Intent(Intent.ACTION_VIEW, Uri.parse(data.s2))
                startActivity(url)
            }
        }
        return v
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }


    override fun onDetach() {
        super.onDetach()
    }
}