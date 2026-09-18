package courses.courses.domain.enrollments;

public record CourseHasBeenAnnounced(CourseCode code, String title, int limit)
    implements DomainEntityEvent {
}
