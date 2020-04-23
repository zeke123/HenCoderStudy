package com.zhoujian.hencoderstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Main) {
            io1()
            main1()
            io2()
            main2()
            io3()
            main3()
        }
    }


    private suspend fun io1() {
        withContext(Dispatchers.IO) {
            Thread.sleep(2000)
            println("io1() in thread---${Thread.currentThread().name}")
        }
    }

    private suspend fun io2() {
        withContext(Dispatchers.IO) {
            Thread.sleep(2000)
            println("io2() in thread---${Thread.currentThread().name}")

        }
    }

    private suspend fun io3() {
        withContext(Dispatchers.IO) {
            Thread.sleep(2000)
            println("io3() in thread---${Thread.currentThread().name}")

        }
    }


    private fun main1() {
        println("main1() in thread---${Thread.currentThread().name}")
    }

    private fun main2() {
        println("main2() in thread---${Thread.currentThread().name}")

    }

    private fun main3() {
        println("main3() in thread---${Thread.currentThread().name}")

    }


}
