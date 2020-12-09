package com.yukaida.fragmentmodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @author yukaida
 * @DATE 2020/12/9.
 */
class LeftFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_fragment_left, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        if (activity!=null) {
//            val mainActivity=activity as MainActivity
//           val rightFragment= mainActivity.supportFragmentManager.fragments[R.id.rightFrag] as RightFragment
//            rightFragment.test()
//        }

    }
}