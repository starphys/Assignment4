package edu.sjsu.assignment4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentManagerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void addAppointmentTrue() {
        AppointmentManager mgr = new AppointmentManager();

        Appointment test = new DailyAppointment("Class", LocalDate.parse("2022-01-27"), LocalDate.parse("2022-05-18"));

        assertTrue(mgr.addAppointment(test));
    }

    @Test
    void addAppointmentFalse() {
        AppointmentManager mgr = new AppointmentManager();

        Appointment test = new DailyAppointment("Class", LocalDate.parse("2022-01-27"), LocalDate.parse("2022-05-18"));

        mgr.addAppointment(test);

        assertFalse(mgr.addAppointment(test));
    }

    @Test
    void deleteTrue() {
        AppointmentManager mgr = new AppointmentManager();

        Appointment test = new DailyAppointment("Class", LocalDate.parse("2022-01-27"), LocalDate.parse("2022-05-18"));

        mgr.addAppointment(test);

        assertTrue(mgr.delete(test));
    }

    @Test
    void deleteFalse() {
        AppointmentManager mgr = new AppointmentManager();

        Appointment test = new DailyAppointment("Class", LocalDate.parse("2022-01-27"), LocalDate.parse("2022-05-18"));
        Appointment test2 = new MonthlyAppointment("A meeting", LocalDate.parse("2022-01-27"),LocalDate.parse("2022-05-18") );

        mgr.addAppointment(test);

        assertFalse(mgr.delete(test2));
    }

    @Test
    void deleteFalseEmpty() {
        AppointmentManager mgr = new AppointmentManager();

        Appointment test = new DailyAppointment("Class", LocalDate.parse("2022-01-27"), LocalDate.parse("2022-05-18"));

        assertFalse(mgr.delete(test));
    }

    @Test
    void printToSout() {
        AppointmentManager mgr = new AppointmentManager();

        Appointment a1 = new OnetimeAppointment("Class starts", LocalDate.parse("2022-01-27"));
        Appointment a2 = new DailyAppointment("Class", LocalDate.parse("2022-01-27"),LocalDate.parse("2022-05-18") );
        Appointment a3 = new DailyAppointment("Assignments", LocalDate.parse("2022-02-16"),LocalDate.parse("2022-05-16") );
        Appointment a4 = new MonthlyAppointment("A meeting", LocalDate.parse("2022-01-27"),LocalDate.parse("2022-05-18") );

        mgr.addAppointment(a1);
        mgr.addAppointment(a2);
        mgr.addAppointment(a3);
        mgr.addAppointment(a4);

        mgr.printToSout();

        Assertions.assertEquals("""
                A meeting, from 2022-01-27 to 2022-05-18, monthly\r
                Assignments, from 2022-02-16 to 2022-05-16, daily\r
                Class, from 2022-01-27 to 2022-05-18, daily\r
                Class starts, from 2022-01-27 to 2022-01-27, one time""", outputStreamCaptor.toString()
                .trim());
    }
}