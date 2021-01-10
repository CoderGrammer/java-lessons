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
public class _28_CheckerFramework {

    void callerA() {
        service("abc"); // Fine
    }

    void callerB(@Nullable String i) {
        service(i); // Error
    }

    void callerC() {
        service(null); // Error
    }

    void service(@NonNull String i) {
    }

}
