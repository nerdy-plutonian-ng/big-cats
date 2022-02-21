package com.nerdymykl.bigcats.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.nerdymykl.bigcats.R
import com.nerdymykl.bigcats.models.Cat
import com.nerdymykl.bigcats.datasource.cats
import com.nerdymykl.bigcats.datasource.favourites
import com.nerdymykl.bigcats.ui.CatsFragmentDirections

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
        holder.catImage.setOnClickListener { goToDetail(holder.itemView,cats[position]) }
        holder.nameTv.text = cats[position].name
        holder.nameTv.setOnClickListener { goToDetail(holder.itemView,cats[position]) }
        holder.favImage.setImageResource(if(favourites.contains(cats[position].id)) R.drawable.ic_favourite_red else R.drawable.ic_favourite_grey)
        holder.favImage.setOnClickListener {
            toggleFave(position, it as ImageView)
        }
    }

    override fun getItemCount(): Int = cats.size

    private fun goToDetail(view: View,cat : Cat) {
        val action = CatsFragmentDirections.actionCatsFragmentToCatDetailFragment(cat = cat
            .toJson())
        view.findNavController().navigate(action)
    }

    private fun toggleFave(index : Int,view : ImageView) {
        if(favourites.contains(cats[index].id)){
            favourites.remove(cats[index].id)
        } else {
            favourites.add(cats[index].id)
        }
        view.setImageResource(if(favourites.contains(cats[index].id)) R.drawable.ic_favourite_red
        else R.drawable.ic_favourite_grey)
    }

}