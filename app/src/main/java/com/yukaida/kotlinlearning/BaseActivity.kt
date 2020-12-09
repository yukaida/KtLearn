package com.yukaida.kotlinlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(javaClass.simpleName, "onCreate: ")
        ActivityList.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityList.removeActivity(this)

    }
}