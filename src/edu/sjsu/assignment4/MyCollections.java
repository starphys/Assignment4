package edu.sjsu.assignment4;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
 * MyCollections groups several unrelated static methods. This is not best practice.
 */
public class MyCollections {

    /**
     * printFiles prints the contents of all files in the print queue to System out.
     * @param printQueue Queue<File> containing all the files to be printed
     */
    public static void printFiles(Queue<File> printQueue) {
        while(!printQueue.isEmpty()) {
            try (Scanner input = new Scanner(printQueue.remove())) {
                while (input.hasNextLine()) {
                    // scan the current line
                    String line = input.nextLine();

                    // Write each line to system.out
                    System.out.println(line);
                }
                //Break between files
                System.out.println("***");
            } catch (java.io.FileNotFoundException e) {
                System.out.println("File not found.");
            } catch (NoSuchElementException e) {
                System.out.println("Queue is empty");
            }
        }
    }

    /**
     * downsize removes every nth employee from a given list
     * @param employees LinkedList<String> of all employees to be considered
     * @param n integer representing which employees should be removed (every nth)
     */
    public static void downsize(LinkedList<String> employees, int n) {
        if (n == 0) { return; }
        ListIterator<String> iterator = employees.listIterator();
        int i = 1;

        while(iterator.hasNext()) {
            iterator.next();
            if((i % n) == 0) {
                iterator.remove();
            }
            i++;
        }
    }

    /**
     * isBalanced checks if a String is balanced for [] and ()
     * @param toCheck String to be checked
     * @return true if appropriately balanced, otherwise false
     */
    public static boolean isBalanced(String toCheck) {
        Stack<Character> storage = new Stack<>();
        for(Character next : toCheck.toCharArray()) {
            if(next.equals('(') || next.equals('[')) {
                storage.push(next);
            }
            else if(next.equals(')')) {
                if(storage.isEmpty() || !storage.peek().equals('(')) {
                    return false;
                }
                else {
                    storage.pop();
                }
            }
            else if(next.equals(']')) {
                if(storage.isEmpty() || !storage.peek().equals('[')) {
                    return false;
                }
                else {
                    storage.pop();
                }
            }
        }

        return storage.isEmpty();
    }
}
