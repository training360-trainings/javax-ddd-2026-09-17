package courses.courses.domain.enrollments;

public record CourseCode(String value) {

    public CourseCode {
        if (value == null || value.isBlank() || value.length() < 2) {
            throw new IllegalArgumentException("Course code must not be null or blank or less than 2 characters");
        }
    }
}
