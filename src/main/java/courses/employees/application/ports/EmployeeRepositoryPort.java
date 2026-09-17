package courses.employees.application.ports;

import courses.employees.domain.employees.Employee;

public interface EmployeeRepositoryPort {

    Employee save(Employee employee);
}
