package courses.courses.application.ports;

import courses.courses.domain.enrollments.Course;
import courses.courses.domain.enrollments.CourseCode;

import java.util.List;
import java.util.Optional;

public interface CourseRepositoryPort {

    Course save(Course course);

    boolean existsWithCode(CourseCode code);

    Optional<Course> findByCode(CourseCode code);

    List<CourseDto> findAll();

    List<Course> findEnrollmentExist(long l);
}
