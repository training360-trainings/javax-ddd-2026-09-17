package courses;

import courses.courses.adapters.controllers.CourseController;
import courses.courses.application.ports.AnnounceCommand;
import courses.courses.application.ports.EnrollCommand;
import courses.employees.adapters.controllers.EmployeeController;
import courses.employees.application.ports.JoinCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(statements = {
        "delete from enrollment_entity",
        "delete from course_entity",
        "delete from employee_entity"
})
public class LeaveIT {

    @Autowired
    EmployeeController employeeController;

    @Autowired
    CourseController courseController;

    @Test
    void leave() {
        var employee = employeeController.join(new JoinCommand("John Doe"));
        courseController.announce(new AnnounceCommand("JAVAX-DDD", "Domain Driven Design", 5));
        courseController.enroll("JAVAX-DDD", new EnrollCommand(employee.id(), "JAVAX-DDD"));
        courseController.announce(new AnnounceCommand("JAVAX-BDD", "Behaviour Driven Development", 5));
        courseController.enroll("JAVAX-BDD", new EnrollCommand(employee.id(), "JAVAX-BDD"));

        assertThat(courseController.findEnrollmentByCourseCode("JAVAX-DDD"))
                .hasSize(1);

        employeeController.leave(employee.id());

        assertThat(courseController.findEnrollmentByCourseCode("JAVAX-DDD"))
                .hasSize(0);
    }
}
