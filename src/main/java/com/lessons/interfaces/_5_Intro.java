package com.lessons.interfaces;

public class _5_Intro {

    /*
     - What is an interface?
    */

    /*
     - A class like structure
     - Denoted with the keyword 'interface'
    */
    class Dog { }
    interface Animal { }

    /*
     - An interface is usually implemented by classes but doesn't have to be
    */

    /*
     - A class may implement many interfaces
    */
    class Cat implements Animal, Feline { }
    interface Feline { }

    /*
     - Interfaces may extend other interfaces
    */
    interface BigCat extends Feline, Animal { }

    /*
     - Interfaces are inherently static
         - i.e. they do not relate to any instance (of a class)
     */
    interface ImKindaStatic { }

}
