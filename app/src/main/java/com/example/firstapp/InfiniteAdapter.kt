package com.example.firstapp

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

class InfiniteAdapter(private val mp: MediaPlayer, private val context: Context) : RecyclerView.Adapter<InfiniteAdapter.InfiniteViewHolder>() {

    private val actualData = listOf(
        R.raw.dog,
        R.raw.cat
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfiniteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lottie, parent, false)

        return InfiniteViewHolder(view,mp, context)
    }

    override fun onBindViewHolder(holder: InfiniteViewHolder, position: Int) {
        val actualPosition = position % actualData.size
        holder.bind(actualData[actualPosition])
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    class InfiniteViewHolder(itemView: View, private val mp: MediaPlayer, private val context: Context) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Int) {
            val animationView = itemView.findViewById<LottieAnimationView>(R.id.animationView)
            animationView.repeatCount=LottieDrawable.INFINITE
            animationView.setAnimation(data)

            animationView.setOnClickListener{
                when(data){
                    R.raw.dog -> {
                        Toast.makeText(context, "chien", Toast.LENGTH_LONG).show()
                        if (!mp.isPlaying) {
                            try {
                                mp.stop()
                                mp.reset()
                                mp.setDataSource(context, Uri.parse("android.resource://${context.packageName}/${R.raw.chien2}"))
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

                    R.raw.cat -> {
                        Toast.makeText(context, "chat", Toast.LENGTH_LONG).show()
                        if (!mp.isPlaying) {
                            try {
                                mp.stop()
                                mp.reset()
                                mp.setDataSource(context, Uri.parse("android.resource://${context.packageName}/${R.raw.chat}"))
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
            }

        }

        private fun playSound(rawId: Int) {
            try {
                if (mp.isPlaying) {
                    mp.stop()
                    mp.reset()
                }
                mp.setDataSource(context, Uri.parse("android.resource://${context.packageName}/${R.raw.chien2}"))
                mp.prepare()
                mp.start()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }


}

