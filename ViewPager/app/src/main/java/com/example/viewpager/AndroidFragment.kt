package com.example.viewpager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView


class AndroidFragment : Fragment() , OnItemClickListener{
    private var listener: OnItemClickListenerSecond? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_app, container, false)
        val list = v.findViewById<RecyclerView>(R.id.androidList)
        val adapter = context
                ?.let{
            AndroidAdapter(
                    DataStorage.getVersionsList(),
                    this)
                }
        list.adapter = adapter
        return v
    }


    companion object {
        fun newInstance() = AndroidFragment()
    }

    override fun onItemClicked(android: Android, pos: Int) {
        listener?.onItemClickSecond(pos,android)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnItemClickListenerSecond)
            listener = context
    }
    interface OnItemClickListenerSecond{
        fun onItemClickSecond(position: Int, item: Android)
    }

    override fun onDetach() {
        super.onDetach()
    }
}

