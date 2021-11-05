package com.whc.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.whc.lib_annotations.AppConstance
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.imv)
        val handler = Handler(mainLooper)
        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                Thread{
                    handler.post {
                        Toast.makeText(this@MainActivity, "run on activity", Toast.LENGTH_SHORT).show()
                    }
//                    Looper.prepare()
//                    Toast.makeText(this@MainActivity, "run on activity", Toast.LENGTH_SHORT).show()
//                    Looper.loop()
                }.start()
//                val bitmap = getDrawable(R.drawable.test2)?.toBitmap()
//                bitmap?.let {
//                    val size = if(width<height){width}else{height}
//                    val aspectRatio = width/height.toDouble()
//                    val b2 = Bitmap.createScaledBitmap(bitmap, (size*aspectRatio).roundToInt(),size,true)
//                    imageView.setImageBitmap(b2)
//                }
//                imageView.setImageBitmap(bitmap)
//                Glide.with(context).load(R.drawable.test2).into(imageView)
//                val httpURLConnection = URL("https://blog.csdn.net/xiaxl/article/details/76642442").openConnection()
//                    GlobalScope.launch {
//                        val bf = httpURLConnection.getInputStream().bufferedReader()
//                        val t = bf.readText()
//                        runOnUiThread {
//                            Toast.makeText(this@MainActivity, t, Toast.LENGTH_SHORT).show()
//                        }
//                    }



//                ARouter.getInstance().build(AppConstance.TEST_ACTIVITY_2_URL)
//                    .withObject("user1",User().apply {
//                        username = "w"
//                        age = 1
//                        password = "123"
//                    })
//                    .withObject("user2",User().apply {
//                        username = "w"
//                        age = 123
//                        password = "123"
//                    })
//                    .navigation()
            }
        }
    }
}