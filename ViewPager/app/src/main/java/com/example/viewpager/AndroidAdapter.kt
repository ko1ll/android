package com.example.viewpager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AndroidAdapter(private val androidList: List<Android>, private val itemClickListener: AndroidFragment)
    : RecyclerView.Adapter<AndroidAdapter.ViewHolder>(){
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_android, parent, false))
}

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(getItem(position),itemClickListener)
    }
    private fun getItem(position: Int)= androidList[position]
    override fun getItemCount() = androidList.size

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        private val image: ImageView = itemView.findViewById(R.id.image)
        private val title: TextView = itemView.findViewById(R.id.title)
        fun bind(version: Android, clickListener: OnItemClickListener){
            image.setImageResource(version.imageAndroid)
            title.text = version.title
            itemView.setOnClickListener {
                clickListener.onItemClicked(version,adapterPosition)
            }
        }
    }
}

interface OnItemClickListener{
    fun onItemClicked(android: Android, pos : Int)
}

