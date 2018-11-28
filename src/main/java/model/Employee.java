package model;

import java.util.Date;

public class Employee {
    private String name;
    private String email;
    private Date dateOfBirth;
    private double daysOfWork;
    private double salaryPerDay;
    private Double totalSalary;

    public Employee(String name, String email, Date dateOfBirth, double daysOfWork, double salaryPerDay, Double totalSalary) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.daysOfWork = daysOfWork;
        this.salaryPerDay = salaryPerDay;
        this.totalSalary = totalSalary;
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

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }
}
