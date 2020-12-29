package com.lessons.optional;

import com.lessons.optional._99_Utils.Employee;

import java.util.Map;
import java.util.Optional;

/*
 - Remember the quote - “…a limited mechanism for library meth return types...”
 - As a return for any service/library method that may returned null
*/
public class _12_WhenToUse {

    public static void main(String[] args) {
    }

    EmployeeService service = new EmployeeService();

    void loadEmployee() {
        Optional<Employee> emp = service.getById("3"); // Empty optional
    }

    class EmployeeService {

        Map<String, Employee> repo = Map.of(
                "1", new Employee(),
                "2", new Employee());

        Optional<Employee> getById(String id) {
            if (repo.containsKey(id)) {
                return Optional.of(repo.get(id));
            }
            return Optional.empty();
        }

    }

}
