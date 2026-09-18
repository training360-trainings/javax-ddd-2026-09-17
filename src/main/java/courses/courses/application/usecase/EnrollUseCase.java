package courses.courses.application.usecase;

import courses.courses.application.ports.CourseRepositoryPort;
import courses.courses.application.ports.EnrollCommand;
import courses.courses.domain.enrollments.CourseCode;
import courses.courses.domain.enrollments.EmployeeId;
import courses.infra.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class EnrollUseCase {

    private final CourseRepositoryPort courseRepositoryPort;

    public void enroll(EnrollCommand enrollCommand) {
        var course = courseRepositoryPort.findByCode(new CourseCode(enrollCommand.courseCode()))
                .orElseThrow(() -> new IllegalArgumentException("Course not found with code %s".formatted(enrollCommand.courseCode())));
        course.enroll(new EmployeeId(enrollCommand.employeeId()));
        courseRepositoryPort.save(course);
    }
}
