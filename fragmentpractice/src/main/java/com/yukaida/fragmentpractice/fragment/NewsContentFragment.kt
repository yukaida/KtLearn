package com.yukaida.fragmentpractice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yukaida.fragmentpractice.R
import kotlinx.android.synthetic.main.new_content_frag.*

/**
 * @author yukaida
 * @DATE 2020/12/10.
 */
class NewsContentFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_content_frag, container, false)
    }

    fun refresh(title:String,content:String){

        contentLayout.visibility=View.VISIBLE
        newsTitle.text=title
        newsContent.text=content

    }
}