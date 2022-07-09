package com.blocks;

/*
 - When do they get called?
     - Instance initializers are called from within the constructor after
         - the super call
 - So if we can use a default constructor then why do we need instance initializers?
    - Well, repetitive code from constructors can be moved to instance initializers
    - You may or may not prefer this to calling a method
    - One advantage over calling a method is that you don't need to remember to invoke a method
        - if more constructors are added
    - Since Java is taking care of that for you
    - Let's look at an example:
*/
public class _02_BlocksOrder {

    static {
        System.out.println("Static block 1");
    }

    {
        System.out.println("something repetitive");
    }

    _02_BlocksOrder() {
        System.out.println("constructor 1");
        doSomething();
    }

    void doSomething() {
        System.out.println("something");
    }

    _02_BlocksOrder(String s) {
        System.out.println("constructor 2");
    }

    public static void main(String[] args) {
        new _02_BlocksOrder();
        new _02_BlocksOrder("");
    }

}

