package courses.courses.adapters;

import courses.courses.application.ports.EmployeeGatewayPort;
import courses.employees.application.ports.EmployeeQueryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeGateway implements EmployeeGatewayPort {

    private final EmployeeQueryServicePort employeeQueryServicePort;

    @Override
    public boolean exists(long employeeId) {
        return employeeQueryServicePort.exists(employeeId);
    }
}
