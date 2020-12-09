package com.yukaida.fragmentmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_fragment_left.*

class MainActivity : AppCompatActivity() {
    private lateinit var leftFragment: LeftFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        replaceFragment(RightFragment())


        fragment_button.setOnClickListener {
//            replaceFragment(NewRightFragment())
        }



    }

//    private fun replaceFragment(fragment: Fragment) {
//
//        val supportFragmentManager=supportFragmentManager
//        supportFragmentManager.beginTransaction().replace(R.id.rightFrag, fragment).addToBackStack(null).commit()
//
//    }
}