package com.whc.myapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.work.*
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.whc.lib_annotations.AppConstance
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var service: IMyAidlInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this@MainActivity, MyService::class.java)
        val sc = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, s: IBinder?) {
                service = IMyAidlInterface.Stub.asInterface(s)
                println("连接service name:$name service:$service")
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                println("断开service name:$name")
            }

        }
        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
//                startService(intent)
                bindService(intent, sc, Context.BIND_AUTO_CREATE)
            }
        }
        findViewById<Button>(R.id.button2).apply {
            setOnClickListener {
                val u = User().apply {
                    username = "w"
                    age = 18
                    password = "123"
                }
                service.sayHello("你好", 1, u)

                Toast.makeText(
                    this@MainActivity,
                    "user:" + service.getUserAge(u),
                    Toast.LENGTH_SHORT
                ).show()
//                unbindService(sc)
//                finish()
//                stopService(intent)
            }
        }
        val et = findViewById<EditText>(R.id.et)
        findViewById<Button>(R.id.b3).apply {
            setOnClickListener {
                val workRequest =
                    PeriodicWorkRequestBuilder<UploadWorker>(5, TimeUnit.SECONDS).build()
                WorkManager.getInstance(context)
                    .enqueueUniquePeriodicWork("test"
                        ,ExistingPeriodicWorkPolicy.KEEP,workRequest)
                WorkManager.getInstance(context).getWorkInfosByTagLiveData("test").observe(this@MainActivity){
                    if(it.isNotEmpty() && (WorkInfo.State.SUCCEEDED == it[0].state)){
                        Toast.makeText(this@MainActivity, "任务完成", Toast.LENGTH_SHORT).show()
                    }
                }
//                val workRequest = OneTimeWorkRequestBuilder<UploadWorker>().build()
//                WorkManager.getInstance(context).enqueue(workRequest)
//                service.download(et.text.toString())

//                unbindService(sc)
//                finish()
//                stopService(intent)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        println("MainActivity.onDestroy")
    }
}