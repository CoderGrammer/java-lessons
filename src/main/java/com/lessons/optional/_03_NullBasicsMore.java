package com.lessons.optional;

import com.lessons.optional._99_Utils.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.lessons.optional._99_Utils.print;

public class _03_NullBasicsMore {

    void nullLiteral() {
        // The null type has one value, the null reference represented by the null literal
        String s = null;
    }

    /*
     - Technically does have a special null 'type'
     - This type has no name
     - It can be cast to any type
     - But does not extend Object
     - Does not live on the heap
     - The null literal is the only possible value of the special 'null' type
     - You cannot refer to this type in any way
     - You cannot declare something with this type directly
     - You cannot cast to it
     - You might as well imagine it does not exist
     - Best to thing of it as a 'special literal that can be of any type'
    */
    void isNullAnObject() {
        // print(null.toString());
        // null is NOT an object!
    }

    /*
     - If 100 references are assigned null - there are not 100 nulls
     - There is only one
     - I like to think of it conceptually as a singleton
    */
    void thereIsOnlyReallyEffectivelyOneNull() {
        List l = null;
        ArrayList i = null;
        print(l == i);
    }

    /*
     - See https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)
    */
    void equalsShouldAlwaysReturnFalseWhenPassedANull() {
        print("test".equals(null));
    }

    /*
     - Checks if an object is of a given type
     - null is not an instanceof anything
     - null is not an instanceof null (at least you can't check)
    */
    void instanceOf() {
        // Employee e = new Employee();
        // print(e instanceof Employee);

        // String s = null;
        // print(s instanceof String);

        // Not allowed:
        // print(null instanceof null);
    }

    /*
     - null == null in Java
     - == checks if the references point to the same memory location
     - == is true if two refs point to the same actual object
     - whereas .equals checks if objects are meaningfully equivalent
    */
    void equality() {
        // Employee e = new Employee();
        // Employee e2 = new Employee();
        // print(e == e2);
        // print(e.equals(e2);

        // print(null == null); // true
    }

    /*
     - null is not an object
     - it is a reference to no object
     - null is a 'reserved word' aka 'keyword'
     - reserved words are always lowercase
     - There are around 50 of them
     - Cannot be used as an identifier
     - null is a literal value
     - it is case sensitive so null is not the same as Null
    */
    void reserved() {
        // String s = null;
        // String null = ""; // Illegal! Compile error!
    }

    // Null is useful for lazy init pattern - only init when requested
    void lazy() {
        Integer i;
        // do some stuff
        i = 5;
        // do some more stuff
    }

    /*
     - Casting allows you to convert one type to another
     - Casting makes no difference
     - Remember Strings are immutable
    */
    void casting() {
        String sx = (String) null;
        print(sx + "Example");
        print(sx.toUpperCase()); // Actually still null
    }

    static class Statik {

        static void str() {
            print("hello");
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
     - Synchronization means only one thread can access a piece of code at a time
     - You cannot synchronize on a null
     - Runtime problems are worse than compile time
    */
    void sync() {
        String k = null;
        synchronized (k) { // NPE!
            print("no way");
        }

        // Cannot use uninitialized - compile error!
        // String jj;
        // synchronized (jj) { // Not initialized compile error
        //     print("no way");
        // }

        // Cannot use null - compile error!
        // synchronized (null) { // Required Object got null
        //     print("no way");
        // }
    }

    // When you unbox a null you get NPE:
    void boxing() {
         Integer inn = null;
         int j1 = inn; // NPE!
    }

    enum A { x, y }
    // Because any reference can be null!
    void enumsRefsCanBeNull() {
        A a = null;
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

    void collectionsInconsistentOnNulls() {
        // Allowed ??
        List<?> a = new ArrayList<>();
        a.add(null);

        // Allowed ??
        Map<?, ?> m = new HashMap<>();
        m.put(null, null);
        print(m.size());

        // New factory methods
        List.of(null); // NPE
        Map.of(null, null); // NPE
    }


}
