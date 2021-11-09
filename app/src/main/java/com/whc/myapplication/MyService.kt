package com.whc.myapplication

import android.app.Service
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Binder
import android.os.IBinder
import android.widget.Toast
import kotlinx.coroutines.*
import java.io.File
import java.net.URL
import java.util.concurrent.atomic.AtomicInteger

class MyService : Service() {

    val coroutineScope = CoroutineScope(context = Dispatchers.Main)


    val binder = object : IMyAidlInterface.Stub() {
        override fun sayHello(t: String?, i: Int, user: User?) {
            coroutineScope.launch {
                Toast.makeText(this@MyService, "t :$t i:$i user:$user", Toast.LENGTH_SHORT).show()
            }
        }

        override fun getUserAge(user: User?): Int {
            return user?.age ?: 0
        }

        override fun download(url: String?) {
            coroutineScope.launch(Dispatchers.IO) {
                this@MyService.download(url.toString())
            }
        }

    }

    override fun onBind(intent: Intent): IBinder {
        println("MyService.onBind intent:$intent")
        return binder
    }

    override fun onCreate() {
        super.onCreate()
        println("MyService.onCreate")
//        repeat(5){
//            Toast.makeText(this, "${1+it}", Toast.LENGTH_SHORT).show()
//
//        }
    }

    override fun onUnbind(intent: Intent?): Boolean {
        println("MyService.onUnbind intent:$intent")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        println("MyService.onDestroy")
    }

    suspend fun download(url: String) {
        val uri = URL(url)
        val t = uri.readText()

        val file = File("$cacheDir/123.jpg")
        file.writeBytes(uri.readBytes())
        val bitmap = BitmapFactory.decodeFile(file.path)


        coroutineScope.launch(Dispatchers.Main) {
            Toast.makeText(this@MyService, "$t", Toast.LENGTH_SHORT).show()
        }

    }
}