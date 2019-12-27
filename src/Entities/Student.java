package Entities;

import java.time.Year;

public class Student extends Person {
    private String studentID;
    private Department department;
    private Year year;
    private Dorm dorm;

    public Student(String studentID, Department department, Year year) {
        this.studentID = studentID;
        this.department = department;
        this.year = year;
    }
}
