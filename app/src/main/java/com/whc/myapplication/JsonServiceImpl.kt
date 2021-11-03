package com.whc.myapplication

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.SerializationService
import com.google.gson.Gson
import java.io.Serializable
import java.lang.reflect.Type
@Route(path = "/service/json")
class JsonServiceImpl():SerializationService{

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