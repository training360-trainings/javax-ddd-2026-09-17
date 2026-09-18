package courses.courses.application;

import courses.courses.application.ports.CourseDto;
import courses.courses.application.ports.CourseQueryServicePort;
import courses.courses.application.ports.CourseRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseQueryService implements CourseQueryServicePort {

    private final CourseRepositoryPort courseRepositoryPort;

    @Override
    public List<CourseDto> findAll() {
        return courseRepositoryPort.findAll();
    }
}
