package com.lessons.optional;

public class _05_NullBasicsStorage {

    public static void main(String[] args) {
        new _05_NullBasicsStorage();
    }

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

    /*
     - Running this despite the compile error shows error alluding to the type
    */
    void proofOfTheSpecialNullType() {
        // null.toString();
    }

    void storage() {
        // Objects:
        Object o = new Object();
        /*
         - Stack:
             - Object o -> 98sdd88
         - Heap:
             - 98sdd88 -> Object()
        */

        // Primitives:
        int i = 5;
        /*
         - Stack:
             - i -> 5
             - Primitives live on the stack - unless they are the members of an object
             - References and primitives live on the stack and objects and their members live
               on the heap
             - The heap is only for objects
        */
        // What about uninitialized local vars?
        int k;
        /*
         - Stack:
             - Not our concern whether it is stored or not given that it's a compile
               error if you try to use it before init
             - Once it is init then it is stored like any other local primitive
        */
        // print(k); // Compile error!
    }

    // Although it could be implementation specific
    void nullStorage() {
        Object o = null;
        /*
         - Stack:
             - Object o -> (0) null
         */
    }

}
