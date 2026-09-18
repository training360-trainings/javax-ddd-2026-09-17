package courses.courses.application.ports;

import java.time.LocalDateTime;

public record EnrollmentDto(long employeeId, LocalDateTime enrolledAt) {
}
