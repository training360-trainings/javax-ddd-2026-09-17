package courses.courses.adapters.repository;

import courses.courses.application.ports.CourseRepositoryPort;
import courses.courses.domain.enrollments.Course;
import courses.courses.domain.enrollments.CourseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CourseRepository implements CourseRepositoryPort {

    private final CourseCrudRepository courseCrudRepository;

    @Override
    public Course save(Course course) {
        courseCrudRepository.save(new CourseEntity(null, course.getCode().value(), course.getTitle(), course.getLimit()));
        return course;
    }

    @Override
    public boolean existsWithCode(CourseCode code) {
        return courseCrudRepository.existsByCode(code.value());
    }

    @Override
    public Optional<Course> findByCode(CourseCode code) {
        return courseCrudRepository.findByCode(code.value()).map(
                entity -> new Course(new CourseCode(entity.code()), entity.title(), entity.limit())
        );
    }
}
