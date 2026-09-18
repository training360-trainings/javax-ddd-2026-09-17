package courses.courses.adapters.controllers;

import courses.courses.application.ports.AnnounceCommand;
import courses.courses.application.ports.CourseApplicationServicePort;
import courses.courses.application.ports.CourseDto;
import courses.courses.application.ports.CourseQueryServicePort;
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
}
