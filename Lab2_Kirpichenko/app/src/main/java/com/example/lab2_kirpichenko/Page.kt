package com.example.lab2_kirpichenko

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.lab2.R


//Pager
private var POS_MAX = DataStorage.getVersionsList().size
private var POS_NOW: Int = 0
class Page : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            POS_NOW = it.getInt("pos")
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_screen_slide,container,false)
        val vp =                .findViewById<ViewPager2>(R.id.pager)
        vp.adapter = Adapter(this)
        vp.currentItem = POS_NOW
        return vp
    }
    private class Adapter(act : Page) : FragmentStateAdapter(act){
        override fun getItemCount() = POS_MAX

        override fun createFragment(position: Int): Fragment {
           val bnd = Bundle()
            bnd.putString("title",DataStorage.getVersionsList()[position].title)
            bnd.putString("release",DataStorage.getVersionsList()[position].s1)
            bnd.putString("logo",DataStorage.getVersionsList()[position].imageAndroid.toString())
            bnd.putString("poster",DataStorage.getVersionsList()[position].poster.toString())
            bnd.putString("desc",DataStorage.getVersionsList()[position].s)
            bnd.putString("url",DataStorage.getVersionsList()[position].s2)
            val card = Card()
            card.arguments = bnd
            return card
        }

    }
    companion object {
        fun newInstance() = Page()
    }
}