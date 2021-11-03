package com.whc.myapplication

import android.content.Context
import com.alibaba.android.arouter.facade.service.SerializationService
import com.google.gson.Gson
import java.io.Serializable
import java.lang.reflect.Type

class User():SerializationService{
    var username: String = ""
    var age: Int = 0
    var password: String = ""


    override fun toString(): String {
        return "User(username='$username', age=$age, password='$password')"
    }
    private val gson by lazy {
        Gson()
    }



    override fun init(context: Context?) {
        println("asd")
    }

    override fun <T : Any?> json2Object(input: String?, clazz: Class<T>?): T {
        return gson.fromJson(input,clazz)
    }

    override fun object2Json(instance: Any?): String {
        return gson.toJson(instance)
    }

    override fun <T : Any?> parseObject(input: String?, clazz: Type?): T {
        return gson.fromJson(input,clazz)
    }
}