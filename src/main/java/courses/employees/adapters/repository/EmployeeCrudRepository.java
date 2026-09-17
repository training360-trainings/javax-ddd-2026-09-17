package courses.employees.adapters.repository;

import org.springframework.data.repository.ListCrudRepository;

public interface EmployeeCrudRepository extends ListCrudRepository<EmployeeEntity, Long> {
}
