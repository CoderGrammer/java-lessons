package com.lessons.optional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

// See java-lessons-15/src/main/java/HelpfulNPEs.java
public class _27_Java14HelpfulNPEs {

    public static void main(String[] args) {
        new A(new B()).getB().getC().getS();
    }

    @Value
    static class A {
        B b;
    }

    @Getter
    @NoArgsConstructor
    static class B {
        C c;
    }

    @Value
    static class C {
        String s;
    }

    // NPEs using arrays...
    static Integer[][][] multi = {{{1}}, {null}, {{2, 3}}};

//    public static void main(String[] args) {
//        whichPartIsNull();
//    }

    static void whichPartIsNull() {
        /*
         - We refer to something for which there is an index because we done want
         - IndexOutOfBoundsException
        */
        print(multi[1][0][0].toString());
    }

}
