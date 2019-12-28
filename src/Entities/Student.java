package Entities;

import java.io.*;
import java.time.Year;
import java.util.ArrayList;

public class Student extends Person {
    private String studentID;
    private Department department;
    private Year year;
    private Dorm dorm;

    public Student(String firstName, String lastName, int age, String gender, String studentID, Department department, Year year, Dorm dorm) {
        super(firstName, lastName, age, gender);
        this.studentID = studentID;
        this.department = department;
        this.year = year;
        this.dorm = dorm;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Dorm getDorm() {
        return dorm;
    }

    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }

    public static ArrayList<Student> loadAllFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File studentFile = new File("students.bin");
        ArrayList<Student> students= new ArrayList<>();
        FileInputStream inStudentFile = new FileInputStream(studentFile);
        ObjectInputStream inputStream = new ObjectInputStream(inStudentFile);
        try{
            while(true){
                students.add((Student)inputStream.readObject());
            }
        }catch(EOFException exc){}
        inputStream.close();
        inStudentFile.close();
        return students;
    }
    public static void saveAllToFile(ArrayList<Student> students) throws IOException {
        File file = new File("students.bin");
        if (file.exists() && file.isFile())
        {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream toStudentFile = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(toStudentFile);

        for(Student student : students){
            outputStream.writeObject(student);
        };
        outputStream.close();
        toStudentFile.close();
    }
}
