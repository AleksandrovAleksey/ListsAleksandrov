package com.example.askme_aleksandrov

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val text = view.findViewById<TextView>(R.id.Text_1)
    val image = view.findViewById<ImageView>(R.id.image_view)

    fun bind(number: Int){
        text.text = "$number"
    }

    fun setBackground(color: Int) {
        image.setBackgroundColor(color)
    }
}