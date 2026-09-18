package courses.courses.adapters.repository;

import org.springframework.data.annotation.Id;

public record EnrollmentEntity(@Id Long id, long employeeId, long courseId) {
}
