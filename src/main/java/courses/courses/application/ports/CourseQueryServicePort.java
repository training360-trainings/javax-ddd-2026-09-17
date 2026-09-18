package courses.courses.application.ports;

import java.util.List;

public interface CourseQueryServicePort {

    List<CourseDto> findAll();

    List<EnrollmentDto> findEnrollmentByCourseCode(String courseCode);
}
