package courses.courses.domain.enrollments;

public sealed interface DomainEntityEvent permits CourseHasBeenAnnounced, EmployeeHasBeenEnrolled {
}
