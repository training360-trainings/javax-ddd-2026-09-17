package courses.employees.application.ports;

import java.util.List;

public interface EmployeeQueryServicePort {

    List<EmployeeDto> findAll();
}
