package com.yukaida.kotlinlearning

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.layout_titlelayout.view.*
import java.util.jar.Attributes

/**
 * @author yukaida
 * @DATE 2020/12/8.
 */
class TitleLayout(context: Context,attributeSet: AttributeSet) :LinearLayout(context,attributeSet) {
    init {
        LayoutInflater.from(context).inflate(R.layout.layout_titlelayout, this)

        titleLayout_back.setOnClickListener {
//            val activity=context as Activity
            (context as Activity ).finish()
        }

        titleLayout_edit.setOnClickListener {
            Toast.makeText(context, "edit onclick", Toast.LENGTH_SHORT).show()
        }

    }
}