package com.lessons.optional;

public class StaticTest {

    static class A {
        public static void string() {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        A a = null;
        a.string();
    }

}
