package com.lessons.optional;

import com.lessons.optional._100_Utils.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 - Null was invented by Tony Hoare in 1964 (not in Java!)
 - Null is not the same as undefined
 - He called null his 'Billion dollar mistake'
*/
public class _1_NullBasics {

    // null is not an object
    // null is a 'reserved word' aka 'keyword'
    // reserved words are always lowercase
    // There are around 50 of them
    // Cannot be used as an identifier
    void reserved() {
        // String null = ""; // Illegal! Compile error!
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

    public static void main(String[] args) {
        new _1_NullBasics().collectionsInconsistentOnNulls();
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

        // Member variables:
        // int l = null; // Illegal! Compile error!
        int o;
        // System.out.println(l); // null
        // System.out.println(o); // Illegal! Compile error!
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
