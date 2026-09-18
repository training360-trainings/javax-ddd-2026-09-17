package courses.courses.adapters.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface CourseCrudRepository extends ListCrudRepository<CourseEntity, String> {

}
