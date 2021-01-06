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
        // employee.map(Employee::getAge) // Remember the nested Optional problem
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

        // Optional<Integer> age = employee
        //         .map(Employee::getAge)
        //         .filter(g -> g.get() > 10); // g is wrapped in an extra Optional
        //                                     // so you could unpack it unsafely
        //                                     // but that doesn't help with the return type.
        //                                     // Filter won't change the return type!

        Optional<Integer> age = employee
                .flatMap(Employee::getAge)
                .filter(g -> g > 10);

        // Multiple filters:
        Optional<Integer> age2 = employee.flatMap(Employee::getAge)
                .filter(g -> g > 10)
                .filter(g -> g < 100);
    }

}
