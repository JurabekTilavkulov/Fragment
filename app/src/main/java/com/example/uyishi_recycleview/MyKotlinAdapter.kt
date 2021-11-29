package com.example.uyishi_recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyKotlinAdapter(private val list: ArrayList<Model>, private var context:Context, private var listener: OnlongItemClickListener):
    RecyclerView.Adapter<MyKotlinAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var nam:TextView?=null
        var surname:TextView?=null
        init {
            nam=itemView.findViewById(R.id.ism)
            surname=itemView.findViewById(R.id.surname)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView:View=LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.nam?.text= list[position].name
        holder.surname?.text= list[position].surname

        holder.itemView.setOnLongClickListener {
            listener?.onClick(position)

            true
        }
    }

    override fun getItemCount(): Int {


        if (list != null) {
            return list.size
        }
        else return 1
    }

    fun onRemoved(i: Int) {
        list!!.removeFirst()
        notifyItemRemoved(i)

      }

    interface OnlongItemClickListener{
        fun onClick (i:Int)
    }
}



