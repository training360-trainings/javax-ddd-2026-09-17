package courses.employees.adapters.gateway;

import courses.employees.application.ports.EventGatewayPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventGateway implements EventGatewayPort {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void leave(long employeeId) {
        applicationEventPublisher.publishEvent(new EmployeeHasBeenLeavedEvent(employeeId));
    }
}
