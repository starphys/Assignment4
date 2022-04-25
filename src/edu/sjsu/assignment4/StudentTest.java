package edu.sjsu.assignment4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getName() {
        Student a = new Student(1,"Alpha");

        Assertions.assertEquals("Alpha", a.getName());
    }

    @Test
    void testToString() {
        Student a = new Student(1,"Alpha");

        Assertions.assertEquals("1.Alpha: ", a.toString());
    }
}