package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students;
    private String name;
    private int age;

    public University(String name, int age) {
        students = new ArrayList<>();
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student desiredStudent = new Student("", 0, 0);
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                desiredStudent = student;
            }
        }
        return desiredStudent;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxAvgGrade = 0;
        for (Student student : students) {
            if (student.getAverageGrade() > maxAvgGrade) {
                maxAvgGrade = student.getAverageGrade();
            }
        }
        return getStudentWithAverageGrade(maxAvgGrade);
    }

    public Student getStudentWithMinAverageGrade() {
        double minAvgGrade = 10;
        for (Student student : students) {
            if (student.getAverageGrade() < minAvgGrade) {
                minAvgGrade = student.getAverageGrade();
            }
        }
        return getStudentWithAverageGrade(minAvgGrade);
    }

    public void expel(Student student) {
        students.remove(student);
    }
}