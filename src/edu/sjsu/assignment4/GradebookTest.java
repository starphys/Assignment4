package edu.sjsu.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradebookTest {

    @Test
    void addStudent() {
        Gradebook grades = new Gradebook();
        grades.addStudent(new Student(1), 'A');
    }

    @Test
    void testAddStudent() {
        Gradebook grades = new Gradebook();
        grades.addStudent(new Student(1));
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void updateStudent() {
    }

    @Test
    void updateGrade() {
    }

    @Test
    void printGrades() {
    }
}