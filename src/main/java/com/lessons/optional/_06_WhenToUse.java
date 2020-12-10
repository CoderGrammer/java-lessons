package com.lessons.optional;

import com.lessons.optional._99_Utils.Employee;

import java.util.Map;
import java.util.Optional;

/*
 - As a return for any method that would otherwise have returned null
 - (Maybe) As a return type for getters for fields that may be null
     - This may violate bean laws as the return type differs from the object type
*/
public class _06_WhenToUse {

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
