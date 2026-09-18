package courses.courses.adapters.repository;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


public record EnrollmentEntity(@Id Long id, long employeeId, long courseId, LocalDateTime enrolledAt) {
}
