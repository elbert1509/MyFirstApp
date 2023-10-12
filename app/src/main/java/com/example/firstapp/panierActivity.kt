package com.example.firstapp

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import java.util.*

class panierActivity : AppCompatActivity() {
  /*  @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panier)


        val animate = AnimatorSet()
        val banane = findViewById<ImageButton>(R.id.banane)
        banane.visibility = View.INVISIBLE

        val play = findViewById<ImageButton>(R.id.playpanier)
        banane.x = 20f
        banane.y = 300f
        val objty = ObjectAnimator.ofFloat(banane,View.TRANSLATION_Y,1000f)

        objty.duration = 1000
        val objtx = ObjectAnimator.ofFloat(banane,View.TRANSLATION_X,300f)
        objtx.duration = 1000
        animate.playTogether(objtx,objty)
        //var location = intArrayOf(2)
       // banane.getLocationOnScreen(location)


        play.setOnClickListener{

            Toast.makeText(this,"Langue : location[1]",Toast.LENGTH_SHORT).show()
            banane.visibility = View.VISIBLE

            animate.start()

        }




    }*/
}


