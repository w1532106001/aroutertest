package com.whc.myapplication

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import com.alibaba.android.arouter.facade.service.SerializationService
import com.google.gson.Gson
import java.io.Serializable
import java.lang.reflect.Type

class User():Parcelable{
    var username: String = ""
    var age: Int = 0
    var password: String = ""

    constructor(parcel: Parcel) : this() {
        username = parcel.readString().toString()
        age = parcel.readInt()
        password = parcel.readString().toString()
    }


    override fun toString(): String {
        return "User(username='$username', age=$age, password='$password')"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeInt(age)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}