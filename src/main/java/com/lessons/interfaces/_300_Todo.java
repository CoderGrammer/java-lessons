package com.lessons.interfaces;

public class _300_Todo {

    /*

    DONE Interfaces have an advantage over abstract classes as abstract classes only allow inheriting one
    DONE Purpose: Hide implementation details
    DONE -2 interfaces can have the same default method
    DONE They are sometimes called defender methods
    They can call super interface methods with Top.super.meth()
    You can also have the interface as a reference var:
    List l = new ArrayList();
        Then you can pass list around
    And change to another type of list without impacting most of the code
    Can you override default methods

 - You cannot create an instance of an interface
 - default is public static final - all attributes are public static final
 - they have to be public or default scope (which is package scope)

 - default methods allow library developers to add methods to interfaces but ensure
 compatibility with older methods

 - If you override a default method you can still invoke one of the super methods:
    FlyCar.super.startEngine()

 - naming conventions
  - Simple names like Car - Is A
  - able - Can do/Has characteristic
  - Can, Has, Must
  - I - a bit of hungarian notation
  - HavingMetadata
  - RequiringAuthentication
    */

}
