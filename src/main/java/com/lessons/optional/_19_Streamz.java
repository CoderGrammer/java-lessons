package com.lessons.optional;

import com.lessons.optional._99_Utils.Employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.lessons.optional._99_Utils.print;
import static java.util.stream.Collectors.toList;

/*
 - stream
     - This method allows you to treat an optional as a stream benefitting from all the stream methods
     - This method is often useful with another stream say from a collection of Cars for example
     - Usually used with that other streams flatMap method
     - Where you have an Optional element that may be empty
     - It returns a stream with the value or an empty stream
     - Replaces a scenario where you have an existing stream with:
         - <stream>.filter(Optional::isPresent).map(Optional::get)
     - or
         - <stream>.flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
     - Can be replaced with:
         - <stream>.flatMap(Optional::stream)
     - This returns a stream of 0 or 1 elements
*/
public class _19_Streamz {

    public static void main(String[] args) {
        // Scenario
        List<Employee> emps = List.of(new Employee(),
                                      new Employee());
        // Map to an optional element and collect
        var a = emps
                .stream()
                .map(Employee::getAge)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList());

        // Map to an optional element and collect
        var b = emps
                .stream()
                // Ugly!
                .flatMap(g -> g.getAge().isPresent() ? Stream.of(g.getAge()) : Stream.of())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList());

        // Map to an optional element and collect
        var c = emps
                .stream()
                .map(Employee::getAge)
                // Much better
                .flatMap(Optional::stream)
                .collect(toList());

        // You can also use stream() if you fancy using any of the methods available there
        List<Integer> g = Optional.of(new Employee())
                .stream()
                .map(Employee::getAge)
                .flatMap(Optional::stream)
                .collect(toList());

        print(c);
    }

}
