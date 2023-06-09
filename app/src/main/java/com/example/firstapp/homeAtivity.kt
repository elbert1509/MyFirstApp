package com.example.firstapp

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_ativity)

        spinner =findViewById(R.id.spinner2)
        val linearLayout2 = findViewById<LinearLayout>(R.id.linearLayout2)
        val linearLayout3 = findViewById<LinearLayout>(R.id.linearLayout3)
        val linearLayout4 = findViewById<LinearLayout>(R.id.linearLayout4)
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        val mp = MediaPlayer()

        val langageList = arrayOf(
            Langage(R.drawable.punu,"Punu"),
            Langage(R.drawable.myene,"Myene"),
            Langage(R.drawable.fang, "Fang"))


        val adapter = LangageAdapter(this,langageList)
        spinner.adapter = adapter

       spinner.onItemSelectedListener = object  : AdapterView.OnItemSelectedListener{
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


        linearLayout.setOnClickListener{
            //Toast.makeText(this, " 1", Toast.LENGTH_LONG).show()
            if(selecLan =="Punu")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.intro))
            }

            if(selecLan =="Myene")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.intro2))
            }
            //mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.intro))
            mp.prepare()
            mp.start()

            val intentToHome : Intent = Intent(this, nombreActivity::class.java)

            intentToHome.putExtra("ChoixLange", selecLan)
            startActivity(intentToHome)
        }

        linearLayout2.setOnClickListener{
          //  Toast.makeText(this, "2", Toast.LENGTH_LONG).show()
            Intent(this, panierActivity::class.java ).also {
                startActivity(it)
            }
        }

        linearLayout3.setOnClickListener{
          //  Toast.makeText(this, "3", Toast.LENGTH_LONG).show()
        }

        linearLayout4.setOnClickListener{
            Toast.makeText(this, "4", Toast.LENGTH_LONG).show()
        }

    }


}