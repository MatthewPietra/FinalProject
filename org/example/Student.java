package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public boolean registerCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.getRegisteredStudents().add(this);
            return true;
        }
        return false;
    }

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
                ", name=" + studentName +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department.getDepartmentName() +
                ", registeredCourses=[" + registeredCoursesString +
                "]}";
    }
}