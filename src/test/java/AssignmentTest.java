import org.classes.Assignment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssignmentTest {
    @Test
    public void testcalcAssignmentAvg1() {
        Assignment assignment = new Assignment();
        assignment.addScore(70);
        assignment.addScore(70);
        assignment.addScore(70);
        double expected = 70;
        assignment.calcAssignmentAvg();
        double result = assignment.getAssignmentAverage() ;

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testcalcAssignmentAvg2() {
        Assignment assignment = new Assignment();
        assignment.addScore(60);
        assignment.addScore(70);
        assignment.addScore(70);
        double expected = 66.66666666666667;
        assignment.calcAssignmentAvg();
        double result = assignment.getAssignmentAverage() ;

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testcalcAssignmentAvg3() {
        Assignment assignment = new Assignment();
        assignment.addScore(60);
        assignment.addScore(70);
        assignment.addScore(70);
        double expected = 66.66666666666667;
        assignment.calcAssignmentAvg();
        double result = assignment.getAssignmentAverage() ;

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testcalcAssignmentAvg4() {
        Assignment assignment = new Assignment();
        assignment.addScore(60);
        assignment.addScore(70);
        assignment.addScore(70);
        double expected = 66.66666666666667;
        assignment.calcAssignmentAvg();
        double result = assignment.getAssignmentAverage() ;

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testcalcAssignmentAvg5() {
        Assignment assignment = new Assignment();
        assignment.addScore(43);
        assignment.addScore(70);
        assignment.addScore(70);
        double expected = 66.66666666666667;
        assignment.calcAssignmentAvg();
        double result = assignment.getAssignmentAverage() ;

        Assertions.assertEquals(expected, result);
    }
}
