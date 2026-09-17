package courses.employees.adapters.repository;

import courses.employees.application.ports.EmployeeRepositoryPort;
import courses.employees.domain.employees.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class EmployeeRepository implements EmployeeRepositoryPort {

    @Override
    public Employee save(Employee employee) {
        log.info("Saving employee {}", employee);
        return new Employee(1L, employee.getName());
    }
}
