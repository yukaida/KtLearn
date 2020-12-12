package com.yukaida.broadcasttest

/**
 * @author yukaida
 * @DATE 2020/12/10.
 */

fun funToTest(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun example(func: (String, Int) -> Unit) {
    func("hello", 123)
}

fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2) + 1
}

fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

class Child
class Parent

val sumAB = fun(a: Int, b: Int): Int {
    return a + b
}


val lambadaSum = { a: Int, b: Int -> a + b + 1 }

val lambadaAdd={age:Int -> age + 1}


fun main() {

    println(lambadaSum(1,2))

}