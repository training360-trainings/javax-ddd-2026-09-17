package courses.employees.domain.employees;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Employee {

    private Long id;

    private String name;

    public static Employee join(String name) {
        Objects.requireNonNull(name, "Employee name cannot be null");
        return new Employee(null, name);
    }
}
