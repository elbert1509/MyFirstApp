package com.example.firstapp
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView

import androidx.recyclerview.widget.RecyclerView

class ListVideoAdapter (var items : List<DataClass>) :
    RecyclerView.Adapter<ListVideoAdapter.ListVideoView>() {




    class ListVideoView(itemView: View,private val context: Context) : RecyclerView.ViewHolder(itemView) {

         var dataTitle : TextView
         var dataDesc : TextView
         var dataImage : ImageView

        init {
            dataTitle = itemView.findViewById(R.id.recTitle)
            dataDesc = itemView.findViewById(R.id.recDesc)
            dataImage = itemView.findViewById(R.id.recImage)
        }

        fun bind(data : DataClass){

            val currentItem = itemView.findViewById<CardView>(R.id.recCard)

            currentItem.setOnClickListener{

                when(data.dataImage){
                    R.drawable.olele -> {
                        Toast.makeText(context, "olele", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListVideoView {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return ListVideoView(itemView,parent.context)

    }


    override fun onBindViewHolder(holder: ListVideoView, position: Int) {

        val data = items[position]
        holder.apply {
            dataTitle.text = data.dataTitle
            dataImage.setImageResource(data.dataImage)
            bind(data)

        }


    }
    override fun getItemCount(): Int  {

        return items.size
    }



}


