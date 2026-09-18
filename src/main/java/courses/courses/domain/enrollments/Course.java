package courses.courses.domain.enrollments;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
public class Course {

    private final CourseCode code;

    private String title;

    private int limit;

    private final Set<Enrollment> enrollments = new HashSet<>();

    public static Course announce(CourseCode code, String title, int limit) {
        Objects.requireNonNull(code, "Course code must not be null");
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        return new Course(code, title, limit);
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
    }
}
