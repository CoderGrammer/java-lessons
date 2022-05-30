package com.blocks;

/*
 - Code blocks!
    - You can create code blocks in a few places...
    - Many devs are not really aware of them...
*/
public class _01_BlocksBasics {

    /*
     - Let's look at an example... an initialisation block
        - Not a method!
    */
    {
        System.out.println("Here is an instance level code block");
    }

    // Here is a static code block
    static {
        System.out.println("static 1");
    }

    /*
     - But Why?
        - Instance initializers
            - Well these can be useful for repeated code in constructors
            - And anonymous classes
            - Will show you that a little later on
        - Static initializers
            - Can be useful if you want something to happen before the class is loaded
            - Before any instance  is created
         - Inside methods
            - May be useful to create scope
            - But you could just call another method
    */

    /*
     - Here are some more examples... let's run this code and see
         - what order they run in
    */
    {
        System.out.println("instance 2");
    }

    static {
        System.out.println("static 2");
    }

    // Constructor
    _01_BlocksBasics() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        _01_BlocksBasics b = new _01_BlocksBasics();
    }

    // You can also arbitrarily nest them...
    {
        {
            {
                {
                    System.out.println("arbitrary nesting...");
                }
            }
        }
    }

}
