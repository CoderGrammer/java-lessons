package com.lessons.optional;

import com.lessons.optional._99_Utils.Employee;
import com.lessons.optional._99_Utils.Skill;

import java.util.Optional;
import java.util.function.Function;

import static com.lessons.optional._99_Utils.print;

public class _21_FlatMap {

    Optional<Employee> e = Optional.of(new Employee());

    public static void main(String[] args) {
        new _21_FlatMap();
    }

    void map() {
        // Whoops!
        Optional<Optional<Integer>> i = e.map(Employee::getAge);
        print(i);
    }

    void flatMap() {
        // Better
        // Function<T, Optional<U>> mapper
        Optional<Integer> i = e.flatMap(Employee::getAge);
        print(i);
    }

    void nestedFlatMap() {
        // Multi level nesting...
        Optional<Integer> i = e.flatMap(l -> l.getSkill().flatMap(Skill::getYears));
        print(i);
    }

    /*
     - flatMap
         - Similar to map, but its signature mandates a function which maps to an Optional
         - It flattens the result to prevent the nested wrapping in Optionals
         - So if your mapping function returns an Optional use this method
         - Remember flatMap() always returns an Optional
     - map vs flatMap
         - See diagram
         - Generally
             - flatMap is useful when the mapping operation results in an item double
               nested in the containing type e.g. Stream of Streams or Optional of
               Optional
             - flatMap removes one dimension
         - Specifically to Optional
             - Both map and flatMap return an Optional after applying some function
             - However in map you pass in a function which maps to x
             - If x itself happens to be an Optional then you will end up with a double
               wrapped Optional - e.g. Optional<Optional<String>>
             - In this scenario you could instead call flatMap
             - flatMaps signature mandates that the function passed in will return an
               Optional
             - This is the Optional that will get flattened
             - This will map and then flatten the result
             - So it is only wrapped in one Optional
    */

}

// Scroll down for questions....










    /*
     - Questions:
         - 1. Which method, map() or flatMap() returns an Optional?
         - 2. If you have a function that returns a String which method would you use
              to perform the mapping? flatMap() or map()
         - 3. Can you change the type of the Optional returned?
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. Which method, map() or flatMap() returns an Optional?
             - Both
         - 2. If you have a function that returns a String which method would you use
              to perform the mapping? flatMap() or map()
             - map. flatMap is only for mappings that return an Optional
         - 3. Can you change the type of the Optional returned?
             - Yes of course just like you can with map
    */