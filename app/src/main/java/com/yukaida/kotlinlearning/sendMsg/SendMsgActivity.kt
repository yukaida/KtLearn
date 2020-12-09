package com.yukaida.kotlinlearning.sendMsg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.yukaida.kotlinlearning.R
import kotlinx.android.synthetic.main.activity_send_msg.*

class SendMsgActivity : AppCompatActivity() {

    private val msgList=ArrayList<Msg>()

    private lateinit var strLate:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_msg)

        initMsg()


        if (!::strLate.isInitialized) {
            strLate="init in onCreate"
        }

        sendAT_recyclerView.run {
            adapter = MsgAdapter(this@SendMsgActivity,msgList)
            layoutManager=LinearLayoutManager(this@SendMsgActivity)
        }

        sendAt_bt_send.setOnClickListener {
            var strToSend = sendAt_et_input.text.toString()
//            Log.d("SendMsgActivity", "strToSend: $strToSend")
            if (strToSend.isNotEmpty()) {
                Log.d("SendMsgActivity", "scrollToPosition --origin : ${(sendAT_recyclerView.adapter!!.itemCount)}")
                msgList.add(Msg(strToSend, Msg.TYPE_SEND))
                Log.d("SendMsgActivity", "scrollToPosition --before : ${(sendAT_recyclerView.adapter!!.itemCount)}")
                sendAT_recyclerView.adapter?.notifyItemInserted(sendAT_recyclerView.adapter!!.itemCount )
                Log.d("SendMsgActivity", "scrollToPosition --after : ${(sendAT_recyclerView.adapter!!.itemCount)}")
                sendAT_recyclerView.scrollToPosition(sendAT_recyclerView.adapter!!.itemCount)
            }
        }

    }

    private fun initMsg() {

        val msg = Msg("hello this is android", Msg.TYPE_RECEIVE)
        val msg1 = Msg("hello this is kotlin", Msg.TYPE_SEND)
        val msg2 = Msg("what are you doing ", Msg.TYPE_RECEIVE)

        msgList.run {
            add(msg)
            add(msg1)
            add(msg2)
        }

    }
}