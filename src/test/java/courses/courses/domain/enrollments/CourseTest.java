package courses.courses.domain.enrollments;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void announce() {
        var course = Course.announce(new CourseCode("JAVAX-DDD"), "Domain Driven Design", 5);
        assertEquals("JAVAX-DDD", course.getCode().value());
    }

    @Test
    void enroll() {
        var course = Course.announce(new CourseCode("JAVAX-DDD"), "Domain Driven Design", 5);
        course.enroll(new EmployeeId(6));
        assertThat(course.getEnrollments())
                .anyMatch(enrollment -> enrollment.employeeId().equals(new EmployeeId(6)));
    }

    @Test
    void enrollAgain() {
        var course = Course.announce(new CourseCode("JAVAX-DDD"), "Domain Driven Design", 5);
        course.enroll(new EmployeeId(6));
        course.enroll(new EmployeeId(6));
        assertThat(course.getEnrollments())
                .hasSize(1);
    }

    @Test
    void enrollLimitReached() {
        var course = Course.announce(new CourseCode("JAVAX-DDD"), "Domain Driven Design", 5);
        IntStream.range(0, 5)
                        .forEach(index -> course.enroll(new EmployeeId(index)));
        assertThrows(IllegalStateException.class, () -> course.enroll(new EmployeeId(6)));
    }

}