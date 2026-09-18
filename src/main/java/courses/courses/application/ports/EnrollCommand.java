package courses.courses.application.ports;

public record EnrollCommand(long employeeId, String courseCode) {
}
