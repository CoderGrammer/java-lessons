package com.lessons.interfaces;

/*
 - Where can we declare interfaces?
*/
public class _24_Where {

    // At the top level - see _1_Example

    // Inside a class (nested interface)
    interface Embeddable { }
    static interface EmbeddableStatic { }

    // Not inside an inner class
    class Inner {
        // interface InsideInner { }
    }

    // Inside a static nested class
    static class Nested {
        interface InsideNested { }
    }

    // Not inside a method
    void meth() {
        // interface A { }
    }

    // Not inside a static block
    static {
        // interface A { }
    }

    // Inside an interface
    interface A {
        interface B {
            interface C { }
        }
    }

}
