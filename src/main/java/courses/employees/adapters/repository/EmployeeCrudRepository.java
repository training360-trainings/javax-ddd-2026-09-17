package courses.employees.adapters.repository;

import courses.employees.application.ports.EmployeeDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface EmployeeCrudRepository extends ListCrudRepository<EmployeeEntity, Long> {

    @Query("select id, name from employee_entity")
    List<EmployeeDto> findAllEmployeeDto();
}
