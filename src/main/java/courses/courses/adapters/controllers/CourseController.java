package courses.courses.adapters.controllers;

import courses.courses.application.ports.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseApplicationServicePort courseApplicationServicePort;

    private final CourseQueryServicePort courseQueryServicePort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto announce(@RequestBody AnnounceCommand announceCommand) {
        return courseApplicationServicePort.announce(announceCommand);
    }

    @GetMapping
    public List<CourseDto> findAll() {
        return courseQueryServicePort.findAll();
    }

    @PostMapping("/{courseCode}/enrollments")
    public void enroll(@PathVariable String courseCode, @RequestBody EnrollCommand enrollCommand) {
        if (!courseCode.equals(enrollCommand.courseCode())) {
            throw new IllegalArgumentException("Incorrect course codes: %s != %s"
                    .formatted(courseCode, enrollCommand.courseCode()));
        }
        courseApplicationServicePort.enroll(enrollCommand);
    }

    @GetMapping("/{courseCode}/enrollments")
    public List<EnrollmentDto> findEnrollmentByCourseCode(@PathVariable String courseCode) {
        return courseQueryServicePort.findEnrollmentByCourseCode(courseCode);
    }

}
