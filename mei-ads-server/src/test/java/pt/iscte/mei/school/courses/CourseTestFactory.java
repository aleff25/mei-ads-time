package pt.iscte.mei.school.courses;

import pt.iscte.mei.school.courses.model.Course;
import pt.iscte.mei.school.courses.model.Shift;

import static pt.iscte.mei.school.TestFactory.generateId;

public class CourseTestFactory {

    public static Course.CourseBuilder aCourseBuilder() {

        return Course.builder()
                .id(generateId())
                .name("A Course from ISCTE")
                .shift(Shift.PostWork)
                .capacity(50);
    }

    public static Course aCourse() {
        return aCourseBuilder().build();
    }
}
