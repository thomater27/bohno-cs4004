import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class MeetingDateTest {
    LocalDate now = LocalDate.now();
    int thisDay = now.getDayOfMonth();
    int thisMonth = now.getMonthValue();
    int thisYear = now.getYear();
    MeetingDate date = new MeetingDate(thisDay, thisMonth, thisYear);
    MeetingDate futureDate = new MeetingDate(10, 8, thisYear+1);

    @Test
    void getDay() {
        assertEquals(thisDay, date.getDay());
        assertEquals(10, futureDate.getDay());
    }

    @Test
    void getMonthValue() {
        assertEquals(thisMonth, date.getMonthValue());
        assertEquals(8, futureDate.getMonthValue());
    }

    @Test
    void getMonthName() {
        assertEquals("August", futureDate.getMonthName());
        MeetingDate temp = new MeetingDate(1, 1, thisYear+1);
        assertEquals("January", temp.getMonthName());
        temp = new MeetingDate(1, 12, thisYear+1);
        assertEquals("December", temp.getMonthName());
    }

    @Test
    void getYear() {
        assertEquals(thisYear, date.getYear());
        assertEquals(thisYear+1, futureDate.getYear());
    }

    @Test
    void validateDate() { //Bayan: testing if validateDate returns whether a date is valid or not under a variety of conditions
        assertTrue(date.validateDate());
        assertTrue(futureDate.validateDate());
        MeetingDate invalidDate = new MeetingDate(0, 10, thisYear+1);
        assertFalse(invalidDate.validateDate());
        invalidDate = new MeetingDate(30, 2, thisYear+1);
        assertFalse(invalidDate.validateDate());
        invalidDate = new MeetingDate(32, 1, thisYear+1);
        assertFalse(invalidDate.validateDate());
        invalidDate = new MeetingDate(31, 0, thisYear+1);
        assertFalse(invalidDate.validateDate());
        invalidDate = new MeetingDate(30, 13, thisYear+1);
        assertFalse(invalidDate.validateDate());
        invalidDate = new MeetingDate(10, 10, 2000);
        assertFalse(invalidDate.validateDate());
        invalidDate = new MeetingDate(0, 0, 0);
        assertFalse(invalidDate.validateDate());
        invalidDate = new MeetingDate(12, 11, 2022);
        assertFalse(invalidDate.validateDate());
    }

    @Test
    void correctDate() {
        assertEquals(date, date.correctDate());
        assertEquals(futureDate, futureDate.correctDate());
        MeetingDate testDate = new MeetingDate(0, 12, thisYear+1);
        assertEquals(new MeetingDate(1, 12, thisYear+1), testDate.correctDate());
        testDate = new MeetingDate(32, 1, thisYear+1);
        assertEquals(new MeetingDate(31, 1, thisYear+1), testDate.correctDate());
        testDate = new MeetingDate(29, 2, 2071);
        assertEquals(new MeetingDate(28, 2, 2071), testDate.correctDate());
        testDate = new MeetingDate(29, 2, thisYear+4 - thisYear%4);
        assertEquals(testDate, testDate.correctDate());
        testDate = new MeetingDate(10, 0, thisYear+1);
        assertEquals(new MeetingDate(10, 1, thisYear+1), testDate.correctDate());
        testDate = new MeetingDate(31, 13, thisYear);
        assertEquals(new MeetingDate(31, 12, thisYear), testDate.correctDate());
        testDate = new MeetingDate(25, 1, 2022);
        assertEquals(date, testDate);
        testDate = new MeetingDate(30, 4, 2020);
        assertEquals(date, testDate);
    }
}