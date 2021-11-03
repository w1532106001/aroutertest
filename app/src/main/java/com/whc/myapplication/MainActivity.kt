package com.whc.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.alibaba.android.arouter.launcher.ARouter
import com.whc.lib_annotations.AppConstance

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                ARouter.getInstance().build(AppConstance.TEST_ACTIVITY_2_URL)
                    .withString("user",User().apply {
                        username = "w"
                        age = 1
                        password = "123"
                    }.toString())
//                    .withObject("user2",User("d",1123,"123456"))
                    .navigation()
            }
        }
    }
}