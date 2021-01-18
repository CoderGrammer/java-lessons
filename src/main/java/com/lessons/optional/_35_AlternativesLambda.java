package com.lessons.optional;

import com.jnape.palatable.lambda.adt.Maybe;
import com.jnape.palatable.lambda.functions.Fn1;

import java.util.Optional;
import java.util.function.Function;

import static com.lessons.optional._99_Utils.print;

/*
 - Maybe monad
 - https://github.com/palatable/lambda#maybe
 - Not serializable
 - This also differs from Optional in how map and flatMap behave
 - Similar to VAVR it will throw an exception if you map to a null then map again
 - You are meant to flatMap the nullable then wrapped in a Maybe
 - Can convert back and forth between this and Java Optional
 - Other than that there are lots of other functional sounds methods on the class
*/
public class _35_AlternativesLambda {

    public static void main(String[] args) {
        // Java
        Function<Integer, Object> nullResultFn = __ -> null;
        Optional.of(1).map(nullResultFn); // Optional.empty()

        // Lambda
        Fn1<Integer, Object> nullResultFn1 = __ -> null;
        // Maybe.just(1).fmap(nullResultFn1).fmap(String::valueOf); // throws NullPointerException

        Maybe<String> m =
                Maybe.just(1).fmap(g -> Maybe.maybe(nullResultFn1.apply(g)))
                        .fmap(String::valueOf); // Nothing
        print(m); // You get a wrapped Nothing

        Maybe<String> m1 =
                Maybe.just(1).flatMap(g -> Maybe.maybe(nullResultFn1.apply(g)))
                        .fmap(String::valueOf); // Nothing
        print(m1); // Correct you get a Nothing

        // Convenience methods
        Optional<String> s = m.toOptional();
    }

}
