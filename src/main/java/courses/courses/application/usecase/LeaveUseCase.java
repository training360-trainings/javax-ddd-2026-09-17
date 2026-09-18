package courses.courses.application.usecase;

import courses.courses.adapters.repository.CourseRepository;
import courses.courses.application.ports.LeaveCommand;
import courses.courses.domain.enrollments.EmployeeId;
import courses.infra.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class LeaveUseCase {

    private final CourseRepository courseRepository;

    public void leave(LeaveCommand leaveCommand) {
        var courses = courseRepository.findEnrollmentExist(leaveCommand.employeeId());
        for (var course: courses) {
            course.leave(new EmployeeId(leaveCommand.employeeId()));
            courseRepository.save(course);
        }
    }
}
