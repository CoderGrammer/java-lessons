package com.lessons.optional;


import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

// To execute run -PrunCheckFramework
// NullnessChecker
public class _27_CheckerFramework {

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
