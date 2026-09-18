package courses.courses.adapters.repository;

import courses.courses.application.ports.CourseDto;
import courses.courses.application.ports.CourseRepositoryPort;
import courses.courses.application.ports.EnrollmentDto;
import courses.courses.domain.enrollments.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CourseRepository implements CourseRepositoryPort {

    private final CourseCrudRepository courseCrudRepository;

    private final EnrollmentCrudRepository enrollmentCrudRepository;

    @Override
    public Course save(Course course) {
        // Data Oriented Programming
        for (var event: course.getEvents()) {
            switch (event) {
                case CourseHasBeenAnnounced(var code, var title, var limit)
                        -> courseCrudRepository.save(new CourseEntity(null, code.value(), title, limit));
                case EmployeeHasBeenEnrolled(var employeeId, var code, var enrolledAt) -> {
                        var entity = courseCrudRepository.findByCode(code.value());
                        enrollmentCrudRepository.save(new EnrollmentEntity(null, employeeId.id(),
                                entity.orElseThrow().id(), enrolledAt));
                }
                case EmployeeHasBeenLeaved(var employeeId, var courseCode) -> {
                    enrollmentCrudRepository.deleteByCourseCodeAndEmployeeId(employeeId.id(), courseCode.value());
                }
            }
        }
        return course;
    }

    @Override
    public boolean existsWithCode(CourseCode code) {
        return courseCrudRepository.existsByCode(code.value());
    }

    @Override
    public Optional<Course> findByCode(CourseCode code) {
        var optional = courseCrudRepository.findByCode(code.value());
        if (optional.isPresent()) {
            var entity = optional.get();
            var enrollments = enrollmentCrudRepository.findByCourseId(entity.id())
                    .stream().map(enrollmentEntity ->
                            new Enrollment(new EmployeeId(enrollmentEntity.employeeId()), null))
                    .collect(Collectors.toSet());
            var course = new Course(new CourseCode(entity.code()), entity.title(), entity.limit(), enrollments);
            return Optional.of(course);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public List<CourseDto> findAll() {
        return courseCrudRepository.findAllDto();
    }

    @Override
    public List<Course> findEnrollmentExist(EmployeeId employeeId) {
        return enrollmentCrudRepository.findCodeByEmployeeId(employeeId.id())
                .stream()
                .flatMap(code -> findByCode(new CourseCode(code)).stream())
                .toList();
    }

    @Override
    public List<EnrollmentDto> findEnrollmentByCourseCode(String courseCode) {
        return enrollmentCrudRepository.findAllByCourseCode(courseCode);
    }
}
