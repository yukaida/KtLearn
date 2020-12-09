package com.yukaida.kotlinlearning

import java.lang.StringBuilder

/**
 * @author yukaida
 * @DATE 2020/12/8.
 */
fun main() {


    val str = with(StringBuilder()){
        append("startEating---\n")
        val fruitList= listOf<String>("apple","pear","banana","orange")
        for (fruit in fruitList) {
            append(fruit)
            append("\n")
        }
        append("finish Eat---")
        toString()
    }

    print(str)
}

fun topFunction(){

}