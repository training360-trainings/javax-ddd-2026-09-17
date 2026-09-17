package courses.courses.domain.enrollments;

public record CourseCode(String value) {

    public CourseCode {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Course code must not be null or blank");
        }
    }
}
