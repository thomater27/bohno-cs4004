import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MeetingTest {

    Room room = new Room(1, 30);
    MeetingTime t1 = new MeetingTime(16);
    MeetingTime t2 = new MeetingTime(17);
    MeetingDate date = new MeetingDate(1, 1, 3022);
    Meeting getterTester = new Meeting("TestMeeting", date, t1, t2, room);

    @ParameterizedTest
    @DisplayName("Tests a partial overlap between two meetings")
    @CsvSource({"13, 15, 12, 14", "10, 11, 9, 11", "18, 19, 18, 20", "7, 9, 8, 10"})
    void isDuringPartialOverlap(int start1, int end1, int start2, int end2) {
        MeetingTime from1 = new MeetingTime(start1);
        MeetingTime to1 = new MeetingTime(end1);
        MeetingTime from2 = new MeetingTime(start2);
        MeetingTime to2 = new MeetingTime(end2);
        Meeting m1 = new Meeting("test", date, from1, to1, room);
        Meeting m2 = new Meeting("test", date, from2, to2, room);

        assertTrue(m1.isDuring(m2));
        assertTrue(m2.isDuring(m1));
    }

    @ParameterizedTest
    @DisplayName("Tests a complete overlap between two meetings")
    @CsvSource({"1, 5, 2, 4", "14, 16, 14, 16", "20, 22, 20, 21", "8, 11, 9, 11"})
    void isDuringCompleteOverlap(int start1, int end1, int start2, int end2) {
        MeetingTime from1 = new MeetingTime(start1);
        MeetingTime to1 = new MeetingTime(end1);
        MeetingTime from2 = new MeetingTime(start2);
        MeetingTime to2 = new MeetingTime(end2);
        Meeting m1 = new Meeting("test", date, from1, to1, room);
        Meeting m2 = new Meeting("test", date, from2, to2, room);

        assertTrue(m1.isDuring(m2));
        assertTrue(m2.isDuring(m1));
    }

    @ParameterizedTest
    @DisplayName("Tests meetings that don't have overlapping times")
    @CsvSource({"1, 2, 3, 4", "1, 2, 2, 3", "10, 11, 9, 10", "1, 5, 10, 15"})
    void isDuringNoOverlap(int start1, int end1, int start2, int end2) {
        MeetingTime from1 = new MeetingTime(start1);
        MeetingTime to1 = new MeetingTime(end1);
        MeetingTime from2 = new MeetingTime(start2);
        MeetingTime to2 = new MeetingTime(end2);
        Meeting m1 = new Meeting("test", date, from1, to1, room);
        Meeting m2 = new Meeting("test", date, from2, to2, room);

        assertFalse(m1.isDuring(m2));
        assertFalse(m2.isDuring(m1));
    }

    @ParameterizedTest
    @DisplayName("Tests meetings with different days but times may overlap")
    @CsvSource({"1, 2, 3, 4", "1, 2, 2, 3", "1, 2, 1, 2", "1, 5, 2, 3", "2, 4, 3, 5"})
    void isDuringDifferentDays(int start1, int end1, int start2, int end2) {
        MeetingTime from1 = new MeetingTime(start1);
        MeetingTime to1 = new MeetingTime(end1);
        MeetingTime from2 = new MeetingTime(start2);
        MeetingTime to2 = new MeetingTime(end2);
        MeetingDate otherDate = new MeetingDate(2, 2, 3020);
        Meeting m1 = new Meeting("test", date, from1, to1, room);
        Meeting m2 = new Meeting("test", otherDate, from2, to2, room);

        assertFalse(m1.isDuring(m2));
        assertFalse(m2.isDuring(m1));
    }

    @Test
    @DisplayName("Ensures getDate returns the date as MeetingDate")
    void getDate() {
        assertEquals(date, getterTester.getDate());
    }

    @Test
    @DisplayName("Ensures getDescription returns the description as String")
    void getDescription() {
        assertEquals("TestMeeting", getterTester.getDescription());
    }

    @Test
    @DisplayName("Ensures getFrom returns the starting time as MeetingTime")
    void getFrom() {
        assertEquals(t1, getterTester.getFrom());
    }

    @Test
    @DisplayName("Ensures getTo returns the ending time as MeetingTime")
    void getTo() {
        assertEquals(t2, getterTester.getTo());
    }

    @Test
    @DisplayName("Ensures toString formats correctly")
    void testToString() {
        assertEquals("TestMeeting on 01/01/3022 from 16:00 until 17:00 in Room 01", getterTester.toString());
    }
}