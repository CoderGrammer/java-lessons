package com.lessons.interfaces;

/*
 - Other than methods, what can interfaces hold?
*/
public class _19_WhatCanTheyHold {

    /*
     - All of these are static by default
    */
    interface X {

        class A { }

        abstract class B { }

        interface C { }

        // How about static blocks?
        // static {
        //
        // }
    }

    /*
     - Fields are static
     - In fact they are not fields they are constants
     - They are just values - they do not relate to an instance
    */
    interface A {
        static String s = "aaa";
        static final String t = "bbb";
        public static final String y = "bbb";
        // private static final String q = "bbb";
        // protected static final String a = "bbb";
    }

}
