package edu.sjsu.assignment4;

import java.time.LocalDate;

/**
 * MonthlyAppointment is an Appointment that occurs once a month between startDate and endDate, on the same
 * day of the month as startDate.
 */
public class MonthlyAppointment extends Appointment{
    /**
     * MonthlyAppointment constructs an Appointment that occurs once a month
     * @param description String containing description for new MonthlyAppointment
     * @param startDate LocalDate that contains date appointments begin
     * @param endDate LocalDate that contains date appointments end
     */
    public MonthlyAppointment(String description, LocalDate startDate, LocalDate endDate) {
        super(description, startDate, endDate);
    }

    /**
     * occursOn checks if this Appointment occurs on a given date
     * @param date LocalDate to compare against this Appointment
     * @return true if date is on or between startDate and endDate AND is on the same day of the month as startDate,
     *         otherwise false.
     */
    @Override
    public boolean occursOn(LocalDate date) {
        return onOrBetween(date) && (date.getDayOfMonth() == getStartDate().getDayOfMonth());
    }

    @Override
    public String toString() {
        return super.toString() + ", monthly";
    }
}
