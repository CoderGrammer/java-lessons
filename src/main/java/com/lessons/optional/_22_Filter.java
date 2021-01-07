package com.lessons.optional;

/*
 - filter
     - Replaces a scenario where you check if something isPresent & matches a condition
     - if empty then returns empty
     - if present then applies predicate
         - if true returns present
         - if false returns empty
     - If the element is there and matches the predicate returns an Optional of the value
         - …otherwise empty Optional
     - Then you can decide to throw an exception or map etc
     - This method is not often used in an external stream pipeline like some of the
       others
 */
import com.lessons.optional._99_Utils.Employee;

import java.util.Optional;

public class _22_Filter {

    Optional<Employee> employee = Optional.of(new Employee());

    public static void main(String[] args) {
        new _22_Filter();
    }

    void employeeWith1YearOfServiceOld() {
        // Employee with more than 1 year of service or empty
        Optional<Employee> e = employee.isPresent() && employee
                .get()
                .getYrsOfService() > 1 ? employee : Optional.empty();
    }

    void employeeWith1YearOfServiceNew() {
        // Better
        Optional<Employee> e1 = employee.filter(f -> f.getYrsOfService() > 1);
    }

    void nestedElements() {

        // Imagine...
        Optional<Optional<Integer>> integer = employee.map(Employee::getAge);
        // Remember the nested Optional problem
        // Optional<Optional<Integer>>

        /*
          - Filter only unpacks the outer Optional element, not nested elements. If
            you map to an Optional element you will need to unpack it. So this won't work:
        */

        // Optional<Integer> age = employee
        //         .map(Employee::getAge)
        //         .filter(g -> g > 10); // We can't use > for an Optional

        /*
          - So how about:
        */

        // Optional<Optional<Integer>> age = employee
        //         .map(Employee::getAge)
        //         .filter(g -> g.get() > 10); // g is wrapped in an extra Optional
        //                                     // so you could unpack it unsafely
        //                                     // but that doesn't help with the return type.
        //                                     // Filter won't change the return type!

        // Optional<Integer> age = employee
        //         .flatMap(Employee::getAge)
        //         .filter(g -> g > 10);

        // Multiple filters:
        Optional<Integer> age2 = employee.flatMap(Employee::getAge)
                .filter(g -> g > 10)
                .filter(g -> g < 100)
                .filter(g -> g != 55);
    }

}













    /*
     - Questions:
         - 1. Can the filter method work with nested Optionals?
         - 2. Filter will throw an exception if the Optional is empty because you
              cannot test a null object. True/False
         - 3. The filter method unpacks the value from the Optional and returns it.
              True/False
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. Can the filter method work with nested Optionals?
              Yes but the return type will match whatever you have mapped to. Nested
              Optionals are likely a mistake and should probably be flatMapped
         - 2. Filter will throw an exception if the Optional is empty because you
              cannot test a null object. True/False
              False. It can like the other methods handle the empty scenario by
              propagating the empty Optional
         - 3. The filter method unpacks the value from the Optional and returns it.
              True/False
              False. It returns the Optional present with the value or Optional empty
              if it was empty anyway or it didn't match the predicate
    */