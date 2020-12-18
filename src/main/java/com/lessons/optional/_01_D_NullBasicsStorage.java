package com.lessons.optional;

public class _01_D_NullBasicsStorage {

    /*
     - How is null stored?
     - Usually denoted with a zero address in memory but could be anything and
       implementation specific
     - Not really our concern
     - Maybe we can think of it as a singleton or a static in that we do not have to worry
       about storage of lots of nulls
     - null is of a special null type without having a name
     - No type can be declared of this special null type
     - The null reference type can always be cast to any type
     - We can mostly ignore the fact that there is a special null type as we cant refer to
       it in any way
    */
    void storage() {
        // Objects:
        Object o = new Object();
        /*
         - Stack:
         - Object o -> 98sdd88
         - 98sdd88 -> Int(6)
        */

        // Primitives:
        int i = 5;
        /*
         - Stack:
         - i -> 5
         - Primitives live on the stack - unless they are the members of an object
         - References and primitives live on the stack and objects and their members live
           on the heap
        */
    }

}
