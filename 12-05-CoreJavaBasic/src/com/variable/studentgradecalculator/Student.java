package com.variable.studentgradecalculator;

public class Student {

    private int studentRollNumber;
    private String studentName;
    private int studentMarks;

    public Student(int studentRollNumber, String studentName, int studentMarks) {
        this.studentRollNumber = studentRollNumber;
        this.studentName = studentName;
        this.studentMarks = studentMarks;
    }

    public int getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(int studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(int studentMarks) {
        this.studentMarks = studentMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentRollNumber=" + studentRollNumber +
                ", studentName='" + studentName + '\'' +
                ", studentMarks=" + studentMarks +
                '}';
    }
}
