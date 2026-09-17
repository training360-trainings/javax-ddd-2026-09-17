package courses.employees.application;

import courses.employees.application.ports.EmployeeApplicationServicePort;
import courses.employees.application.ports.EmployeeDto;
import courses.employees.application.ports.EmployeeRepositoryPort;
import courses.employees.application.ports.JoinCommand;
import courses.employees.domain.employees.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeApplicationService implements EmployeeApplicationServicePort {

    private final EmployeeRepositoryPort employeeRepositoryPort;

    @Override
    public EmployeeDto join(JoinCommand command) {
        var employee = Employee.join(command.employeeName());
        employee = employeeRepositoryPort.save(employee);
        return new EmployeeDto(employee.getId(), employee.getName());
    }
}
