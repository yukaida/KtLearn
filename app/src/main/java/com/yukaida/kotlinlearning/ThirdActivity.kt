package com.yukaida.kotlinlearning

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class ThirdActivity : AppCompatActivity() {

    companion object{
        fun actionStart(context: Context){
            context.startActivity(Intent(context, ThirdActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val myAdapter=MyAdapter(this, ArrayList())

        third_recyclerView.adapter=myAdapter
        third_recyclerView.layoutManager=LinearLayoutManager(this)

        val strList= mutableListOf("apple","banana","pear")
        for (i in 1..10) {
            strList.run {
                add("apple")
                add("banana")
                add("pear")
            }
        }

        repeat(4){
            strList.add("test")
        }

        myAdapter.setListData(strList)
    }
}