package com.lessons.optional;

import com.lessons.optional._99_Utils.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lessons.optional._99_Utils.print;

public class _03_NullBasicsMore {

    public static void main(String[] args) {
        new _03_NullBasicsMore().equality();
    }

    void nullLiteral() {
        // the null type has one value, the null reference represented by the null literal
        String s = null;
    }

    /*
     - null is not an instanceof anything
    */
    void instanceOf() {
        // Employee e = new Employee();
        // print(e instanceof Employee);

        String s = null;
        print(s instanceof String);
    }

    // null == null in Java
    void equality() {
        // Employee e = new Employee();
        // Employee e2 = new Employee();
        // print(e == e2);

        print(null == null); // true
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
     - You cannot sync on a null
     - Runtime problems are worse than compile time
    */
    void sync() {
        String kk = null;
        synchronized (kk) { // NPE!
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

    enum A { x, y}
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

        List.of(null); // NPE
        Map.of(null, null); // NPE
    }

}
