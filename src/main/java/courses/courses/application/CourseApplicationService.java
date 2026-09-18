package courses.courses.application;

import courses.courses.application.ports.*;
import courses.courses.application.usecase.AnnounceUseCase;
import courses.courses.application.usecase.EnrollUseCase;
import courses.courses.domain.enrollments.Course;
import courses.courses.domain.enrollments.CourseCode;
import courses.courses.domain.enrollments.EmployeeId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseApplicationService implements CourseApplicationServicePort {

    private final AnnounceUseCase announceUseCase;

    private final EnrollUseCase enrollUseCase;

    @Override
    public CourseDto announce(AnnounceCommand announceCommand) {
        return announceUseCase.announce(announceCommand);
    }

    @Override
    public void enroll(EnrollCommand enrollCommand) {
        enrollUseCase.enroll(enrollCommand);
    }
}
