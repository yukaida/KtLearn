package com.yukaida.kotlinlearning.sendMsg

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yukaida.kotlinlearning.R

/**
 * @author yukaida
 * @DATE 2020/12/9.
 */
sealed class TopMsgHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class MsgHolderLeft(itemView: View) : TopMsgHolder(itemView) {
    val textViewLeft: TextView = itemView.findViewById(R.id.msg_layout_left)
}

class MsgHolderRight(itemView: View) : TopMsgHolder(itemView) {
    val textViewRight: TextView = itemView.findViewById(R.id.msg_layout_right)
}