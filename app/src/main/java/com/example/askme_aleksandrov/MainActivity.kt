package com.example.askme_aleksandrov

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var fab: ExtendedFloatingActionButton

    private val adapter = MyAdapter()
    private var counter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (counter != 0) {
            for (i in 0..counter) {
                adapter.addItems(adapter.itemCount + 1)
            }
        }

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter
        fab = findViewById(R.id.fab)

        fab.setOnClickListener {
            adapter.addItems(adapter.itemCount + 1)
            recyclerView.smoothScrollToPosition(adapter.itemCount - 1)
            counter++
        }
        adapter.setItems(listOf())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt("count")
    }

}


