package courses.courses.domain.enrollments;

public record EmployeeHasBeenEnrolled(EmployeeId employeeId, CourseCode code)
    implements DomainEntityEvent
{
}
