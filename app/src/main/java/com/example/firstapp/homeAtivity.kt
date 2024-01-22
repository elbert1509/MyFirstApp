package com.example.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class homeAtivity : AppCompatActivity() {

    lateinit var spinner: Spinner
    lateinit var selecLan : String

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_ativity)

        spinner = findViewById(R.id.spinner2)
        val linearLayout = findViewById<RelativeLayout>(R.id.linearLayout)
        val linearLayout4 = findViewById<RelativeLayout>(R.id.linearLayout4)
        val layoutAnimaux = findViewById<RelativeLayout>(R.id.linearLayout3)
        val linearcamera = findViewById<RelativeLayout>(R.id.linearLayout5)
        val linearVideo = findViewById<RelativeLayout>(R.id.linearLayout6)
        val mp = MediaPlayer()

        val langageList = arrayOf(
            Langage(R.drawable.punu, "Punu"),
            Langage(R.drawable.myene, "Myene"),
            Langage(R.drawable.fang, "Fang"))


        val adapter = LangageAdapter(this, langageList)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                // val intentLangue : Intent = Intent(this@homeAtivity,nombreActivity::class.java)
                selecLan = langageList[p2].name
                // intentLangue.putExtra("currentLangage",selecLan)
                // startActivity(intentLangue)
                // Toast.makeText(this@homeAtivity,"Langue : $selecLan",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }


        linearLayout.setOnClickListener {
            //Toast.makeText(this, " 1", Toast.LENGTH_LONG).show()
            if (selecLan == "Punu") {
                mp.setDataSource(this,
                    Uri.parse("android.resource://" + this.packageName + "/" + R.raw.intro))
            }

            if (selecLan == "Myene") {
                mp.setDataSource(this,
                    Uri.parse("android.resource://" + this.packageName + "/" + R.raw.intro2))
            }
            //mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.intro))
            mp.prepare()
            mp.start()

            val intentToHome: Intent = Intent(this, nombreActivity::class.java)

            intentToHome.putExtra("ChoixLange", selecLan)
            startActivity(intentToHome)
        }

        linearLayout4.setOnClickListener {
            //  Toast.makeText(this, "2", Toast.LENGTH_LONG).show()
            Intent(this, LecteurMusiqueActivity::class.java).also {
                startActivity(it)
            }
        }

        layoutAnimaux.setOnClickListener {
            //  Toast.makeText(this, "3", Toast.LENGTH_LONG).show()
            Intent(this, animaux::class.java).also {
                startActivity(it)
            }
        }

        linearcamera.setOnClickListener {
            Toast.makeText(this, "4", Toast.LENGTH_LONG).show()
            Intent(this, Camera::class.java).also {
                startActivity(it)
            }

        }


        linearVideo.setOnClickListener {
            Toast.makeText(this, "5", Toast.LENGTH_LONG).show()
            Intent(this, Video::class.java).also {
                startActivity(it)
            }

        }
    }

}