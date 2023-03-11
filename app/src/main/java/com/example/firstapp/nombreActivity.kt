package com.example.firstapp

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

class nombreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nombre)

        val nbr1 = findViewById<ImageButton>(R.id.imageButton01)
        val nbr2 = findViewById<ImageButton>(R.id.imageButton02)
        val nbr3 = findViewById<ImageButton>(R.id.imageButton03)
        val nbr4 = findViewById<ImageButton>(R.id.imageButton04)
        val nbr5 = findViewById<ImageButton>(R.id.imageButton05)
        val nbr6 = findViewById<ImageButton>(R.id.imageButton06)
        val nbr7 = findViewById<ImageButton>(R.id.imageButton07)
        val nbr8 = findViewById<ImageButton>(R.id.imageButton08)
        val nbr9 = findViewById<ImageButton>(R.id.imageButton09)
        val nbr10 = findViewById<ImageButton>(R.id.imageButton10)
        val mp = MediaPlayer.create(this,R.raw.p001)

        var cuLanguage = intent.getStringExtra("ChoixLange")


        nbr1.setOnClickListener { view: View ->

            mp.reset()
            if (cuLanguage=="Punu")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.p001))
            }

            if (cuLanguage=="Myene")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.m01))
            }



            mp.prepare()
            mp.start()
            Toast.makeText(this,"Langue : $cuLanguage",Toast.LENGTH_SHORT).show()

        }

        nbr2.setOnClickListener { view: View ->



            mp.reset()
            if (cuLanguage=="Punu")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.p002))
            }

            if (cuLanguage=="Myene")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.m02))
            }
            mp.prepare()
            mp.start()

        }
        nbr3.setOnClickListener { view: View ->

            mp.reset()
            if (cuLanguage=="Punu")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.p003))
            }

            if (cuLanguage=="Myene")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.m03))
            }
            mp.prepare()
            mp.start()

        }

        nbr4.setOnClickListener { view: View ->

            mp.reset()
            if (cuLanguage=="Punu")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.p004))
            }

            if (cuLanguage=="Myene")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.m04))
            }
            mp.prepare()
            mp.start()

        }

        nbr5.setOnClickListener { view: View ->

            mp.reset()
            if (cuLanguage=="Punu")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.p005))
            }

            if (cuLanguage=="Myene")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.m05))
            }
            mp.prepare()
            mp.start()
        }

        nbr6.setOnClickListener { view: View ->
            mp.reset()
            if (cuLanguage=="Punu")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.p006))
            }

            if (cuLanguage=="Myene")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.m06))
            }
            mp.prepare()
            mp.start()
        }
        nbr7.setOnClickListener { view: View ->
            mp.reset()
            if (cuLanguage=="Punu")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.p07))
            }

            if (cuLanguage=="Myene")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.m07))
            }
            mp.prepare()
            mp.start()
        }

        nbr8.setOnClickListener { view: View ->
            mp.reset()
            if (cuLanguage=="Punu")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.p08))
            }

            if (cuLanguage=="Myene")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.m08))
            }
            mp.prepare()
            mp.start()

        }
        nbr9.setOnClickListener { view: View ->
            mp.reset()
            if (cuLanguage=="Punu")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.p09))
            }

            if (cuLanguage=="Myene")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.m09))
            }
            mp.prepare()
            mp.start()
        }

        nbr10.setOnClickListener { view: View ->
            mp.reset()
            if (cuLanguage=="Punu")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.p10))
            }

            if (cuLanguage=="Myene")
            {
                mp.setDataSource(this, Uri.parse("android.resource://" + this.packageName+"/"+R.raw.m010))
            }
            mp.prepare()
            mp.start()
        }


    }
}