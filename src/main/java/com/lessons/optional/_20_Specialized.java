package com.lessons.optional;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

/*
Where required we can use the specialised classes:
     - OptionalDouble
     - OptionalInt
     - OptionalLong
     - Analogous to specialised streams IntStream, DoubleStream, LongStream...
     - Note there are fewer of these than there are primitives
     - Probably to prevent an explosion of types and because these three handle most cases much like IntStream,
       LongStream, DoubleStream and also functional types such as DoubleSupplier etc
     - Note, these optionals do not have all the methods of Optional
     - They do not extent Optional
     - They are missing filter, map and flatMap, ofNullable methods
     - The purpose of these is to mitigate the effect of boxing/unboxing
*/
public class _20_Specialized {

    public static void main(String[] args) {
        OptionalDouble average = IntStream.of(1, 2).average();
        // Stream could be empty... in which case this will be an empty OptionalDouble
        OptionalDouble average2 = IntStream.of().average();
    }

}
