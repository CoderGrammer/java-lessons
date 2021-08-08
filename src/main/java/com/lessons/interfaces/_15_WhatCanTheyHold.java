package com.lessons.interfaces;

public class _15_WhatCanTheyHold {

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
