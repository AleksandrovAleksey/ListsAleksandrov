package com.example.askme_aleksandrov

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

private val items = ArrayList<Int>()
private var itemCounter:Int = 0

class MyAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
        if (position % 2 == 0) {
            holder.setBackground(Color.RED)
        } else {
            holder.setBackground(Color.BLUE)
        }
    }

    fun setItems(list: List<Int>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun addItems(item: Int) {
        items.add(item)
        itemCounter += 1
        notifyItemRangeInserted(itemCounter, items.size)
    }


}