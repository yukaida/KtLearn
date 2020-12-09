package com.yukaida.kotlinlearning

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

/**
 * @author yukaida
 * @DATE 2020/12/8.
 */
class MyAdapter(): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    private var mContext: Context? = null
    private var mStrList:List<String>?=null

    constructor(context: Context,strList: ArrayList<String>):this(){
        this.mContext=context
        this.mStrList=strList
    }


    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val textView:TextView=itemView.findViewById(R.id.rv_item_textView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_rv_item, parent, false)
        val myViewHolder=MyViewHolder(view)

        myViewHolder.textView.setOnClickListener { Toast.makeText(parent.context, mStrList?.get(myViewHolder.adapterPosition), Toast.LENGTH_SHORT).show() }


        return myViewHolder

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.textView.text=mStrList?.get(position)
//        holder.textView.setOnClickListener {
//            Toast.makeText(mContext, mStrList?.get(position), Toast.LENGTH_SHORT).show()
//        }
    }

    override fun getItemCount(): Int {
        return if (null != mStrList) {
            mStrList!!.size
        } else {
            0
        }
    }

    fun setListData(strList:List<String>){
        this.mStrList=strList
        notifyDataSetChanged()
    }
}