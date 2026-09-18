package courses.courses.application.ports;

import java.util.List;

public interface CourseQueryServicePort {

    List<CourseDto> findAll();
}
