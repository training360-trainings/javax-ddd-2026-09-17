package courses.courses.application.ports;

public record AnnounceCommand(String code, String title, int limit) {
}
