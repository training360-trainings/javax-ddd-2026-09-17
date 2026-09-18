package courses.courses.domain.enrollments;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.*;

@AllArgsConstructor
@Getter
public class Course {

    private final CourseCode code;

    private String title;

    private int limit;

    private Set<Enrollment> enrollments;

    private final List<DomainEntityEvent> events = new ArrayList<>();

    public static Course announce(CourseCode code, String title, int limit) {
        Objects.requireNonNull(code, "Course code must not be null");
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        var course = new Course(code, title, limit, new HashSet<>());
        course.events.add(new CourseHasBeenAnnounced(code, title, limit));
        return course;
    }

    public void enroll(EmployeeId employeeId) {
        Objects.requireNonNull(employeeId, "Employee Id cannot be null");
        if (enrollments.stream().anyMatch(enrollment -> enrollment.employeeId().equals(employeeId))) {
            return;
        }
        if (limit == enrollments.size()) {
            throw new IllegalStateException("There is no more enrollments in this course %s".formatted(code.value()));
        }
        var enrollment = new Enrollment(employeeId, LocalDateTime.now());
        enrollments.add(enrollment);
        events.add(new EmployeeHasBeenEnrolled(employeeId, code));
    }

    public void leave(EmployeeId id) {
        enrollments.removeIf(enrollment -> enrollment.employeeId().equals(id));
        events.add(new EmployeeHasBeenLeaved(id));
    }
}
