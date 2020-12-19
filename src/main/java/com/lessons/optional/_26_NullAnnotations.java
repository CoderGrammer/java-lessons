package com.lessons.optional;

import com.lessons.optional._99_Utils.Engine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 - There is no shortage of them:
     - javax.annotation
     - javax.validation.constraints
     - android.support.annotation
     - edu.umd.cs.findbugs.annotations
     - org.eclipse.jdt.annotation
     - org.jetbrains.annotations
     - org.checkerframework.checker.nullness.qual
     - lombok.NonNull
     - org.springframework.lang.Nullable
 - Some are compile time, some retained at runtime but provide no runtime safety
 - They have different levels of support in different ides and setups
 - There is little consistency
 - Not sure I would not bother with them personally!
 - I prefer to:
     - Return Optional from service methods
     - Return nulls from beans not Optional
     - Protect params with Objects.requireNonNull()
     - Consider the Null Object Pattern in limited cases
*/
public class _26_NullAnnotations {

    public static void main(String[] args) {
    }

    // Parameter null detection

    void main() {
        // Generates a warning
        doIt(null);
        // No warning
        doThis(null);
    }

    void doIt(@NotNull String name) { }
    void doThis(String name) { }

    // Method return null detection

    void printGet() {
        // Generates a warning
        int l1 = get().length();

        // No warning
        int l2 = get2().length();
    }

    @Nullable
    String get() {
        return null;
    }

    String get2() {
        return null;
    }

    // Can still be violated!

    void b() {
        // No warning!
        a(new _99_Utils.Car(1000, null).getEngine());
        // Warning
        a(null);
    }

    void a(@NotNull Engine e) { }

}
