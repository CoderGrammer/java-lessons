package com.lessons.optional

/*
 - Major difference is there is no wrapper / no monad
 - more info from here: https://typealias.com/guides/java-optionals-and-kotlin-nulls/
*/
class AlternativeKotlin

    fun main(args : Array<String>) {
        println("Hello, World!")

        val thing: String? = "thingy"
        val nothing: String? = null

        println(thing?.toUpperCase()) // non-null gets mapped
        println(nothing?.toUpperCase()) // null stays null - not sure this will always be useful!
        // You can map it similar to how you do in Java Optional
        println(nothing?.let { "alternativeValue" })

    }
