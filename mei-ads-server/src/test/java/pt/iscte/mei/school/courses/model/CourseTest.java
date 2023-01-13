package pt.iscte.mei.school.courses.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pt.iscte.mei.school.courses.CourseTestFactory.aCourse;

@DisplayName("Course")
class CourseTest {

    @Test
    @DisplayName("Check if remaining capacity is correct for a new course")
    void capacityRemaining() {

        // when
        var course = aCourse();

        //then
        assertNotNull(course);
        assertEquals(50, course.capacityRemaining());
    }

    @Test
    @DisplayName("Check if remaining capacity is correct for a course that already have students")
    void capacityRemainingWithCapcaityUsed() {

        // when
        var course = aCourse();
        course.addNewStudentsToCourse(25);

        //then
        assertNotNull(course);
        assertEquals(25, course.capacityRemaining());
    }
}