package edu.sjsu.assignment4;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputManager {
    public static String getCommand() {
        boolean endLoop = false;

        System.out.println("""
                "a" to add an appointment;
                "d" to delete an appointment;
                "v" to view all appointments;
                "q" to quit the program.""");

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Select an option: ");
            String tempInput = input.nextLine();
            if (!tempInput.isBlank()) {
                if (tempInput.length() != 1) {
                    badInput(tempInput);
                    continue;
                }

                switch (tempInput) {
                    case "a", "d", "v", "q" : return tempInput;
                    default: badInput(tempInput);
                }
            } else {
                System.out.println("Please enter a command.");
            }
        }

    }

    public static Appointment getAppointment() {
        String descPrompt = "Please enter a description: ",
                typePrompt = "Does this appointment occur \"monthly\", \"daily\", or \"once\"? ",
                oneTimePrompt = "Please enter the date (yyyy-mm-dd): ",
                startDatePrompt = "Please enter the starting date (yyyy-mm-dd): ",
                endDatePrompt = "Please enter the ending date (yyyy-mm-dd): ";

        String type = getAppointmentType(typePrompt);

        return switch (type) {
            case "monthly" -> new MonthlyAppointment(getDescription(descPrompt), getDate(startDatePrompt), getDate(endDatePrompt));
            case "daily" -> new DailyAppointment(getDescription(descPrompt), getDate(startDatePrompt), getDate(endDatePrompt));
            case "once" -> new OnetimeAppointment(getDescription(descPrompt), getDate(oneTimePrompt));
            default -> throw new RuntimeException("Input parsed incorrectly.");
        };
    }

    public static LocalDate getDate(String prompt) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print(prompt);
            String tempInput = input.nextLine();
            if (!tempInput.isBlank()) {
                if (tempInput.length() != 10) {
                    badDate(tempInput);
                    continue;
                }
                try {
                    return LocalDate.parse(tempInput);
                } catch(DateTimeParseException e) {
                    badDate(tempInput);
                }
            }
        }
    }

    public static String getDescription(String prompt) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print(prompt);
            String tempInput = input.nextLine();
            if (!tempInput.isBlank()) {
                return tempInput;
            }
        }
    }

    public static String getAppointmentType(String prompt) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print(prompt);
            String tempInput = input.nextLine();
            if (!tempInput.isBlank()) {
                switch(tempInput) {
                    case "daily", "monthly", "once": return tempInput;
                    default: badType(tempInput);
                }
            }
        }
    }

    public static void badInput(String word) {
        System.out.println(word + " is not a valid input.\n" +
                "Please enter \"a\", \"d\", \"v\", or \"q\".");
    }

    public static void badDate(String word) {
        System.out.println(word + " is not a valid date.\n" + "Date format is yyyy-mm-dd");
    }

    public static void badType(String word) {
        System.out.println(word + " is not a valid appointment type.\n" + "Types are \"monthly\", \"daily\", or \"once\".");
    }
}
