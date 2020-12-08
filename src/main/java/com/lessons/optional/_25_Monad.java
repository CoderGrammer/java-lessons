package com.lessons.optional;

import java.util.Optional;
import java.util.function.Function;

/*
 - Is it a monad?
     - A Functor with a flatMap method...
     - What is a Functor (a wrapper with a map method)
     - A wrapper type, having a unit (ofNullable) method, and a bind (flatMap) method
     - Three laws need to be satisfied:
        1. Left identity
            - If we take a value, put it in a default context with return and then feed it to a function by using >>=
              (flatMap), it's the same as just taking the value and applying the function to it.
            - 'return x >>= f' same as 'f x'
        2. Right identity
            - If we have a monadic value and we use >>= (flatMap) to feed it to return, the result is our original
              monadic value.
            - 'm >>= return' same as 'm'

        3. Associativity
            - When we have a chain of monadic function applications with >>= (flatMap), it shouldn't matter how they're
              nested
            - Doing '(m >>= f) >>= g' is just like doing 'm >>= (\x -> f x >>= g)'
     - Where things become problematic:
         - The structure should not change after calling map/flatMap
         - If we compose two functions and the first produces null, this will be passed to the second
         - If we map that first function on Optional it must become empty
         - As this cannot contain null, the second function does not get called
         - So what about using flatMap instead. It is after all there to change the box
         - Well that is fine
         - The issue is that in Javas Optional it can never contain null so if there is ever a case where null is a
           value scenario you wont be able to map it!
         - The map method violates the composition laws (in the case of nulls)
         - If we have a function that returns null it will pass the null to the next one
         - However in java Optional if we map to a null, the next mapped function wont get called at all
         - This difference in behaviour depending on how compose things means that we have to be careful when refactoring
         - This is something that functional programmers will not be happy about
         - Flat map is more conducive to changing the shape of the box e.g. if you had a Stream then flatMap could add entries to it.
         - The same way when we may go from an Optional-present to mapping to a null we should ideally use flatMap (although not needed in java because map can map to null Optional-empty)
         - In the flatMap method you can wrap the output of the first function in an optional in order to invoke the
*/
public class _25_Monad {

    public static void main(String[] args) {

        // Left identity
        Function<Integer, Optional<Integer>> fDouble = x -> Optional.of(x * 2);
        boolean e1 = Optional.of(1).flatMap(fDouble).equals(fDouble.apply(1));
        System.out.println(e1);

        // Right identity
        boolean e2 = Optional.of(1).flatMap(Optional::of).equals(Optional.of(1));
        System.out.println(e2);

        // Associativity
        Function<Integer, Optional<Integer>> fDouble2 = i -> Optional.of(i * 2);
        Function<Integer, Optional<Integer>> fHalf = i -> Optional.of(i / 2);
        boolean e3 = Optional.of(5).flatMap(fDouble2).flatMap(fHalf)
                .equals(Optional.of(5).flatMap(g -> fDouble.apply(g).flatMap(fHalf)));
        System.out.println(e3);
    }

}
