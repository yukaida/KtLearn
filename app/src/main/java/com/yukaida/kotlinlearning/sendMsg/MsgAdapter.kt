package com.yukaida.kotlinlearning.sendMsg

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.yukaida.kotlinlearning.R

/**
 * @author yukaida
 * @DATE 2020/12/9.
 */
class MsgAdapter(private val context: Context, private val msgList: ArrayList<Msg>) :
    RecyclerView.Adapter<TopMsgHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMsgHolder {
        return if (viewType == Msg.TYPE_RECEIVE) {
            MsgHolderLeft(
                LayoutInflater.from(parent.context).inflate(R.layout.layout_msg_left, parent, false)
            )
        } else {
            MsgHolderRight(
                LayoutInflater.from(parent.context).inflate(R.layout.layout_msg_right, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: TopMsgHolder, position: Int) {
        when (holder){
            is MsgHolderLeft ->  holder.textViewLeft.run {
                text=msgList[position].string
                setTextColor(ContextCompat.getColor(context,R.color.white))
            }
            is MsgHolderRight ->  holder.textViewRight.text=msgList[position].string
        }
    }

    override fun getItemCount(): Int {
        return msgList.size
    }

    override fun getItemViewType(position: Int): Int {
        return msgList[position].type;
    }
}