import org.classes.Assignment;
import org.classes.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    public void testIsAssignmentWeightValid() {
        Assignment assignment = new Assignment();
        Course course = new Course();
        assignment.setWeight(.3);
        assignment.setWeight(.5);
        assignment.setWeight(.5);
        boolean expected = false;
        boolean result = course.isAssignmentWeightValid();
        Assertions.assertEquals(result, expected);
    }
    @Test
    public void testIsAssignmentWeightValid2() {
        Assignment assignment = new Assignment();
        Course course = new Course();

        boolean expected = false;
        boolean result = course.isAssignmentWeightValid();
        Assertions.assertEquals(result, expected);
    }
    @Test
    public void testIsAssignmentWeightValid3() {
        Assignment assignment = new Assignment();
        Course course = new Course();

        boolean expected = false;
        boolean result = course.isAssignmentWeightValid();
        Assertions.assertEquals(result, expected);
    }
    @Test
    public void testCalcStudentAvg() {
        Assignment assignment = new Assignment();
        Course course = new Course();

        boolean expected = false;
        boolean result = course.isAssignmentWeightValid();
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void testCalcStudentAvg2() {
        Assignment assignment = new Assignment();
        Course course = new Course();

        boolean expected = false;
        boolean result = course.isAssignmentWeightValid();
        Assertions.assertEquals(result, expected);
    }

}