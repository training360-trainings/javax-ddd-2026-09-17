package courses.courses.domain.enrollments;

import java.time.LocalDateTime;

public record EmployeeHasBeenEnrolled(EmployeeId employeeId, CourseCode code, LocalDateTime enrolledAt)
    implements DomainEntityEvent
{
}
