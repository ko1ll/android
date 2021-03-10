package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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
