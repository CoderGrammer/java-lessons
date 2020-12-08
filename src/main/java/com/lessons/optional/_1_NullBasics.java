package com.lessons.optional;

import com.lessons.optional._100_Utils.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 - Null was invented by Tony Hoare in 1964 (not in Java!)
 - He called null his 'Billion dollar mistake'
 - 30 odd years later adopted into Java
 - For all reference types the default value is null
*/
public class _1_NullBasics {

    public static void main(String[] args) {
    }

    /*
     - For all reference types the default value is null
     - Reference types (on the stack) contain a pointer to mem location of the object on the heap
     - Primitives (on the stack) (instead of containing a pointer) contain the actual value
     - Primitives get a 'sensible' default but the default for references is null
     - This is not the same as uninitialized in a local var but you will get a compile error if you try to use it
    */
    String kkkk;
    void defaultForRefTypes() {
        System.out.println(kkkk); // null

//        // Unintialised
//        String ooo;
//        System.out.println(ooo.getBytes());

//        // Null (not uninitialized)
//        String ooo = null;
//        System.out.println(ooo.getBytes());
    }

    /*
     - null is not an instanceof anything
    */
    void instanceOf() {
        String s = null;
        System.out.println(s instanceof String);
    }

    // null == null in Java
    void equality() {
        System.out.println(null == null); // true
    }

    /*
     - null is not an object
     - null is a 'reserved word' aka 'keyword'
     - reserved words are always lowercase
     - There are around 50 of them
     - Cannot be used as an identifier
     - null is a literal value
     - it is case sensitive so null is not the same as Null

     - one way to handle null is to try/catch the NPE
     - Null improvements in Java 14
    */
    void reserved() {
        // String null = ""; // Illegal! Compile error!
    }

//    - Null is useful for lazy init pattern - only init when requested


    void lazy() {
        Integer i;
        // do some stuff
    }

    /*
     - Casting makes no difference
     - Remember Strings are immutable
    */
    void casting() {
        String sx = (String) null;
        System.out.println(sx + "A");
        System.out.println(sx.toUpperCase()); // Actually still null
    }

    static class Statik {
        static void str() {
            System.out.println("hello");
        }
    }

    /*
     - Shocking! You can call a method on a null reference!
     - Well not quite. Java knows that it is a static method
     - Statics live on the Stack not the Heap
    */
    void statik() {
        Statik a = null;
        a.str();
    }

    /*
     - You cannot sync on a null
     - Runtime problems are worse than compile time
    */
    void sync() {
        String kk = null;
        synchronized (kk) { // NPE!
            System.out.println("no way");
        }

        // Cannot use uninitialized - compile error!
        // String jj;
        // synchronized (jj) { // Not initialised compile error
        //     System.out.println("no way");
        // }

        // Cannot use null - compile error!
        // synchronized (null) { // Required Object got null
        //     System.out.println("no way");
        // }
    }

    // When you unbox a null you get NPE:
    void boxing() {
         Integer inn = null;
         int j1 = inn; // NPE!
    }

    String t;
    Integer g;
    // null is the default value for all reference types
    void defaultValue() {
        System.out.println(t); // prints null
        System.out.println(g); // prints null
    }

    enum A { x, y}
    // Because any reference can be null!
    void enumsRefsCanBeNull() {
        A a = null;
    }

    void nullLiteral() {
        // the null type has one value, the null reference represented by the null literal
        String s = null;
    }

    void failure() {
        // Calling a member method
        String s = null;
        s.length(); // NPE

        // Calling a member variable
        Employee e = null;
        int i = e.id; // NPE

        // Calling an array reference
        int[] a = null;
        int k = a[1]; // NPE
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

    void collectionsInconsistentOnNulls() {
        // Allowed ??
        List<?> a = new ArrayList<>();
        a.add(null);

        // Allowed ??
        Map<?, ?> m = new HashMap<>();
        m.put(null, null);
        System.out.println(m.size());

        List.of(null); // NPE
        Map.of(null, null); // NPE
    }


}
