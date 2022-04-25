package edu.sjsu.assignment4;

import java.util.*;

/**
 * Gradebook maps students to their grades
 */
public class Gradebook extends HashMap<Student, Character> {

    /**
     * Gradebook constructs a new Gradebook
     */
    public Gradebook() {super();}

    /**
     * addStudent adds a student to the Gradebook with their grade
     * @param student Student containing the student with appropriate name and id
     * @param grade char representing the current letter grade of the student
     * @return true if successfully added, otherwise false
     */
    public boolean addStudent(Student student, char grade) {
        if(this.containsKey(student)) {
            return false;
        }

        if(!validGrade(grade)) {
            grade = 'N';
        }

        try {
            this.put(student, grade);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    /**
     * addStudent adds a student to the Gradebook with the default grade
     * @param student Student containing the student with appropriate name and id
     * @return true if successfully added, otherwise false
     */
    public boolean addStudent(Student student) {
        return addStudent(student, 'N');
    }

    /**
     * deleteStudent removes a student from the Gradebook.
     * @param id int containing student id of Student to remove
     * @return true if successfully removed, otherwise false
     */
    public boolean deleteStudent(int id) {
        if(!this.containsKey(new Student(id))) {
            return false;
        }

        try {
            this.remove(new Student(id));
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    /**
     * updateStudent updates the name of the student with the given id
     * @param id integer containing student id of Student to update
     * @param newName String containing new name for the Student
     * @return true if successfully updated, otherwise false
     */
    public boolean updateStudent(int id, String newName) {
        if (!this.containsKey(new Student(id))) {
            return false;
        }

        try{
            this.put(new Student(id, newName), this.remove(new Student(id)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * updateGrade updates the grade of the student with the given id
     * @param id integer containing student id of Student to update
     * @param newGrade String containing new grade for the Student
     * @return true if successfully updated, otherwise false
     */
    public boolean updateGrade(int id, char newGrade) {
        if (!this.containsKey(new Student(id)) || !validGrade(newGrade)) {
            return false;
        }

        try{
            this.replace(new Student(id), newGrade);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Prints the Students in the tree with their grades in order
     * @param comparator Comparator<Student> that supplies the sort order
     */
    public void printGrades(Comparator<Student> comparator) {
        TreeSet<Student> sortedKeys = new TreeSet<>(comparator);
        sortedKeys.addAll(this.keySet());

        for(Student key : sortedKeys) {
            System.out.println(key.toString()  + ": " + this.get(key));
        }

    }

    /**
     * validGrade determines if a char is a valid grade
     * @param grade char containing value to check
     * @return true if char is a valid letter grade, otherwise false
     */
    private boolean validGrade(char grade) {
        return switch (grade) {
            case 'A', 'B', 'C', 'D', 'F' -> true;
            default -> false;
        };
    }
}
