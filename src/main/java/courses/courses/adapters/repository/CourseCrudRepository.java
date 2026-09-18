package courses.courses.adapters.repository;

import courses.courses.application.ports.CourseDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface CourseCrudRepository extends ListCrudRepository<CourseEntity, Long> {

    boolean existsByCode(String value);

    Optional<CourseEntity> findByCode(String value);

    @Query("select code, title from course_entity")
    List<CourseDto> findAllDto();
}
