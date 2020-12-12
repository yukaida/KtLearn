package com.yukaida.fragmentpractice

/**
 * @author yukaida
 * @DATE 2020/12/10.
 */
fun String.getCharLength():Int{
    var count=0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}


fun main(){


    val name:String="kotlin"
    name.getCharLength()
    name.repeat(3)
    

}