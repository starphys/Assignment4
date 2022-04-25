package edu.sjsu.assignment4;

import java.time.LocalDate;

/**
 * OnetimeAppointment is an Appointment that has the same startDate and endDate
 */
public class OnetimeAppointment extends Appointment{

    /**
     *OnetimeAppointment constructs an Appointment that occurs only once
     * @param description String containing description for new OnetimeAppointment
     * @param date LocalDate that contains date of the appointment
     */
    public OnetimeAppointment(String description, LocalDate date) {
        super(description, date, date);
    }

    /**
     * occursOn checks if this Appointment occurs on a given date
     * @param date LocalDate to compare against this Appointment
     * @return true if the given date is equal to the startDate of this Appointment, otherwise false
     */
    @Override
    public boolean occursOn(LocalDate date) {
        return date.equals(getStartDate());
    }

    //May wish to only have one date for one time appointment
    @Override
    public String toString() {
        return super.toString() + ", one time";
    }
}
