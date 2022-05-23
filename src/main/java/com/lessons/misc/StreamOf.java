package com.lessons.misc;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 - What is it?
    - A method for converting elements or arrays to a stream
    - But remember in Java methods can be overloaded
    - So there could be more than one Stream.of...
    - And how does it compare to Arrays.stream
*/
public class StreamOf {

    public static void main(String[] args) {
        StreamOf s = new StreamOf();
        s.otherPrimitives();
    }

    void streamOfOneElement() {
        Stream<String> a = Stream.of("");
    }

    void streamOfMultipleElements() {
        Stream<String> b = Stream.of("", "");
    }

    void streamOfNull() {
        // Stream<String> c = Stream.of(null);
        Stream<String> d = Stream.ofNullable(null);
    }

    void comparedToArraysStream() {
        String [] x = new String[] {"", ""};
        Stream<String> e = Stream.of(x);
        Stream<String> f = Arrays.stream(x);
        /*
         - Seems like there's no real difference for non-primitive types
            - In fact let's see the code for Stream.of
        */
    }

    // Let's try some primitives
    void howAboutPrimitives() {
        int[] i = new int[] {1, 2};
        Stream<int[]> e = Stream.of(i);
        e.forEach(System.out::println);

        IntStream f = Arrays.stream(i);
        f.forEach(System.out::println);
    }

    void theProblemWithStreamPrimitives() {
        /*
         - The stream.of version is a stream of one element
         - An array
         - So we need to 'flatten' it
        */
        int[] i = new int[] {1, 2};
        Stream<int[]> e = Stream.of(i);
        IntStream is = e.flatMapToInt(Arrays::stream);
        is.forEach(System.out::println);
    }

    void otherPrimitives() {
        // What about other primitives
        boolean [] b  = new boolean[] {true, false};
        // Arrays.stream(b); // Does not work
        // There are not enough overloaded methods

        // How about...
        char [] ch  = new char[] {'a', 'b'};
        // Arrays.stream(ch); // Does not work
        // Same problem

        Stream<boolean[]> b1 = Stream.of(b);
        Stream<Boolean> booleanStream = b1.flatMap(f -> IntStream.range(0, f.length).mapToObj(index -> f[index]));
        booleanStream.forEach(System.out::println);
    }

    /*
     - So let's summarise
        - Stream.of and Arrays.stream are equivalent for objects
        - For primitive arrays Stream.of creates a stream with one element, not what you want
            - You have to flatten it
        - For primitive arrays Arrays.stream does what you would expect
            - However it only works for certain primitive types
            - So then you are back to Stream.of but with flat-mapping required
    */

}
