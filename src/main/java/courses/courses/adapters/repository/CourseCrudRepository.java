package courses.courses.adapters.repository;

import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface CourseCrudRepository extends ListCrudRepository<CourseEntity, Long> {

    boolean existsByCode(String value);

    Optional<CourseEntity> findByCode(String value);
}
