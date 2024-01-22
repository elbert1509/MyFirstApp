package com.example.firstapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Detail : AppCompatActivity() {


    var detailDesc: TextView? = null;
    var detailTitle :TextView?=null;
    lateinit var detailImage : ImageView ;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailDesc = findViewById(R.id.detailDesc)
        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detailImage);

        val bundle = intent.extras
        if (bundle != null) {

            detailImage.setImageResource(bundle.getInt("Image"))

        }
    }
}