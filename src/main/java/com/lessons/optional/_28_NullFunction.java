package com.lessons.optional;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/*
 - Example null function is a function which makes no changes
 - aka NOP aka NOOP
*/
public class _28_NullFunction {

    // All these are equivalent null Function examples
    Function<String, String> f = Function.identity();
    UnaryOperator<String> u = UnaryOperator.identity();
    UnaryOperator<String> k = a -> a;
    UnaryOperator<String> j = a -> { return a; };

    public static void main(String[] args) {
        var namesJustAsTheyAre = getEmployeeNames(t -> t);
    }

    static List<String> getEmployeeNames(UnaryOperator<String> mapName) {
        var names = List.of("Joe", "Jamila", "Jim", "Jawad");
        return names
                .stream()
                .map(mapName)
                .collect(Collectors.toList());
    }

    /*
     - They don't necessarily have to do nothing as long as they don't create state
     - e.g. could be used to implement a wait
    */
    UnaryOperator<String> w = a -> {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Died waiting");
        }
        return a;
    };



}
