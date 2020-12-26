package com.lessons.optional;

import static com.lessons.optional._99_Utils.print;

public class _05_NullBasicsStorage {

    public static void main(String[] args) {
        new _05_NullBasicsStorage().proofOfTheSpecialNullType();
    }

    /*
     - How is null stored?
         - Usually denoted with a zero address in memory but could be anything and
           implementation specific
         - Not really our concern
         - Maybe we can think of it as a singleton or a static (but not really) in that we
           do not have to worry about storage of lots of nulls
         - null is of a special null type with no name
         - No type can be declared of this special null type
         - The null reference type can always be cast to any type
         - We can mostly ignore the fact that there is a special null type as we can't
           refer to it in any way
    */

    /*
     - Running this despite the compile error shows error alluding to the type
    */
    void proofOfTheSpecialNullType() {
        // null.toString(); // <nullType>
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
         - You might think its stored on the stack:
             - Not our concern whether it is stored or not given that it's a compile
               error if you try to use it before init
             - Once it is init then it is stored like any other local primitive
        */
        // print(k); // Compile error!
    }

    // null storage, although it is implementation specific
    void nullStorage() {
        Object o = null;
        /*
         - Stack:
             - Object o -> (0) null
         */
    }

    /*
     - Questions:
         - 1. Is null an object?
         - 2. How is null stored?
         - 3. Does null live on the heap?
         - 4. Are lots of nulls a performance concern?
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. Is null an object?
            - Nope, not an object!
         - 2. How is null stored?
            - It is just a value of a reference on the stack. Probably zero but who
              cares? Implementation specific
         - 3. Does null live on the heap?
            - Nope, because it is not an object
         - 4. Are lots of nulls a performance concern?
            - Probably not as there is nothing on the heap although lots of references
              can still take up space in the stack so you might question your design
    */

}
