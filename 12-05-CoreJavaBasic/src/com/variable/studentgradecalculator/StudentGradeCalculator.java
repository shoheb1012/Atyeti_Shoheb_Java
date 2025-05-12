package com.variable.studentgradecalculator;

import java.util.*;
import java.util.stream.Collectors;

public class StudentGradeCalculator {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Student> students = storingStudents();
        double averageMarks = calculatingAverageMarks(students);
        System.out.println("averageMarks  " + averageMarks);

        highestAndLowestMarks(students);

    }

    public static ArrayList<Student> storingStudents() {
        ArrayList<Student> students = new ArrayList<>();
        System.out.println("Enter the Number of students");
        int numberOfStudent = sc.nextInt();
        for (int i = 0; i < numberOfStudent; i++) {
            System.out.println("Enter the Student " + (i + 1) + " id");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Student name");
            String name = sc.nextLine();


            System.out.println("Enter the student marks ");
            int marks = sc.nextInt();

            Student student = new Student(id, name, marks);

            students.add(student);
        }
        return students;
    }

    public static double calculatingAverageMarks(ArrayList<Student> students) {
        //     int averageMarks = 0;//local variable need to intilize befor use;
//        int marks = 0;
//        for (int i = 0; i < students.size(); i++) {
//            marks += students.get(i).getStudentMarks();
//        }
//        return marks / students.size();
        double average = students.stream().mapToDouble(x -> x.getStudentMarks()).average().getAsDouble();
        return average;
    }

    public static void highestAndLowestMarks(ArrayList<Student> students) {
        // Sort in descending order


        int highestMark = students.stream()
                .mapToInt(Student::getStudentMarks)
                .max()
                .orElseThrow(() -> new NoSuchElementException("No students available"));

        int lowestMark = students.stream()
                .mapToInt(Student::getStudentMarks)
                .min()
                .orElseThrow(() -> new NoSuchElementException("No students available"));


        List<String> toppers = students.stream()
                .filter(s -> s.getStudentMarks() == highestMark)
                .map(Student::getStudentName)
                .collect(Collectors.toList());


        List<String> bottomScorers = students.stream()
                .filter(s -> s.getStudentMarks() == lowestMark)
                .map(Student::getStudentName)
                .collect(Collectors.toList());


        System.out.println("Highest marks: " + highestMark);
        System.out.println("Toppers: " + toppers);

        System.out.println("Lowest marks: " + lowestMark);
        System.out.println("Bottom Scorers: " + bottomScorers);
    }


}
