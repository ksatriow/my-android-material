package com.satrio.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadData.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                downloadData()
            }

        }
    }

    private fun downloadData() {
        for (i in 1..200000) {
            Log.i("TAG", "Downloading data $i in ${Thread.currentThread().name}")
        }
    }
}
