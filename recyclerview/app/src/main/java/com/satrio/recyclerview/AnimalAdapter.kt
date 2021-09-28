package com.satrio.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MyRecyclerViewAdapter(private val fruitsList:List<Animal>, private val clickListener:(Animal)->Unit) : RecyclerView.Adapter<MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
       return fruitsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruitsList[position],clickListener)
    }
}

class MyViewHolder(val view : View) : RecyclerView.ViewHolder(view){

        fun bind(animal: Animal, clickListener:(Animal)->Unit){
            view.name_text_view.text = animal.name
            view.setOnClickListener {
                clickListener(animal)
            }

        }
}