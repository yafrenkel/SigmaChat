package com.sbrobotics.chat

import androidx.compose.ui.text.toUpperCase

fun main() {
    println("Hello World!")
    val firstName: String = "Lilia"
    val anotherFirstName = "Jessica" // type inference (where type is obvious - it can be omitted)
    var weight = 130 // var - depends on how many cookies I eat
    var myDouble: Double = 2.5 // for decimals
    var condVariable: Boolean = true // true | false
    operators()
    stringOperators()
    friends()
    myFunction("Mark")
}

fun myFunction(name: String) {
    println("hello, $name")
    var instagramBio: String? = "nice" // same as instagramBio: String?=null

    if (instagramBio != null) {
        println(instagramBio.toUpperCase())
    }
    instagramBio?.toUpperCase()
}

fun operators() {
    val s1 = "call me"
    val s2 = " maybe"
    val combined = s1 + s2
    println(combined)
}

fun stringOperators() {
    val myString = "SIGMA CAMP"
    println(myString[0])
    println(myString[1])
    println(myString.isEmpty())
    println(myString.substring(2,4))
    println("The string is $myString")

}

fun conditions() {
    val testScore = 88
    // statement can be anything with true or false return value:
    if (testScore > 70) {
        println("You passed!")
    } else {
        println("You failed!")
    }
    // How to trigger else block?
    if (testScore < 70) {
        println("You failed!")
    }
}

fun friends() {
    val name1 = "Alissa"
    val name2 = "Jessica"
    val name3 = "Mark"
    val names = listOf ("Alissa", "Jessica", "Mark")
    val smartNames = mutableListOf("Noa", "Eli")
    smartNames.add("Katya")
    // to print all
    for (name in names) {
        println(name)
    }

    for (i in 1..5) {
        println(i)
    }

    for (i in 1 until 5) {
        println(i)
    }
}