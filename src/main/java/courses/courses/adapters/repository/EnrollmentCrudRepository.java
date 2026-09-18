package courses.courses.adapters.repository;

import courses.courses.application.ports.EnrollmentDto;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface EnrollmentCrudRepository extends ListCrudRepository<EnrollmentEntity, Long> {
    List<EnrollmentEntity> findByCourseId(Long id);

    @Modifying
    @Query("delete from enrollment_entity where employee_id = :employeeId and enrollment_entity.course_id = (select id from course_entity where code = :courseCode)")
    void deleteByCourseCodeAndEmployeeId(Long employeeId, String courseCode);

    @Query("select code from course_entity c join enrollment_entity e on c.id = e.course_id where e.employee_id = :employeeId")
    List<String> findCodeByEmployeeId(Long employeeId);

    @Query("select employee_id from enrollment_entity e join course_entity c on e.course_id = c.id where c.code = :courseCode")
    List<EnrollmentDto> findAllByCourseCode(String courseCode);
}
