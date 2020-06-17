package com.codingwithmitch.mvvmrecyclerview.mvvmkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.mvvmrecyclerview.R
import com.codingwithmitch.mvvmrecyclerview.models.NicePlace
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.layout_listitem.view.*
import java.util.*

class RecyclerAdapterKotlin( var nicePlaces: List<NicePlaceKotlin>) : RecyclerView.Adapter<RecyclerAdapterKotlin.MyViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerAdapterKotlin.MyViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_listitem, viewGroup, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerAdapterKotlin.MyViewHolder, i: Int) {

        // Set the name of the 'NicePlace'

        viewHolder.itemView.image_name.text = nicePlaces[i].title

        // Set the image
        val defaultOptions = RequestOptions()
                .error(R.drawable.ic_launcher_background)
        Glide.with(viewHolder.itemView)
                .setDefaultRequestOptions(defaultOptions)
                .load(nicePlaces[i].imageUrl)
                .into(viewHolder.itemView.image)
    }

    override fun getItemCount(): Int {
        return nicePlaces.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}