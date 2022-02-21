package com.nerdymykl.bigcats.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nerdymykl.bigcats.R
import com.nerdymykl.bigcats.models.Cat
import com.nerdymykl.bigcats.datasource.cats
import com.nerdymykl.bigcats.datasource.favourites

class CatsAdapter(private val cats : List<Cat>)  : RecyclerView.Adapter<CatsAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val catImage: ImageView = view.findViewById(R.id.imageView)
        val nameTv: TextView = view.findViewById(R.id.textview)
        val favImage: ImageView = view.findViewById(R.id.favouriteIV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.cat_item,parent,false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.catImage.setImageResource(cats[position].image)
        holder.nameTv.text = cats[position].name
        holder.favImage.setImageResource(if(favourites.contains(cats[position].id)) R.drawable.ic_favourite_red else R.drawable.ic_favourite_grey)
    }

    override fun getItemCount(): Int = cats.size

}