package com.example.firstapp

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Video : AppCompatActivity() {

    lateinit var  recyclerViewVideo : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        recyclerViewVideo = findViewById(R.id.recyclerView)

        val items = listOf(

            DataClass("Olele","Olele", R.drawable.olele),
            DataClass("Amina","Olele", R.drawable.amina),
            DataClass("Babyshark","Olele", R.drawable.babyshark),
        )

        recyclerViewVideo.apply {

            layoutManager=LinearLayoutManager(this@Video)
            adapter = ListVideoAdapter(items)

        }

        recyclerViewVideo.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                super.getItemOffsets(outRect, view, parent, state)

                // Définir la marge souhaitée
                outRect.set(0,0,0,0)
            }
        })


    }
}