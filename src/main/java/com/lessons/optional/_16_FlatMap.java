package com.lessons.optional;

import com.lessons.optional._99_Utils.Employee;

import java.util.Optional;

import static com.lessons.optional._99_Utils.print;

/*
 - flatMap
     - Similar to map, but its signature mandates an input which is wrapped in an Optional
     - It flattens the result to prevent the nested wrapping in Optionals
     - So if your mapping function returns an Optional use this method
     - Remember flatMap() always returns an Optional
 - map vs flatMap
     - Generally
         - flatMap is useful when the map operation results in an item double nested in the containing type e.g.
           Stream of Streams or Optional of Optional
     - Specifically to Optional
         - Both map and flatMap return an Optional after applying some function
         - However in map you pass in a function which maps to x
         - If x itself happens to be an Optional then you will end up with a double wrapped Optional
         - In this scenario you could instead call flatMap
         - flatMaps signature mandates that the function passed in will return an Optional
         - this is the Optional that will get flattened
         - This will map and then flatten the result
         - So it is only wrapped in one Optional
*/
public class _16_FlatMap {

    public static void main(String[] args) {
        // Scenario
        Optional<Employee> e = Optional.of(new Employee());
        // Whoops!
        Optional<Optional<Integer>> i = e.map(Employee::getAge);
        // Better
        Optional<Integer> k = e.flatMap(Employee::getAge);
        print(k);
    }


}
