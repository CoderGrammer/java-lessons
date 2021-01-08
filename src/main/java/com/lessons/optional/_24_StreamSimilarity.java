package com.lessons.optional;

import java.util.Optional;
import java.util.stream.Stream;

/*
 - Similarity to Streams
     - Many of the meths on Optional are similar to methods found in java streams
     - They are often used together which can be confusing
        - You might have an outer Stream of Optionals e.g. Stream<Optional<String>>
        - You might have a Stream which results in a single Optional e.g. findFirst()
     - The operations on streams are very useful and serve many use cases, therefore it
       is understandable that you might want to treat Optionals as Streams
     - This is now possible as Optional has some of the same methods as streams to
       facilitate this
         - …and if this is not enough you can convert an Optional to a Stream with the
         stream() method
*/
public class _24_StreamSimilarity {

    public static void main(String[] args) {
        Stream
                .of("a", "b")
                .map(String::toUpperCase)
                .flatMap(s -> Stream.of(s.split("\\s")))
                .filter(s -> s.startsWith("a"))
                .count(); // Not this one

        Optional
                .of("abc")
                .stream()
                .map(String::toUpperCase)
                .flatMap(s -> Stream.of(s.getBytes())) // Not the same as Optional
                .findAny();

    }

}
