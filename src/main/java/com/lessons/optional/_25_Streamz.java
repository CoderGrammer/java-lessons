package com.lessons.optional;

import com.lessons.optional._99_Utils.Employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
 - stream()
     - This method allows you to treat an Optional as a Stream benefiting from all the
       Stream methods
     - This method is often useful with another Stream say from a collection of Cars
       for example
     - Usually used:
         - 1. With another streams flatMap method
         - 2. To treat an Optional as a Stream
     - It returns a Stream with the value or an empty Stream
     - This returns a Stream of 0 (empty) or 1 (present) elements
*/
public class _25_Streamz {

    public static void main(String[] args) {
        new _25_Streamz().withStreamsFlatMap();
    }

    /*
     - 1. With another streams flatMap method
         - Streaming over Optionals of something e.g. Stream<Optional<String>>
         - To unwrap an elements from Optional elements skipping the empties
    */
    void withStreamsFlatMap() {
        List<Optional<String>> l = List.of(
                Optional.empty(),
                Optional.of("a"),
                Optional.of("ab"),
                Optional.of("abc"));

        // // Attempt 1
        // l.stream()
        //         .findFirst()                 // Its now a single Optional
        //         .filter(Optional::isPresent) // So these methods are the Optional ones
        //         .map(Optional::get);

        // Attempt 2
        l.stream()
                .filter(Optional::isPresent) // So these methods are the Optional ones
                .map(Optional::get);

        // Attempt 3
        l.stream()
                .flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty());

        // Attempt 4
        l.stream()
                .flatMap(o -> o.stream().flatMap(Stream::of));

        // Attempt 5
        l.stream()
                .flatMap(o -> o.stream());

        // Final version
        l.stream()
                .flatMap(Optional::stream)
                .forEach(_99_Utils::print);
        // Method reference
    }

    /*
     - 2. To treat an Optional as a Stream
    */
    void switchAnOptionalToStream() {
        List<Integer> g = Optional.of(new Employee())
                .stream()
                .map(Employee::getAge)
                .flatMap(Optional::stream)
                .collect(toList());
    }












    /*
     - Questions:
         - 1. The Optional stream() method returns a Stream of the underlying value.
              True/False
         - 2. The Optional stream() method converts an Optional<String> to
              Optional<Stream>. True/False
         - 3. The Optional stream() method can be used if you want to treat an Optional
              as a Stream. True/False
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. The Optional stream() method returns a Stream of the underlying value.
              True
         - 2. The Optional stream() method converts an Optional<String> to
              Optional<Stream>. False it converts an Optional<String> to Stream<String>
              for example.
         - 3. The Optional stream() method can be used if you want to treat an Optional
              as a Stream. True. It converts an Optional to a Stream.
    */

}
