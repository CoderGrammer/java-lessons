package com.lessons.interfaces;

public class _11_ClashOfDefaults {

    interface A { default void x() { } }
    interface B { default void x() { } }

    // You are forced to override the method because there is a clash
    // class Z implements A, B {
    // }

}
