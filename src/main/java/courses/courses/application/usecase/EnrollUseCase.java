package courses.courses.application.usecase;

import courses.courses.application.ports.CourseRepositoryPort;
import courses.courses.application.ports.EmployeeGatewayPort;
import courses.courses.application.ports.EnrollCommand;
import courses.courses.domain.enrollments.CourseCode;
import courses.courses.domain.enrollments.EmployeeId;
import courses.infra.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class EnrollUseCase {

    private final CourseRepositoryPort courseRepositoryPort;

    private final EmployeeGatewayPort employeeGatewayPort;

    public void enroll(EnrollCommand enrollCommand) {
        if (!employeeGatewayPort.exists(enrollCommand.employeeId())) {
            throw new IllegalArgumentException("Employee with id %d does not exist".formatted(enrollCommand.employeeId()));
        }

        var course = courseRepositoryPort.findByCode(new CourseCode(enrollCommand.courseCode()))
                .orElseThrow(() -> new IllegalArgumentException("Course not found with code %s".formatted(enrollCommand.courseCode())));
        course.enroll(new EmployeeId(enrollCommand.employeeId()));
        courseRepositoryPort.save(course);
    }
}
