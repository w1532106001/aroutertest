package com.whc.myapplication

import android.content.Context
import com.alibaba.android.arouter.facade.service.SerializationService
import com.google.gson.Gson
import java.io.Serializable
import java.lang.reflect.Type

class User(){
    var username: String = ""
    var age: Int = 0
    var password: String = ""


    override fun toString(): String {
        return "User(username='$username', age=$age, password='$password')"
    }
}