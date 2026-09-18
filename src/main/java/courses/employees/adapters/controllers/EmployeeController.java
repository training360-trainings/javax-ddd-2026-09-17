package courses.employees.adapters.controllers;

import courses.employees.application.ports.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeApplicationServicePort employeeApplicationServicePort;

    private final EmployeeQueryServicePort employeeQueryServicePort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto join(@RequestBody JoinCommand command) {
        return employeeApplicationServicePort.join(command);
    }

    @GetMapping
    public List<EmployeeDto> findAll() {
        return employeeQueryServicePort.findAll();
    }

    @DeleteMapping("/{employeeId}")
    public void leave(@PathVariable long employeeId) {
        employeeApplicationServicePort.leave(new LeaveCommand(employeeId));
    }
}
