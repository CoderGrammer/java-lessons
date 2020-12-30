package com.lessons.optional;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/*
 - Care is needed to prevent heap pollution when creating lots of Optionals
 - More expensive than a reference
 - Optional consumes 4x the memory of a simple reference
 - Can lead to cache misses, because you have exceeded the cache limit
 - You have a dependent load, fetch the optional, fetch the value
 - Note if Optional becomes a value type (project Valhalla) then this cost might not be an
   issue
 - One of the things to keep in mind is that primitives in java are a lot cheaper than
   objects
 - If you want to use an Optional to represent something that could be represented by a
   primitive then you have to pay the cost of the wrapper object instance but also the
   Optional
*/
public class _14_OverUse {

    public static void main(String[] args) {

        // Example 1 - 42 MB
        List<Integer> c =
                IntStream.range(0, 1_000_000)
                        .mapToObj(Integer::valueOf)
                        .collect(toList());

       // // Example 2 - 56 MB
       // List<Optional<Integer>> c2 =
       //         IntStream.range(0, 1_000_000)
       //                 .mapToObj(i -> Optional.of(Integer.valueOf(i)))
       //                 .collect(toList());

        // Optional is around 16 bytes = 16 MB - actual diff was approx 14 MB

    }

}
