package edu.sjsu.assignment4;

import java.time.LocalDate;

/**
 * DailyAppointment is an Appointment that occurs every day from the startDate to the endDate
 */
public class DailyAppointment extends Appointment{
    /**
     * DailyAppointment constructs an Appointment that occurs every day
     * @param description String containing description for new DailyAppointment
     * @param startDate LocalDate that contains date appointments begin
     * @param endDate LocalDate that contains date appointments end
     */
    public DailyAppointment(String description, LocalDate startDate, LocalDate endDate) {
        super(description, startDate, endDate);
    }

    /**
     * occursOn checks if this Appointment occurs on a given date
     * @param date LocalDate to compare against this Appointment
     * @return true if date occurs on or between startDate and endDate, otherwise false
     */
    @Override
    public boolean occursOn(LocalDate date) {
        //if equal to start, greater than start and less then end, or equal to start
        return onOrBetween(date);
    }

    @Override
    public String toString() {
        return super.toString() + ", daily";
    }
}
