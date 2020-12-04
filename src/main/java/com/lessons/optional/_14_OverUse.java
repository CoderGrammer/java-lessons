package com.lessons.optional;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/*
 - Care is needed to prevent heap pollution when creating lots of Optionals
 - More expensive than a reference
 - Can lead to cache misses
 - Note if Optional becomes a value type (project valhala) then this cost might not be an issue
*/
public class _14_OverUse {

    public static void main(String[] args) {

        // Example 1 - 42 MB
        List<Integer> c =
                IntStream.range(0, 1_000_000)
                        .mapToObj(Integer::valueOf)
                        .collect(toList());

//            // Example 2 - 56 MB
//            List<Optional<Integer>> c2 =
//                    IntStream.range(0, 1_000_000)
//                            .mapToObj(i -> Optional.of(Integer.valueOf(i)))
//                            .collect(toList());

        // Optional is around 16 byte = 16 MB - actual diff was approx 14 MB

    }

}
