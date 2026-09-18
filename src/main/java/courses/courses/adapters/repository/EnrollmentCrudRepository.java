package courses.courses.adapters.repository;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface EnrollmentCrudRepository extends ListCrudRepository<EnrollmentEntity, Long> {
    List<EnrollmentEntity> findByCourseId(Long id);
}
