package edu.sjsu.assignment4;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class MyCollections {

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
