package com.satrio.asyncawait
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Main).launch {
            Log.i("MyTag","Calculation started....")

            val work1 = async(IO) {
                getWork1()
            }
            val work2 = async(IO) {
                getWork2()
            }

            val total = work1.await()+work2.await()
            Toast.makeText(applicationContext,"Total is $total",Toast.LENGTH_LONG).show()
            
        }

    }
}

private suspend fun getWork1() : Int {
    delay(12000)
    Log.i("MyTag"," work 1 returned ")
    return 66000
}

private suspend fun getWork2() : Int {
    delay(6000)
    Log.i("MyTag"," work 2 returned ")
    return 42000
}