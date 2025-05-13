package com.conditionalstatement.salaryslipgenerator;

public class Employee {
    private String employeeName;
    private double basicSalary;

    public Employee(String employeeName, double basicSalary) {
        this.employeeName = employeeName;
        this.basicSalary = basicSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }


    public  void salarySlipGenerator(double basicSalary) {
        double HRA = (basicSalary * 0.20);
        double DA = (basicSalary * 0.10);
        double PF = (basicSalary * 0.12);

        double grossSalary = basicSalary + HRA + DA + PF;

        System.out.println("Salary Slip for : "+this.employeeName);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("HRA: " + HRA);
        System.out.println("DA: " + DA);
        System.out.println("PF: " + PF);
        System.out.println("Gross Salary: " + grossSalary);
    }


}
