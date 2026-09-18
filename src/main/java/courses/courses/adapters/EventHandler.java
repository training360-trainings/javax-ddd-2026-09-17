package courses.courses.adapters;

import courses.courses.application.ports.CourseApplicationServicePort;
import courses.courses.application.ports.LeaveCommand;
import courses.employees.adapters.gateway.EmployeeHasBeenLeavedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventHandler {

    private final CourseApplicationServicePort courseApplicationServicePort;

    @EventListener
    public void handleEmployeeHasBeenLeavedEvent(EmployeeHasBeenLeavedEvent event) {
        courseApplicationServicePort.leave(new LeaveCommand(event.employeeId()));
    }
}
