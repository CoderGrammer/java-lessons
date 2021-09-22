package com.lessons.interfaces;

/*
 - What are functional interfaces?
    - They are interfaces which be a substituted with lambdas/method references
*/
public class _44_FunctionalInterfaces {

    // We can declare functional interfaces which allow us to use lambdas

    @FunctionalInterface
    interface MakeSomething {

        void make();

        // void makeIt();

    }

    void manufacture(MakeSomething m) {
        m.make();
    }

    public static void main(String[] args) {
        _44_FunctionalInterfaces f = new _44_FunctionalInterfaces();

        // If it were not a functional interface we would have to do this...
        f.manufacture(new MakeSomething() {
            @Override
            public void make() {
                System.out.println("Making cake");
            }
        });

        // But as it is, we can do this...
        f.manufacture(() -> System.out.println("Make a simple cake"));
    }

    // However, the functional interface annotation is optional
    // Having it will force the compiler to enforce it remaining a 'Functional Interface'

}
