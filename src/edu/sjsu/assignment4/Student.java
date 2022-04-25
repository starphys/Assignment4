package edu.sjsu.assignment4;

import java.util.Objects;

/**
 * Student models a student with a student ID and a name
 */
public class Student {
    private int id;
    private String name;

    /**
     * Constructs a new Student by ID only. Name is Unnamed
     * @param id integer containing the student ID
     */
    public Student(int id) {
        this.id = id;
        this.name = "Unnamed";
    }

    /**
     * Constructs a new Student by ID and name
     * @param id integer containing the student ID
     * @param name String containing student name
     */
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * getName returns the name of this Student
     * @return String containing student name
     */
    public String getName() {
        return name;
    }

    /**
     * setName updates the student name
     * @param name String containing new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getId returns the id of this Student
     * @return integer containing student id
     */
    public int getId() {
        return id;
    }

    /**
     * equals determines two Students are equal if their ids are equal
     * @param o Object to be resolved to a Student
     * @return true if o is a Student object with an identical id to this, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    /**
     * hashCode generates a hash based on Student id
     * @return integer containing hash value
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * toString creates a String representation of a Student
     * @return String with student id and name formatted correctly
     */
    @Override
    public String toString() {
        return id + "." + name;
    }
}
