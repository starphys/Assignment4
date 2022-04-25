package edu.sjsu.assignment4;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        String descPrompt = "Please enter a description: ";
        boolean userExit = false;
        LocalDate defaultDate = LocalDate.parse("2001-01-01");

        AppointmentManager mgr = new AppointmentManager();

        System.out.println("Welcome to the Appointment Manager!\nPlease follow indicated input exactly:");

        while (!userExit) {
            String command = InputManager.getCommand();

            switch (command) {
                case "v":
                    mgr.printToSout();
                    break;
                case "a":
                    if(mgr.addAppointment(InputManager.getAppointment())) {
                        System.out.println("Appointment added!");
                    } else {
                        System.out.println("Appointment already exists.");
                    }
                    break;
                case "d":
                    if(!mgr.delete(new OnetimeAppointment(InputManager.getDescription(descPrompt), defaultDate))){
                        System.out.println("Appointment not found. Please try again.");
                    } else {
                        System.out.println("Appointment deleted!");
                    }
                    break;
                case "q":
                    userExit = true;
                    continue;
                case "default":
                    System.out.println("Something went wrong");
                    break;
            }
        }

        System.out.println("Thank you for using this program. Goodbye!");
    }
}
