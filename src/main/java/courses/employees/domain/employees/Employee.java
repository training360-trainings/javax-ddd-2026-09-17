package courses.employees.domain.employees;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Employee {

    private Long id;

    private String name;

    public static Employee join(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name of the employee cannot be null");
        }
        return new Employee(null, name);
    }
}
