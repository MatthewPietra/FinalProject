package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = generateStudentId();
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    private String generateStudentId() {
        return "S" + String.format("%05d", nextId++);
    }

    /**
     * Registers a course for the student.
     * This method adds the specified course to the student's list of registered courses
     * @param course the course to be registered by the student
     * @return true if the course was successfully registered, false if the course was already registered
     */
    public boolean registerCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.getRegisteredStudents().add(this);
            return true;
        }
        return false;
    }

    /**
     * Drops a course for the student.
     * This method removes the specified course from the student's list of registered courses
     * @param course the course to be dropped by the student
     * @return true if the course was successfully dropped, false if the course was not registered
     */
    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.getRegisteredStudents().remove(this);
            return true;
        }
        return false;
    }

    public String toSimplifiedString() {
        return "Student ID: " + studentId + ", Name: " + studentName + ", Department: " + department.getDepartmentName();
    }

    @Override
    public final String toString() {
        String registeredCoursesString = "";
        if (!registeredCourses.isEmpty()) {
            for (Course course : registeredCourses) {
                registeredCoursesString += course.toString();
                registeredCoursesString += "\n";
            }
            registeredCoursesString = registeredCoursesString.substring(0, registeredCoursesString.length() - 1);
        } else {
            registeredCoursesString = "None";
        }

        return "Student{" +
                "studentId=" + studentId +
                ", name=" + Util.toTitleCase(studentName)  +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department.getDepartmentName() +
                ", registeredCourses=[" + registeredCoursesString +
                "]}";
    }
}