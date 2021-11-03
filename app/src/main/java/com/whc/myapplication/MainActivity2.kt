package com.whc.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.whc.lib_annotations.AppConstance


@Route(path = AppConstance.TEST_ACTIVITY_2_URL)
class MainActivity2 : AppCompatActivity() {

    @JvmField
    @Autowired
    var user1:User?=null

    @JvmField
    @Autowired(name = "user")
    var user:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById<TextView>(R.id.tv1).apply {
            text = user.toString()
        }
    }
}