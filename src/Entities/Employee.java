package Entities;

public class Employee extends Person {
    private double salary;
    private String employeeId;

    public Employee(String firstName, String lastName, int age, String gender, double salary, String employeeId) {
        super(firstName, lastName, age, gender);
        this.salary = salary;
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
