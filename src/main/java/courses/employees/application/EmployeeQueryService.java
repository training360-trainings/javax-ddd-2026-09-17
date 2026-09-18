package courses.employees.application;

import courses.employees.application.ports.EmployeeDto;
import courses.employees.application.ports.EmployeeQueryServicePort;
import courses.employees.application.ports.EmployeeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeQueryService implements EmployeeQueryServicePort {

    private final EmployeeRepositoryPort employeeRepositoryPort;

    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepositoryPort.findAll();
    }

    @Override
    public boolean exists(long employeeId) {
        return employeeRepositoryPort.exists(employeeId);
    }

    @Override
    public EmployeeDto findById(long employeeId) {
        return employeeRepositoryPort.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id %d does not exist".formatted(employeeId)));
    }
}
