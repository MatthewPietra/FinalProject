import org.classes.Assignment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssignmentTest {
    @Test
    public void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment();
        double expected = 0.0;
        assignment.calcAssignmentAvg();
        double result = assignment.getAssignmentAverage();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalcAssignmentAvg2() {
        Assignment assignment = new Assignment();
        assignment.addScore(80);
        assignment.addScore(70);
        assignment.addScore(90);
        double expected = 80.0;
        assignment.calcAssignmentAvg();
        double result = assignment.getAssignmentAverage();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalcAssignmentAvg3() {
        Assignment assignment = new Assignment();
        assignment.addScore(0);
        assignment.addScore(0);
        assignment.addScore(0);
        double expected = 0.0;
        assignment.calcAssignmentAvg();
        double result = assignment.getAssignmentAverage();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalcAssignmentAvg4() {
        Assignment assignment = new Assignment();
        assignment.addScore(90);
        double expected = 90.0;
        assignment.calcAssignmentAvg();
        double result = assignment.getAssignmentAverage();
        Assertions.assertEquals(expected, result);
    }
}


