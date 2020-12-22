package com.lessons.optional;

import static com.lessons.optional._99_Utils.print;

public class _04_NullBasicsDefaultValues {

    /*
     - Java Memory
         - Stack
            - For memory allocation and thread execution
            - Primitives, references to objects
         - Heap
            - Objects
     - For all reference types the default value is null
     - Reference types (on the stack) contain a pointer to mem location of the object on
       the heap
     - Primitives (on the stack) (instead of containing a pointer) contain the actual
       value
     - Primitives get a 'sensible' default but the default for references is null
     - This is not the same as uninitialized in a local var but you will get a compile
       error if you try to use it
    */

    /*
     - Instance Object variables
     - null is the default value for all object types
    */
    String t;
    Integer g;
    void instanceVarsObjects() {
        print(t); // prints null
        print(g); // prints null
    }

    /*
     - Instance primitive variables
         - Default to sensible defaults
         - They cannot be null!
    */
    int j;
    void instanceVarsPrimitives() {
        print(j);
    }

    /*
     - Static Object variables
        - Statics are class scoped so can't be declared in a method
        - The same initialization properties as instance variables
        - Default to null
    */
    static String s;
    void staticObjects() {
        print(s);
    }

    /*
     - Static primitive variables
        - Default to a sensible defaults, like instance variables
    */
    static int o;
    void staticPrimitives() {
        print(o);
    }

    /*
     - Member Object variables
         - Member variables are not initialized automatically
         - You must initialize before use
         - These are uninitialized NOT null
    */
    void memberVarsObjects() {
        Object f;
        // print(f.toString()); // Compile error
    }

    /*
     - Member primitive variables
        - Just like with objects these are uninitialized (not null)
    */
    void memberVarsPrimitives() {
        int q;
        // print(q); // Compile error
        // int y = null; // Compile error
    }

    /*
     - Member Object Variables Set to Null
         - Not really useful for our discussion as they do not default to null
    */
    void memberVarsObjectsNull() {
        Object o = null;
    }

    /*
     - Member primitive Variables Set to Null
         - Not really useful for our discussion as they do not default to null
    */
    void memberVarsPrimitivesNull() {
        // int g = null; // Compile error!
    }

}
