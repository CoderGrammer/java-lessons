package com.lessons.optional

/*
 - Null is the type of the null literal
 - It's a subtype of every type except value classes
 - Kinda sounds similar to Java in that null can be assigned to any reference type
 - But it's not as explicit in Java
 - In Java we say that null is a special literal that can be assigned to any reference
 - In Scala we say that Null extends all references
 - Scala also has Option/Some/None to represent different situations
 - If you are interested in functional programming and Scala its worth learning more
   about
 - Its very expressive to with Null, null, Nothing, Nill etc. Worth researching if you
   want to know more
*/
object HelloWorld {

  def main(args: Array[String]) {
    var o: Option[String] = Option("hello")
    var i: Option[String] = Option(null)

    println(o)
    println(i)

    println(o.map(s => s.toUpperCase))
    println(i.map(s => s.toUpperCase))
  }

}