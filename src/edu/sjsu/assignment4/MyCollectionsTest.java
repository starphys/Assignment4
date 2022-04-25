package edu.sjsu.assignment4;

import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class MyCollectionsTest {
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


    @org.junit.jupiter.api.Test
    void printFiles() {
        Queue<File> files = new LinkedList<>();
        files.add(new File("C:\\Users\\starp\\IdeaProjects\\Assignment4\\src\\edu\\sjsu\\assignment4\\hello.txt"));
        files.add(new File("C:\\Users\\starp\\IdeaProjects\\Assignment4\\src\\edu\\sjsu\\assignment4\\assignment4.txt"));

        MyCollections.printFiles(files);

        Assertions.assertEquals("Hello, welcome to class!\r\n***\r\nAssignment 4 is posted.\r\nPlease submit it before due date.\r\n***", outputStreamCaptor.toString()
                .trim());
    }

    @org.junit.jupiter.api.Test
    void downsizeBasic() {
        LinkedList<String> employees = new LinkedList<>(Arrays.asList("Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"));
        LinkedList<String> expectedEmployees = new LinkedList<>(Arrays.asList("Tom", "Bob", "Alice", "Trudy", "Denny"));

        MyCollections.downsize(employees,3);

        Assertions.assertEquals(expectedEmployees,employees);
    }

    @org.junit.jupiter.api.Test
    void downsizeAll() {
        LinkedList<String> employees = new LinkedList<>(Arrays.asList("Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"));
        LinkedList<String> expectedEmployees = new LinkedList<>(List.of());

        MyCollections.downsize(employees,1);

        Assertions.assertEquals(expectedEmployees,employees);
    }

    @org.junit.jupiter.api.Test
    void downsizeNone() {
        LinkedList<String> employees = new LinkedList<>(Arrays.asList("Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"));
        LinkedList<String> expectedEmployees = new LinkedList<>(Arrays.asList("Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"));

        MyCollections.downsize(employees,8);

        Assertions.assertEquals(expectedEmployees,employees);
    }

    @org.junit.jupiter.api.Test
    void downsizeZero() {
        LinkedList<String> employees = new LinkedList<>(Arrays.asList("Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"));
        LinkedList<String> expectedEmployees = new LinkedList<>(Arrays.asList("Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"));

        MyCollections.downsize(employees,0);

        Assertions.assertEquals(expectedEmployees,employees);
    }

    @org.junit.jupiter.api.Test
    void isBalanced() {
        Assertions.assertTrue(MyCollections.isBalanced("System.out.println(list.get(0))"));
        Assertions.assertTrue(MyCollections.isBalanced("[](3*5)^2"));
        Assertions.assertFalse(MyCollections.isBalanced("[(2+3]*5)^2"));
        Assertions.assertFalse(MyCollections.isBalanced("System.out.println(list.get(0)"));
        Assertions.assertFalse(MyCollections.isBalanced("[(3*5)]^2]"));
    }
}