package org.classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private List<Double> finalScores;
    private static int nextId = 1;

    public Course(String courseId, String courseName, double credits, Department department) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    /**
     * Checks if the sum of weights of all assignments of the course equals 1 (100%).
     *
     * @return true if the sum of weights of all assignments equals 1, false otherwise
     */
    public boolean isAssignmentWeightValid() {
        double totalWeight = 0;
        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }
        return Math.abs(totalWeight - 1) < 0.0001;
    }

    /**
     * Registers a student for the course.
     *
     * @param student the student to be registered for the course
     * @return true since the student is successfully registered for the course
     */
    public boolean registerStudent(Student student) {
        registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.setScores(null);
        }
        finalScores.add(null);
        return true;
    }

    /**
     * Calculates the weighted average score of each student in the course.
     *
     * @return an array containing the weighted average score of each student
     */
    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];
        for (int i = 0; i < registeredStudents.size(); i++) {
            double sum = 0;
            for (int score : assignments.get(i).getScores()) {
                sum += score;
            }
            averages[i] = (int) (sum / assignments.size());
        }
        return averages;
    }

    /**
     * Adds a new assignment to the course with a specified name, weight, and maximum score
     *
     * @param assignmentName the name of the new assignment
     * @param weight         the weight of the new assignment
     * @param maxScore       the maximum score of the new assignment
     * @return true if the new assignment was successfully added and the assignment weights are valid, false otherwise
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight, maxScore);
        assignments.add(assignment);
        return isAssignmentWeightValid();
    }

    /**
     * Generates scores for each assignment and calculates the final score for each student.
     * Calculates the final score for each student based on the scores obtained in each assignment.
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore(1);
            assignment.calcAssignmentAvg();
        }
        for (Student student : registeredStudents) {
            double totalScore = 0;
            for (Assignment assignment : assignments) {
                int score = assignment.getScores().get(registeredStudents.indexOf(student));
                totalScore += score;
            }
            finalScores.add(totalScore / assignments.size());
        }
    }

    /**
     * This method prints a table showing the scores of all students enrolled in the course
     * It also calculates and displays the average score for each assignment.
     */
    public void displayScores() {
        System.out.println("Course: " + courseName + "(" + courseId + ")");
        System.out.print("           ");
        for (Assignment assignment : assignments) {
            System.out.print(assignment.getAssignmentName() + "   ");
        }
        System.out.println("Final Score");
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.print(student.getStudentName() + "   ");
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                System.out.print((score == null ? "N/A" : score) + "   ");
            }
            System.out.println(finalScores.get(i));
        }

        System.out.print("Average   ");
        for (Assignment assignment : assignments) {
            assignment.calcAssignmentAvg();
            System.out.print(assignment.getAssignmentAverage() + "   ");
        }
        System.out.println();
    }

    public String toSimplifiedString() {
        return "Course ID: " + courseId +
                ", Name: " + courseName +
                ", Credits: " + credits +
                ", Department: " + department.getDepartmentName();
    }

    @Override
    public String toString() {
        String str = "CourseId: " + courseId + "\n" +
                "CourseName: " + courseName + "\n" +
                "Credits: " + credits + "\n" +
                "Department: " + department.getDepartmentName() + "\n" +
                "Assignments: \n";
        for (Assignment assignment : assignments) {
            str += "    " + assignment.toString() + "\n";
        }
        str += "Registered Students: \n";
        for (Student student : registeredStudents) {
            str += "    " + student.toSimplifiedString() + "\n";
        }
        return str;
    }
}