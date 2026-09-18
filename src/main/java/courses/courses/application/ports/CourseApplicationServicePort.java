package courses.courses.application.ports;

import java.util.List;

public interface CourseApplicationServicePort {

    CourseDto announce(AnnounceCommand announceCommand);

    void enroll(EnrollCommand enrollCommand);
}
