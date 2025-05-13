package com.conditionalstatement.salaryslipgenerator;

public class Main {
    public static void main(String[] args) {

        Employee employee = new Employee("Raaj",10000);

        employee.salarySlipGenerator(employee.getBasicSalary());
    }
}
