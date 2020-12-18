package com.lessons.optional;

/*
 - filter
     - Replaces a scenario where you check if something isPresent & matches a condition
     - if empty then returns empty
     - if present then applies predicate
         - if true returns present
         - if false returns empty
     - If the element is there and matches the predicate returns an Optional of the value
         - …otherwise empty optional
     - Then you can decide to throw an exception or map etc
     - This method is not often used in an external stream pipeline like some of the
       others
 */
import com.lessons.optional._99_Utils.Employee;

import java.util.Optional;

public class _19_Filter {

    public static void main(String[] args) {
        Optional<Employee> employee = Optional.of(new Employee());

        // Employee with more than 1 year of service or empty
        Optional<Employee> e = employee.isPresent() && employee
                .get()
                .getYrsOfService() > 1 ? employee : Optional.empty();

        // Better
        Optional<Employee> e1 = employee.filter(f -> f.getYrsOfService() > 1);

        /*
          - Filter only unpacks the outer Optional element, not nested elements. If
          - you map to an Optional element you will need to unpack it. So this won't work:
          - Optional<Integer> age = employee.map(Employee::getAge).filter(g -> g > 10);
          - ...because it's trying to operate on an Optional<Optional<Integer>
          - Instead you can do:
        */
        Optional<Integer> age = employee.flatMap(Employee::getAge).filter(g -> g > 10);
        // Multiple filters:
        Optional<Integer> age2 = employee.flatMap(Employee::getAge)
                .filter(g -> g > 10)
                .filter(g -> g < 100);
    }

}
