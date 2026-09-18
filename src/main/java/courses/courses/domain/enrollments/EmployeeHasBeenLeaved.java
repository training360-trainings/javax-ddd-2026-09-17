package courses.courses.domain.enrollments;

public record EmployeeHasBeenLeaved(EmployeeId employeeId, CourseCode courseCode) implements DomainEntityEvent {
}
