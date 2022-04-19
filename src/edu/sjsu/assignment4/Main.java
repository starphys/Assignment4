package edu.sjsu.assignment4;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Queue<File> files = new LinkedList<>();
        files.add(new File("C:\\Users\\starp\\IdeaProjects\\Assignment4\\src\\edu\\sjsu\\assignment4\\hello.txt"));
        files.add(new File("C:\\Users\\starp\\IdeaProjects\\Assignment4\\src\\edu\\sjsu\\assignment4\\assignment4.txt"));

        MyCollections.printFiles(files);

    }
}
