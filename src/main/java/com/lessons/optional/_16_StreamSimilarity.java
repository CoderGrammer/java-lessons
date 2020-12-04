package com.lessons.optional;

import java.util.stream.Stream;

/*
Similarity to Streams
     - Many of the meths on Optional are similar to methods found in java streams
     - They are often used together which can be confusing
     - The operations on streams are very useful and serve many use cases, therefore it is understandable why you
       might want to treat Optionals as Streams
     - This is now possible as Optional has some of the same methods as streams to facilitate this
         - …and if this is not enough you can convert an Optional to a stream with stream() method
*/
public class _16_StreamSimilarity {

    public static void main(String[] args) {
        Stream.of("a" ,"b")
                .map(String::toUpperCase)
                .flatMap(s -> Stream.of(s.split("\\s")))
                .filter(s -> s.startsWith("a"))
                .count();
    }

}
