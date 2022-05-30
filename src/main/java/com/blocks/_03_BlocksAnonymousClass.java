package com.blocks;

/*
 - Useful with anonymous classes
    - Since you can't use constructors there...
*/
public class _03_BlocksAnonymousClass {

    interface Cat {
        void meow();
        void purr();
    }

    /*
     - Initialisation blocks can be useful for anonymous classes
    */
    void callAMethodThatTakesAnAnonymousClass() {
        methodTakesAnonymousClass(new Cat() {

            int i;

            {
                i  = 10;
            }

            // Oops! Not allowed...
            // Cat() { }

            static {
                System.out.println("static");
            }

            @Override
            public void meow() {
                System.out.println("meow");
            }

            @Override
            public void purr() {
                System.out.println("purr");
            }
        });
    }

    void methodTakesAnonymousClass(Cat cat) { }

}

