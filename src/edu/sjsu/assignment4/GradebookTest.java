package edu.sjsu.assignment4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GradebookTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void addStudentWithGrade() {
        Gradebook grades = new Gradebook();
        Assertions.assertTrue(grades.addStudent(new Student(1), 'A'));
    }

    @Test
    void testAddStudentWithoutGrade() {
        Gradebook grades = new Gradebook();
        grades.addStudent(new Student(1));
    }

    @Test
    void deleteStudentTrue() {
        Gradebook grades = new Gradebook();
        grades.addStudent(new Student(1), 'A');
        Assertions.assertTrue(grades.deleteStudent(1));
    }

    @Test
    void deleteStudentFalse() {
        Gradebook grades = new Gradebook();
        Assertions.assertFalse(grades.deleteStudent(1));
    }


    @Test
    void updateStudentTrue() {
        Gradebook grades = new Gradebook();
        grades.addStudent(new Student(1, "Chris"), 'A');
        Assertions.assertTrue(grades.updateStudent(1,"Christ"));
        grades.printGrades(new idComparator());
        Assertions.assertEquals("1.Christ: A", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void updateStudentFalse() {
        Gradebook grades = new Gradebook();
        grades.addStudent(new Student(1, "Chris"), 'A');
        Assertions.assertFalse(grades.updateStudent(2,"Christ"));
        grades.printGrades(new idComparator());
        Assertions.assertEquals("1.Chris: A", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void updateGradeTrue() {
        Gradebook grades = new Gradebook();
        grades.addStudent(new Student(1, "Chris"), 'A');
        Assertions.assertTrue(grades.updateGrade(1,'B'));
        grades.printGrades(new idComparator());
        Assertions.assertEquals("1.Chris: B", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void updateGradeFalse() {
        Gradebook grades = new Gradebook();
        grades.addStudent(new Student(1, "Chris"), 'A');
        Assertions.assertFalse(grades.updateGrade(1,'N'));
        grades.printGrades(new idComparator());
        Assertions.assertEquals("1.Chris: A", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void printGrade() {
        Gradebook grades = new Gradebook();
        grades.addStudent(new Student(3, "George"), 'A');
        grades.addStudent(new Student(2, "Bruce"), 'B');
        grades.addStudent(new Student(1, "Hernando"));
        grades.printGrades(new idComparator());

        Assertions.assertEquals("1.Hernando: N\r\n2.Bruce: B\r\n3.George: A", outputStreamCaptor.toString()
                .trim());
    }
}