package courses.courses.domain.enrollments;

import java.time.LocalDateTime;

public record Enrollment(EmployeeId employeeId, LocalDateTime enrollmentTime) {
}
