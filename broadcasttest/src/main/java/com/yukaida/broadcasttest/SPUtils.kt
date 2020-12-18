package com.yukaida.broadcasttest

import android.content.Context
import android.util.Log


object SPUtils {
    private const val TAG = "SPUtils"
    private val context=MyApplication.context
    private val sp = context.getSharedPreferences("ktTestSp", Context.MODE_PRIVATE)

    fun spPut(key:String,value:String){
        Log.d(TAG, "spPut: ${ sp.edit().putString(key,value).apply()}")
    }

    fun spRemove(key: String){
        Log.d(TAG, "spRemove: ${sp.edit().remove(key).apply()}")
    }

    fun spGet(key: String):String{
        Log.d(TAG, "spGet: ${sp.getString(key,"no data")}")
        return sp.getString(key,"no data")?:""

    }


}