package com.lessons.optional;

import java.util.Optional;
import java.util.function.Function;
import static com.lessons.optional._99_Utils.print;

/*
 - Is it a monad?
     - Simply a Functor with a flatMap method...
     - What is a Functor (a wrapper with a map method)
     - Example wrapper type, having a unit (ofNullable) method, and a bind (flatMap)
       method
     - Something that puts something in a box (or a context)
     - Three laws need to be satisfied:
        1. Left identity
            - If we take a value, put it in a default context with return and then feed
              it to a function by using >>= (flatMap), it's the same as just taking the
              value and applying the function to it
            - 'return x >>= f' same as 'f x'
        2. Right identity
            - If we have a monadic value and we use >>= (flatMap) to return the result
              it is our original monadic value
            - 'm >>= return' same as 'm'
        3. Associativity
            - When we have a chain of monadic function applications with >>= (flatMap),
              it shouldn't matter how they're nested
            - Doing '(m >>= f) >>= g' is just like doing 'm >>= (x -> f x >>= g)'
     - Where things become problematic:
         - The context should not change after calling map
         - flatMap can change the context
         - If we compose two functions and the first produces null, this will be passed
           to the second
         - If we map that first function on Optional to a null it must become empty
         - As this cannot contain null, the second function does not get called
         - So what about using flatMap instead. It is after all there to change the box
         - Well that is fine
         - The issue is that in Javas Optional it can never contain null so if there is
           ever a case where null is a value scenario you wont be able to map it!
         - The map method violates the composition laws (in the case of nulls)
         - If we have a function that returns null it will pass the null to the next one
         - However in Java Optional if we map to a null, the next mapped function wont
           get called at all
         - This difference in behaviour depending on how compose things means that we
           have to be careful when refactoring
         - This is something that functional programmers will not be happy about
         - flatMap is more conducive to changing the shape of the box e.g. if you had
           a Stream then flatMap could add entries to it.
         - The same way when we may go from an Optional-present to mapping to a null we
           should ideally use flatMap (although not needed in Java because map can map
           to null Optional-empty)
*/
public class _32_Monad {

    public static void main(String[] args) {

        Optional<Integer> integer = Optional.of(1)
                .map(i -> null) // Becomes Optional.empty()
                .map(i -> 55); // Can no longer operate on the null
        print(integer);

        // Left identity
        Function<Integer, Optional<Integer>> fDouble = x -> Optional.of(x * 2);
        boolean e1 = Optional.of(1).flatMap(fDouble).equals(fDouble.apply(1));
        print(e1);

        // Right identity
        boolean e2 = Optional.of(1).flatMap(Optional::of).equals(Optional.of(1));
        print(e2);

        // Associativity
        Function<Integer, Optional<Integer>> fDouble2 = i -> Optional.of(i * 2);
        Function<Integer, Optional<Integer>> fHalf = i -> Optional.of(i / 2);
        boolean e3 = Optional.of(5).flatMap(fDouble2).flatMap(fHalf)
                .equals(Optional.of(5).flatMap(g -> fDouble.apply(g).flatMap(fHalf)));
        print(e3);
    }

}
