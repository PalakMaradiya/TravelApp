package com.example.travelwithme.ADAPTER

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.travelwithme.FRAGEMENT.HomeFragment
import com.example.travelwithme.MODALCLASS.ModalClass
import com.example.travelwithme.R

class ShowAdpter(var context: HomeFragment, var list: ArrayList<ModalClass> , var onItemClick :(( key :String, name :String , description : String , ImageUri : String , price : String , location : String , rate : String , day : String )-> Unit)) :
    RecyclerView.Adapter<ShowAdpter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtPlaceName: TextView = itemView.findViewById(R.id.txtPlaceName)
        var txtLocation: TextView = itemView.findViewById(R.id.txtLocation)
        var cardView: CardView = itemView.findViewById(R.id.cardView)
        var imgLike: ImageView = itemView.findViewById(R.id.imgLike)


        //        var txtDescripition : TextView = itemView.findViewById(R.id.txtDescripition)
//        var txtDistance : TextView = itemView.findViewById(R.id.txtDistance)
//        var txtprice : TextView = itemView.findViewById(R.id.txtprice)
//        var txtDay : TextView = itemView.findViewById(R.id.txtDay)
        var txtrating : TextView = itemView.findViewById(R.id.txtRate)
        var img: ImageView = itemView.findViewById(R.id.img)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var View =
            LayoutInflater.from(parent.context).inflate(R.layout.show_item_file, parent, false)
        return MyViewHolder(View)


    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.txtPlaceName.text = list[position].name
        holder.txtLocation.text = list[position].location
        // holder.txtDescripition.text = list[position].description
        // holder.txtDistance.text = list[position].distance
        //  holder.txtprice.text = list[position].price
        // holder.txtDay.text = list[position].day
         holder.txtrating.text = list[position].Rate
        //  holder.txtLocation.text = list[position].location

        Glide.with(context).load(list[position].ImageUri).into(holder.img)

        holder.imgLike.setOnClickListener {

            holder.imgLike.setImageResource(R.drawable.fill)
        }

        holder.cardView.setOnClickListener {

            onItemClick.invoke(
                list[position].key,
                list[position].name,
                list[position].description,
                list[position].price,
                list[position].ImageUri,
                list[position].location,
                list[position].Rate,
                list[position].Day
            )
            Log.e("TAG", "Adapter: " + list[position].ImageUri)

        }



    }

    fun refresh(list: ArrayList<ModalClass>) {
        this.list = list
        notifyDataSetChanged()

    }
}