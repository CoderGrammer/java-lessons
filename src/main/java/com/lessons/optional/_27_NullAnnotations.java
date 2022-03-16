package com.lessons.optional;

import com.lessons.optional._99_Utils.Car;
import com.lessons.optional._99_Utils.Engine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 - Null annotations!
     - Annotations you can place on your code to prevent null coding issues early on
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
     - Some are compile time, some retained at runtime for validation
     - We will mainly be looking at the ones that help at development time rather than
       validation
     - They have different levels of support in different IDEs and setups
     - There is little consistency
     - Not sure that I would not bother with them personally!
         - Unless they are used consistently they may give false sense of security
     - I prefer to:
         - Return Optional from service methods
         - Return nulls from beans not Optional
         - Protect params with Objects.requireNonNull()
         - Consider the Null Object Pattern in limited cases
*/
public class _27_NullAnnotations {

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
        // Warning as expected
        a(null);

        // No warning! Even though engine is null!
        a(new Car(1000, null).getEngine());
    }

    void a(@NotNull Engine e) { }

}
