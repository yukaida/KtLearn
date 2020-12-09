package com.yukaida.kotlinlearning.sendMsg

/**
 * @author yukaida
 * @DATE 2020/12/9.
 */
data class Msg(val string: String, val type: Int) {

    companion object {
        const val TYPE_RECEIVE: Int = 0
        const val TYPE_SEND: Int = 1
    }

}
