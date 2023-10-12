package com.example.firstapp

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class LangageAdapter(val mContext: Context,  val values :Array<Langage> ) : ArrayAdapter<Langage>(mContext,0,values) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {

        return createView(position,convertView,parent)
    }

   fun createView(position: Int, convertView: View?, parent: ViewGroup) : View {

       val itemView : View = LayoutInflater.from(mContext).inflate(R.layout.item_langue,parent,false)

       val langageName = itemView.findViewById<TextView>(R.id.langaeName)
       val imageflag = itemView.findViewById<ImageView>(R.id.flagLangage)


       val langue = values[position]
       langageName.text = langue.name

       imageflag.setImageResource(langue.flag)
       return itemView
   }
}