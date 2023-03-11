package com.example.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val connect = findViewById<ImageButton>(R.id.imageButton2)
        connect.setOnClickListener { view: View ->
          //  Toast.makeText(this, "Entrez dans le Jeu", Toast.LENGTH_SHORT).show()

            val intentToHome : Intent = Intent(this, homeAtivity::class.java)
            startActivity(intentToHome)

        }
    }
}