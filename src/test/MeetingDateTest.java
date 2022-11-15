import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class MeetingDateTest {
    LocalDate now = LocalDate.now();
    int thisDay = now.getDayOfMonth();
    int thisMonth = now.getMonthValue();
    int thisYear = now.getYear();
    MeetingDate date = new MeetingDate(thisDay, thisMonth, thisYear);
    MeetingDate futureDate = new MeetingDate(10, 8, thisYear+1);
    MeetingDate testDate;

    @Test
    @DisplayName("Test 1: Gets day")
    void getDay() {
        assertEquals(thisDay, date.getDay());
        assertEquals(10, futureDate.getDay());
    }

    @Test
    @DisplayName("Test 2: Gets month value")
    void getMonthValue() {
        assertEquals(thisMonth, date.getMonthValue());
        assertEquals(8, futureDate.getMonthValue());
    }

    @Test
    @DisplayName("Test 3: Gets month name")
    void getMonthName() {
        assertEquals("August", futureDate.getMonthName());
        MeetingDate temp = new MeetingDate(1, 1, thisYear+1);
        assertEquals("January", temp.getMonthName());
        temp = new MeetingDate(1, 12, thisYear+1);
        assertEquals("December", temp.getMonthName());
    }

    @Test
    @DisplayName("Test 4: Gets year")
    void getYear() {
        assertEquals(thisYear, date.getYear());
        assertEquals(thisYear+1, futureDate.getYear());
    }

    @Test
    @DisplayName("Test 5: Ensures correctDate doesn't change valid dates")
    void correctDate() {
        //Testing correct date with valid dates
        testDate = new MeetingDate(30, 11, thisYear+1);
        testDate.correctDate();
        assertEquals(new MeetingDate(30, 11, thisYear+1), testDate);
        testDate = new MeetingDate(28, 2, thisYear+1);
        testDate.correctDate();
        assertEquals(new MeetingDate(28, 2, thisYear+1), testDate);
        testDate = new MeetingDate(31, 7, thisYear+1);
        testDate.correctDate();
        assertEquals(new MeetingDate(31, 7, thisYear+1), testDate);
    }

    @Test
    @DisplayName("Test 6: Checks if correctDay works across the input space")
    void correctDay() {
        //Testing out-of-bounds day values
        testDate = new MeetingDate(0, 12, thisYear + 1);
        testDate.correctDay();
        assertEquals(1, testDate.getDay());
        testDate = new MeetingDate(32, 1, thisYear + 1);
        testDate.correctDay();
        assertEquals(31, testDate.getDay());
        testDate = new MeetingDate(31, 4, thisYear + 1);
        testDate.correctDay();
        assertEquals(30, testDate.getDay());
        testDate = new MeetingDate(29, 2, 3171);
        testDate.correctDay();
        assertEquals(28, testDate.getDay());
        //Testing leap year exceptional circumstance
        testDate = new MeetingDate(29, 2, thisYear + 4 - thisYear % 4);
        testDate.correctDay();
        assertEquals(29, testDate.getDay());
        testDate = new MeetingDate(30, 2, thisYear + 4 - thisYear % 4);
        testDate.correctDay();
        assertEquals(29, testDate.getDay());
        //Testing in bound values
        testDate = new MeetingDate(1, 12, thisYear + 1);
        testDate.correctDay();
        assertEquals(1, testDate.getDay());
        testDate = new MeetingDate(30, 4, thisYear + 1);
        testDate.correctDay();
        assertEquals(30, testDate.getDay());
        testDate = new MeetingDate(31, 5, thisYear + 1);
        testDate.correctDay();
        assertEquals(31, testDate.getDay());
        testDate = new MeetingDate(28, 2, thisYear + 1);
        testDate.correctDay();
        assertEquals(28, testDate.getDay());
    }

    @Test
    @DisplayName("Test 7: Checks if correctMonth works across the input space")
    void correctMonth() {
        //Testing out-of-bounds month values
        testDate = new MeetingDate(10, 0, thisYear + 1);
        testDate.correctMonth();
        assertEquals(1, testDate.getMonthValue());
        testDate = new MeetingDate(31, 13, thisYear);
        testDate.correctMonth();
        assertEquals(12, testDate.getMonthValue());
        //Testing in bound month values
        testDate = new MeetingDate(1, 1, thisYear + 1);
        testDate.correctMonth();
        assertEquals(1, testDate.getMonthValue());
        testDate = new MeetingDate(1, 12, thisYear + 1);
        testDate.correctMonth();
        assertEquals(12, testDate.getMonthValue());
    }

    @Test
    @DisplayName("Test 8: Checks if isPast returns correct values for past and future dates")
    void isPast() {
        //Testing if isPast returns correct value
        testDate = new MeetingDate(31, 12, 2021);
        assertTrue(testDate.isPast());
        testDate = new MeetingDate(31, 10, 2022);
        assertTrue(testDate.isPast());
        testDate = new MeetingDate(1, 11, 2022);
        assertTrue(testDate.isPast());
        testDate = new MeetingDate(31, 12, thisYear);
        assertFalse(testDate.isPast());
        testDate = new MeetingDate(1, 1, thisYear+1);
        assertFalse(testDate.isPast());
        testDate = new MeetingDate(31, 1, thisYear+1);
        assertFalse(testDate.isPast());
    }

    @Test
    @DisplayName("Test 9: Checks if correctDate makes past dates today")
    void correctDatePastDates() {
        //Testing if past dates return current date
        testDate = new MeetingDate(25, 1, 2022);
        testDate.correctDate();
        assertEquals(date, testDate);
        testDate = new MeetingDate(30, 4, 2020);
        testDate.correctDate();
        assertEquals(date, testDate);
        testDate = new MeetingDate(27, 8, 999);
        testDate.correctDate();
        assertEquals(date, testDate);
    }

    @Test
    @DisplayName("Test 10: Checks if toString formats correctly")
    void toStringTest() {
        //Testing to see if toString formats correctly
        testDate = new MeetingDate(1, 9, thisYear+1);
        assertEquals(String.format("01/09/" + (thisYear+1)), testDate.toString());
        testDate = new MeetingDate(26, 12, thisYear+1);
        assertEquals(String.format("26/12/" + (thisYear+1)), testDate.toString());
    }
}