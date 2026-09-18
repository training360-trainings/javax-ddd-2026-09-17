package courses.employees.application;

import courses.employees.application.ports.*;
import courses.employees.domain.employees.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeApplicationService implements EmployeeApplicationServicePort {

    private final EmployeeRepositoryPort employeeRepositoryPort;

    private final EventGatewayPort eventGatewayPort;

    @Override
    public EmployeeDto join(JoinCommand command) {
        var employee = Employee.join(command.employeeName());
        employee = employeeRepositoryPort.save(employee);
        return new EmployeeDto(employee.getId(), employee.getName());
    }

    @Override
    public void leave(LeaveCommand leaveCommand) {
        employeeRepositoryPort.delete(leaveCommand.employeeId());
        eventGatewayPort.leave(leaveCommand.employeeId());
    }
}
