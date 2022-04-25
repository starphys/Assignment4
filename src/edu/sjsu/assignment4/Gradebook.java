package edu.sjsu.assignment4;

import java.util.*;

public class Gradebook extends HashMap<Student, Character> {

    public Gradebook() {super();}

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

    public boolean addStudent(Student student) {
        return addStudent(student, 'N');
    }

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

    public void printGrades(Comparator<Student> comparator) {
        TreeSet<Student> sortedKeys = new TreeSet<>(comparator);
        sortedKeys.addAll(this.keySet());
        for(Student key : sortedKeys) {
            System.out.println(key.toString() + this.get(key));
        }

    }

    private boolean validGrade(char grade) {
        return switch (grade) {
            case 'A', 'B', 'C', 'D', 'F' -> true;
            default -> false;
        };
    }
}
