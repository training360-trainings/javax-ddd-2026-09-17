package courses.employees.adapters.repository;

import org.springframework.data.annotation.Id;

public record EmployeeEntity(@Id Long id, String name) {
}
