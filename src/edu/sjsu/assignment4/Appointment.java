package edu.sjsu.assignment4;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Appointment is an abstract class containing the basic properties of an appointment.
 * Subclasses must overload occursOn()
 */
public abstract class Appointment implements Comparable<Appointment> {
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * Appointment() is the default constructor to be called in subclasses
     * @param description String containing a description of the appointment
     * @param startDate LocalDate for when the appointment starts
     * @param endDate LocalDate for when the appointment ends
     */
    public Appointment(String description, LocalDate startDate, LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * getStartDate retrieves the startDate from the Appointment
     * @return LocalDate for when the appointment starts
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * setStartDate updates this Appointment's startDate with a new date
     * @param startDate LocalDate for the new date
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * getEndDate retrieves the endDate from the Appointment
     * @return LocalDate for when the appointment ends
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * setEndDate updates this Appointment's endDate with a new date
     * @param endDate LocalDate for the new date
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * getDescription retrieves the description of this Appointment
     * @return String with the Appointment's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * setDescription modifies the description of this Appointment
     * @param description String containing the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * occursOn is used to compare a LocalDate to an Appointment
     * Must be overloaded in subclass
     * @param date LocalDate to compare against this Appointment
     * @return true if the Appointment occurs on that date, otherwise false
     */
    public abstract boolean occursOn(LocalDate date);

    /**
     * onOrBetween determines if a date occurs on or between the startDate and endDate of this Appointment
     * @param date LocalDate to compare against this Appointment
     * @return true if date occurs on startDate, on endDate, or between startDate and endDate
     */
    public boolean onOrBetween(LocalDate date) {
        return (date.equals(getStartDate()) ||
                (date.isAfter(getStartDate()) && date.isBefore(getEndDate())) ||
                date.equals(getEndDate()));
    }

    /**
     * compareTo overrides compareTo from Comparable to order Appointments first by startDate, then by
     * endDate, then by description. If all three match, the Appointments are equal
     * @param appointment Appointment for the right hand side of the comparison
     * @return 0 if equal, positive if this should be before appointment, negative if this should be after appointment
     */
    @Override
    public int compareTo(Appointment appointment) {
        return this.getDescription().compareTo(appointment.getDescription());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment that)) return false;
        return getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }

    @Override
    public String toString() {
        return description +
                ", from " + startDate +
                " to " + endDate;
    }
}
