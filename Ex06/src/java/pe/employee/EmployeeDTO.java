package pe.employee;

import java.util.Date;

public class EmployeeDTO {
    //your code here
    private int id;
    private String FullName;
    private Date Dob;
    private double Salary;

    public EmployeeDTO(String FullName, Date Dob, double Salary) {
        this.FullName = FullName;
        this.Dob = Dob;
        this.Salary = Salary;
    }

    public EmployeeDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date Dob) {
        this.Dob = Dob;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }
    
    
}
