package courses.courses.application.ports;

public interface CourseApplicationServicePort {

    CourseDto announce(AnnounceCommand announceCommand);

    EnrollmentDto enroll(EnrollCommand enrollCommand);

    void leave(LeaveCommand leaveCommand);
}
