package courses.courses.application.usecase;

import courses.courses.application.ports.AnnounceCommand;
import courses.courses.application.ports.CourseDto;
import courses.courses.application.ports.CourseRepositoryPort;
import courses.courses.domain.enrollments.Course;
import courses.courses.domain.enrollments.CourseCode;
import courses.infra.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class AnnounceUseCase {

    private final CourseRepositoryPort courseRepositoryPort;

    public CourseDto announce(AnnounceCommand announceCommand) {
        var code = new CourseCode(announceCommand.code());
        if (courseRepositoryPort.existsWithCode(code)) {
            throw new IllegalArgumentException("Course with code %s already exists".formatted(code));
        }
        var course = Course.announce(code, announceCommand.title(), announceCommand.limit());
        course =  courseRepositoryPort.save(course);
        return new CourseDto(course.getCode().value(), course.getTitle());
    }

}
