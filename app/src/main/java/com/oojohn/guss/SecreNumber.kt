package com.oojohn.guss

import java.util.*

class SecretNumber{
    val secret:Int =Random().nextInt(10) + 1
    var count: Int =0

    fun validate(number:Int): Int{   //驗證 隨機secret值-猜測值n，驗證為差值概念
        // secret為本類別產出，n為validate的建構子，待輸出產出
        count++
        return number-secret
    }
}

fun main() {
    val secreNumber=SecretNumber()
    println(secreNumber.secret)
    println("${secreNumber.validate(2)}, count:${secreNumber.count}")
}