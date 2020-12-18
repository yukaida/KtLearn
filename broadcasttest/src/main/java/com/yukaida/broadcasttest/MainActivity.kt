package com.yukaida.broadcasttest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.yukaida.broadcasttest.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonWriteToFile.setOnClickListener{
                createFileAndWrite()
                Toast.makeText(this@MainActivity, "createFile", Toast.LENGTH_SHORT).show()
            }
            buttonReadAndShow.setOnClickListener{
                readFileAndShow()
                Toast.makeText(this@MainActivity, "readFile", Toast.LENGTH_SHORT).show()
            }

            buttonReadSP.setOnClickListener {
                Log.d(TAG, "onCreate: ${SPUtils.spGet("key")}")
            }
            buttonRemoveSP.setOnClickListener {
                Log.d(TAG, "onCreate: ${SPUtils.spRemove("key")}")
            }
            buttonWriteSP.setOnClickListener {
                SPUtils.spPut("key","value to write - kotlin")
            }

            buttonCreateDB.setOnClickListener {
                val myDataBaseHelper= MyDataBaseHelper(this@MainActivity, 1)
                val db=myDataBaseHelper.readableDatabase
            }

        }

    }

    private fun createFileAndWrite(){
        try {
            val openFileOutputStream = openFileOutput("testFile", Context.MODE_APPEND)
            val outputStreamWriter=OutputStreamWriter(openFileOutputStream)
            val bufferedWriter = BufferedWriter(outputStreamWriter)
            bufferedWriter.use {
                it.write("content to write")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun readFileAndShow(){
        try {
            val fileInputStream = openFileInput("testFile")
            val bufferedReader=BufferedReader(InputStreamReader(fileInputStream))
            var stringBuilder=StringBuilder()
            var str:String?

            bufferedReader.use {
                do {
                    str=it.readLine()
                    str?.let {
                        stringBuilder.append(str)
                    }
                } while (str!=null)
            }
            Log.d(TAG, "readFileAndShow: ${stringBuilder.toString()}")
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

}