package model;

import java.util.Date;

public class Employee {
    private String name;
    private String email;
    private Date dateOfBirth;
    private double daysOfWork;
    private double salaryPerDay;

    public Employee(String name, String email, Date dateOfBirth, double daysOfWork, double salaryPerDay) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.daysOfWork = daysOfWork;
        this.salaryPerDay = salaryPerDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getDaysOfWork() {
        return daysOfWork;
    }

    public void setDaysOfWork(double daysOfWork) {
        this.daysOfWork = daysOfWork;
    }

    public double getSalaryPerDay() {
        return salaryPerDay;
    }

    public void setSalaryPerDay(double salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

}
