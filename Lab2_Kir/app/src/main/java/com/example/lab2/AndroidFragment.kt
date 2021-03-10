package com.example.lab2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class AndroidFragment : Fragment() , OnItemClickListener{
    private var listener: OnItemClickListenerSecond? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_app, container, false)
        val list = v.findViewById<RecyclerView>(R.id.androidList)
        val adapter = context?.let{AndroidAdapter(DataStorage.getVersionsList(), this)}
        list.adapter = adapter
        return v
    }


    companion object {
        fun newInstance() = AndroidFragment()
    }


    interface OnItemClickListenerSecond{
        fun onItemClickSecond(android : Android, pos : Int)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnItemClickListenerSecond)
            listener = context
    }
    override fun onItemClicked(android: Android, pos: Int) {
        listener?.onItemClickSecond(android,pos)
    }

}

