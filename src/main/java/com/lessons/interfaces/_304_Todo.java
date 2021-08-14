package com.lessons.interfaces;

public class _304_Todo {

    /*
    DONE Interfaces have an advantage over abstract classes as abstract classes only allow inheriting one
    DONE Purpose: Hide implementation details
    DONE -2 interfaces can have the same default method
    DONE They are sometimes called defender methods
    DONE They can call super interface methods with Top.super.meth()
    You can also have the interface as a reference var:
    DONE List l = new ArrayList();
        Then you can pass list around
    DONE And change to another type of list without impacting most of the code
    DONE Can you override default methods
    DONE You cannot create an instance of an interface
    DONE - default is public static final - all attributes are public static final
    DONE - they have to be public or default scope (which is package scope)
    DONE - naming conventions
          - Simple names like Car - Is A
          - able - Can do/Has characteristic
          - Can, Has, Must
          - I - a bit of hungarian notation
          - HavingMetadata
          - RequiringAuthentication

          - Consider avoiding Hungarian notation
          - What is Hungarian Notation
          - The IDE shows you what things are anyway

    DONE - default methods allow library developers to add methods to interfaces but ensure
            compatibility with older methods

    DONE - If you override a default method you can still invoke one of the super methods:
        FlyCar.super.startEngine()

 - adding a method to an interface is not source compatible - implementors will not compile!
 - default methods are source compatible - implementors will compile fine
 - of course implementing interfaces/classes can still have their own implementations
 - interfaces can also override methods
 - default methods remove the need for implementations to have empty methods
  - this could be because your type hierarchy is badly designed
 - You effectively get multiple inheritance - but no state remember

 - I generally like to keep interfaces small
    - I find it easier to compose

 - Resolution rules are used to deal with conflicts



 - which default method gets chosen


    Continue from here:
        https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html
    Continue from java8 in action
        about the bytecode stuff being different
    */

}
