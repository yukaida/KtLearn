package com.yukaida.kotlinlearning

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.yukaida.kotlinlearning.sendMsg.SendMsgActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private  val TAG = "MainActivity"
    private val context: Context = this

    companion object{
        @JvmStatic
        fun staticFunA(){
            Log.d("staticFunA", "staticFunA has been used ")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
//            ThirdActivity.actionStart(this)
            startActivity(Intent(this,SendMsgActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                100->toastMessage("secondActivity has been finished ,requestCode is $requestCode")
                else->null
            }
        }

        android.os.Process.killProcess(android.os.Process.myPid())

        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun toastMessage(str: String) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        var strMessageToSave:String?=null
        if (main_EditText.text.isNotEmpty()) {
            strMessageToSave= main_EditText.text.toString()
            outState.putString("messageSave", strMessageToSave)
        }
        Log.d(TAG, "onSaveInstanceState: $strMessageToSave")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: "+javaClass.simpleName+taskId)
    }
}

