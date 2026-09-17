package courses.employees.adapters.controllers;

import courses.employees.application.ports.EmployeeApplicationServicePort;
import courses.employees.application.ports.EmployeeDto;
import courses.employees.application.ports.JoinCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeApplicationServicePort employeeApplicationServicePort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto join(@RequestBody JoinCommand command) {
        return employeeApplicationServicePort.join(command);
    }
}
