package com.lessons.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.util.Objects;

/*
 - One annotation that is a bit different!
    - Why is this different?
    - Well lombok is an interesting hack if you will :)
    - The annotations are processed at compile time and the bytecode is inserted
    - So it's really a lot like writing the code yourself
    - It's not something that will give you a gentle warning but throw a runtime exception just like one you coded yourself
    - Let's prove it with de-lombok
*/
@Data
public class _27_Z_OneAnnotationThatIsDifferent {

    public static void main(String[] args) {
        a();
    }

    static void a() {
        b(null);
    }

    static void b(@NonNull String s) {
        Objects.requireNonNull(s);

    }

}
