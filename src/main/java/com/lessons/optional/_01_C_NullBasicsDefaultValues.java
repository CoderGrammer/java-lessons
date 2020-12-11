package com.lessons.optional;

public class _01_C_NullBasicsDefaultValues {

    /*
     - For all reference types the default value is null
     - Reference types (on the stack) contain a pointer to mem location of the object on the heap
     - Primitives (on the stack) (instead of containing a pointer) contain the actual value
     - Primitives get a 'sensible' default but the default for references is null
     - This is not the same as uninitialized in a local var but you will get a compile error if you try to use it
    */
    String k;
    void defaultForRefTypes() {
        System.out.println(k); // null

//        // Member uninitialized
//        String o;
//        System.out.println(o.getBytes());

//        // Null (not uninitialized)
//        String ooo = null;
//        System.out.println(ooo.getBytes());
    }

    static int i; // Inits to null
    int j; // Inits to null

    void primitives() {
        // Static and instance variables:
        System.out.println(i); // null
        System.out.println(j); // null

        /*
         - Member variables:
         - int l = null; // Illegal! Compile error!
        */
        int o;
        /*
         - System.out.println(l); // null
         - System.out.println(o); // Illegal! Compile error!
        */
    }

    String t;
    Integer g;
    // null is the default value for all reference types
    void defaultValue() {
        System.out.println(t); // prints null
        System.out.println(g); // prints null
    }

    static String x; // Inits to null
    String y; // Inits to null

    void objects() {
        // Static and instance variables:
        System.out.println(x); // null
        System.out.println(y); // null

        // Member variables:
        String s = null;
        String t;
        System.out.println(s); // null
        // System.out.println(t); // Illegal! Compile error!
    }

}
