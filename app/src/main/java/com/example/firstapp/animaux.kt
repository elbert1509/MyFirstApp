package com.example.firstapp

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

class animaux : AppCompatActivity() {
    private lateinit var  mp: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animaux)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        mp = MediaPlayer.create(this,R.raw.chien2)
        recyclerView.adapter = InfiniteAdapter(mp,this)

        val chien = findViewById<LottieAnimationView>(R.id.animationView)
        val chat = findViewById<LottieAnimationView>(R.id.animationView1)
        chien.repeatCount = LottieDrawable.INFINITE
        chat.repeatCount = LottieDrawable.INFINITE
        chien.playAnimation()
        chat.playAnimation()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager


        chien.setOnClickListener{ view: View ->

            Toast.makeText(this, "Chien", Toast.LENGTH_LONG).show()
            if (!mp.isPlaying) {
                try {
                    mp.stop()
                    mp.reset()
                    mp.setDataSource(this, Uri.parse("android.resource://${this.packageName}/${R.raw.chien2}"))
                    mp.prepare() // Cette méthode bloque, vous pouvez envisager d'utiliser prepareAsync() à la place pour éviter de bloquer le thread principal
                    mp.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                mp.pause()
                mp.seekTo(0)
            }
        }


        chat.setOnClickListener{ view: View ->

            Toast.makeText(this, "chat", Toast.LENGTH_LONG).show()
            if (!mp.isPlaying) {
                try {
                    mp.stop()
                    mp.reset()
                    mp.setDataSource(this, Uri.parse("android.resource://${this.packageName}/${R.raw.chat}"))
                    mp.prepare() // Cette méthode bloque, vous pouvez envisager d'utiliser prepareAsync() à la place pour éviter de bloquer le thread principal
                    mp.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                mp.pause()
                mp.seekTo(0)
            }
        }




    }

    override fun onDestroy() {
        super.onDestroy()
        mp.release()
    }
}