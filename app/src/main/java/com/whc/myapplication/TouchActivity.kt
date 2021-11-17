package com.whc.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class TouchActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch)

//        this.window.decorView.setOnClickListener {
//            Toast.makeText(this, "decorView", Toast.LENGTH_SHORT).show()
//        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Toast.makeText(this, "activity", Toast.LENGTH_SHORT).show()
        return super.onTouchEvent(event)
    }

}