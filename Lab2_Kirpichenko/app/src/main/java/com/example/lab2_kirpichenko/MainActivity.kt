package com.example.lab2_kirpichenko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.*

class MainActivity : AppCompatActivity(), OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.androidList, AndroidFragment.newInstance())
                .commit()
        supportFragmentManager
                .executePendingTransactions()

//        val android = DataStorage.getVersionsList()
//        val adapter = AndroidAdapter(this, android, this)
//        val list = findViewById<RecyclerView>(R.id.recycleList)
//        list.adapter = adapter
//
//        val decoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
//        decoration.setDrawable(ContextCompat.getDrawable(this, R.color.grey)!!)
//        list.addItemDecoration(decoration)
    }


    override fun onItemClicked(android: Android, pos: Int) {
        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
        val page = Page()
        val bnd = Bundle()
        bnd.putInt("pos",pos)
        page.arguments = bnd
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.androidList, page)
                .addToBackStack(null)
                .commit()

    }
}
