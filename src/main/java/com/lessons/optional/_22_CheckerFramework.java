package com.lessons.optional;


import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/*
 - To execute run -PrunCheckFramework
 - NullnessChecker
 - Problems with checker frameworks:
     - They require code so might as well use Optional if it does what you need
     - Does not protect API methods unless the client is using the Checker Framework
*/
public class _22_CheckerFramework {

    void a(@Nullable String i) {
    }

    void c() {
        b(null);
    }

    void d(@Nullable String i) {
        b(i);
    }

    void b(@NonNull String i) {
    }

}
