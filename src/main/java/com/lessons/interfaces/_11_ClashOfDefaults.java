package com.lessons.interfaces;

public class _11_ClashOfDefaults {

    interface A { default void x() { } }
    interface B { default void x() { } }

    // You are forced to override the method because there is a clash
    // class Z implements A, B {
    // }

     class X implements A, B {

         @Override
         public void x() {
            A.super.x(); // You can still call any super method you need
         }
     }

}
