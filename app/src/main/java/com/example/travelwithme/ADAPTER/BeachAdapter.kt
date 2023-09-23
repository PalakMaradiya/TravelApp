package com.example.travelwithme.ADAPTER

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.travelwithme.ACTIVITY.BeachShowActivity
import com.example.travelwithme.MODALCLASS.ModalClass
import com.example.travelwithme.R
import kotlin.math.log

class BeachAdapter(var beachShowActivity: BeachShowActivity,var  list: ArrayList<ModalClass> , var onItemClick :(( key :String, name :String , description : String , ImageUri : String , price : String , location : String  , Rate : String, Day : String)-> Unit) )
    : RecyclerView.Adapter<BeachAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView){
        var cardView : CardView = itemView.findViewById(R.id.cardView)
        var txtPlaceName : TextView = itemView.findViewById(R.id.txtPlaceName)
        var txtRate : TextView = itemView.findViewById(R.id.txtRate)
        var txtLocation : TextView = itemView.findViewById(R.id.txtLocation)
        var img : ImageView = itemView.findViewById(R.id.img)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.beach_item_file,parent,false)
        return MyViewHolder(View)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtPlaceName.text = list[position].name
        holder.txtLocation.text = list[position].location
        holder.txtRate.text = list[position].Rate
        Glide.with(beachShowActivity).load(list[position].ImageUri).into(holder.img)

        holder.cardView.setOnClickListener {

            onItemClick.invoke(list[position].key,
                list[position].name,
                list[position].description,
                list[position].price,
                list[position].ImageUri ,
                list[position].location ,
                list[position].Rate,
                list[position].Day)
            Log.e("TAG", "Adapter: "+ list[position].ImageUri)

        }

    }
    fun refresh(list : ArrayList<ModalClass>)
    {
        this . list = list
        notifyDataSetChanged()
    }
}