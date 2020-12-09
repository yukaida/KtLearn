package com.yukaida.kotlinlearning

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : BaseActivity() , View.OnClickListener {

    companion object {
        private const val TAG = "SecondActivity"
        private var strStartFrom:String=""
        fun actionStart(context:Context,strFrom:String){
            val intent=Intent(context, SecondActivity::class.java)
            strStartFrom=strFrom
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val strInfo=intent.getStringExtra("data")

        strInfo?.let {
            Log.d(TAG, "onCreate: ----- getMessage $strInfo")
        }

        doSomething()

        MainActivity.staticFunA()

        Log.d("SecondActivity", "receive data:$strInfo ")
        Log.d(TAG, "onCreate: $strStartFrom")

        button_secondA_close.setOnClickListener {
            setResult(RESULT_OK)
            finish() }

    }

    private fun doSomething(){


        topFunction()


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.main_TestView -> Log.d(TAG, "onClick: on secondActivity----")

        }
    }
}