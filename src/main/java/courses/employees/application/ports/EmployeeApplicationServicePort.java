package courses.employees.application.ports;

public interface EmployeeApplicationServicePort {

    EmployeeDto join(JoinCommand command);

    void leave(LeaveCommand leaveCommand);
}
