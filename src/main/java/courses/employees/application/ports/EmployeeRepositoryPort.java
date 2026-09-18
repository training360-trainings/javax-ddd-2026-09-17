package courses.employees.application.ports;

import courses.employees.domain.employees.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepositoryPort {

    Employee save(Employee employee);

    List<EmployeeDto> findAll();

    boolean exists(long employeeId);

    void delete(long l);

    Optional<EmployeeDto> findById(long employeeId);
}
