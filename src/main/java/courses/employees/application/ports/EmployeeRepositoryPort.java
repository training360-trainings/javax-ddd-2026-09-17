package courses.employees.application.ports;

import courses.employees.domain.employees.Employee;

import java.util.List;

public interface EmployeeRepositoryPort {

    Employee save(Employee employee);

    List<EmployeeDto> findAll();

    boolean exists(long employeeId);
}
