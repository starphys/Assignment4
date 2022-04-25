package edu.sjsu.assignment4;

import java.util.TreeSet;

public class AppointmentManager extends TreeSet<Appointment> {
    public boolean addAppointment(Appointment appointment) {
        try {
            return this.add(appointment);
        } catch(Exception e) {
            return false;
        }
    }

    public boolean delete(Appointment appointment) {
        try {
            return this.remove(appointment);
        } catch(Exception e) {
            return false;
        }
    }

    public void printToSout() {
        if(this.isEmpty()) {
            System.out.println("No appointments.");
            return;
        }

        for (Appointment appointment : this) {
            System.out.println(appointment);
        }
    }
}
