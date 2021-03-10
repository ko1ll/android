package com.example.lab2



import Page
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), AndroidFragment.OnItemClickListenerSecond {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.androidList, AndroidFragment.newInstance())
            .commit()
        supportFragmentManager
            .executePendingTransactions()
    }


    override fun onItemClickSecond(android: Android, pos: Int) {
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

