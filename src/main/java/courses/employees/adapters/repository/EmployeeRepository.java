package courses.employees.adapters.repository;

import courses.employees.application.ports.EmployeeDto;
import courses.employees.application.ports.EmployeeRepositoryPort;
import courses.employees.domain.employees.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class EmployeeRepository implements EmployeeRepositoryPort {

    private final EmployeeCrudRepository employeeCrudRepository;

    @Override
    public Employee save(Employee employee) {
        log.info("Saving employee {}", employee);
        var entity = new EmployeeEntity(null, employee.getName());
        entity = employeeCrudRepository.save(entity);
        return new Employee(entity.id(), entity.name());
    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeeCrudRepository.findAllEmployeeDto();
    }

    @Override
    public boolean exists(long employeeId) {
        return employeeCrudRepository.existsById(employeeId);
    }
}
