package com.satrio.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val fruitsList = listOf(Animal("Kucing","Mamalia"), Animal("Cendrawasih","Bird"),Animal("Hiu","Fish") , Animal("Piton","Reptiles"),Animal("Lebah","Insects"),Animal("Ulat Bulu","Worms"),Animal("Laba - laba","Arachnids"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycler_view.setBackgroundColor(Color.parseColor("#2980B9"))
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.adapter = MyRecyclerViewAdapter(fruitsList,{ selectedAnimalItem:Animal->listItemClicked(selectedAnimalItem)})
    }

    private fun listItemClicked(animal: Animal){
          Toast.makeText(this@MainActivity,
              "Supplier name is ${animal.category}",Toast.LENGTH_LONG).show()
    }
}
