package com.lessons.optional;

import static com.lessons.optional._99_Utils.print;

public class _03_NullBasicsDefaultValues {

    /*
     - For all reference types the default value is null
     - Reference types (on the stack) contain a pointer to mem location of the object on
       the heap
     - Primitives (on the stack) (instead of containing a pointer) contain the actual
       value
     - Primitives get a 'sensible' default but the default for references is null
     - This is not the same as uninitialized in a local var but you will get a compile
       error if you try to use it
    */
    String k;
    void defaultForRefTypes() {
        print(k); // null

       // Member uninitialized
       // String o;
       // print(o.getBytes());
       //
       // // Null (not uninitialized)
       // String ooo = null;
       // print(ooo.getBytes());
    }

    static int i; // Inits to null
    int j; // Inits to null

    void primitives() {
        // Static and instance variables:
        print(i); // null
        print(j); // null

        /*
         - Member variables:
         - int l = null; // Illegal! Compile error!
        */
        int o;
        /*
         - print(l); // null
         - print(o); // Illegal! Compile error!
        */
    }

    String t;
    Integer g;
    // null is the default value for all reference types
    void defaultValue() {
        print(t); // prints null
        print(g); // prints null
    }

    static String x; // Inits to null
    String y; // Inits to null

    void objects() {
        // Static and instance variables:
        print(x); // null
        print(y); // null

        // Member variables:
        String s = null;
        String t;
        print(s); // null
        // print(t); // Illegal! Compile error!
    }

}
