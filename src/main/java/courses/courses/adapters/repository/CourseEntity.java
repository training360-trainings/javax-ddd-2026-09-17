package courses.courses.adapters.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public record CourseEntity(@Id Long id, String code, String title, @Column("enroll_limit") int limit) {
}
