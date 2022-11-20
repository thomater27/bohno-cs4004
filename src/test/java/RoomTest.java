import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    Room r;

    @BeforeEach
    void setUp() {
        r = new Room(1, 30);
    }

    @Test
    @DisplayName("Ensures getCapacity returns capacity as int")
    void getCapacity() {
        assertEquals(30, r.getCapacity());
    }

    @Test
    @DisplayName("Ensures setCapacity works for all positive values")
    void setCapacity() {
        r.setCapacity(40); //value greater than or equal to 0
        assertEquals(40, r.getCapacity());
        r.setCapacity(-10); //value less than 0
        assertEquals(40, r.getCapacity());
        r.setCapacity(0);
        assertEquals(0, r.getCapacity());
    }

    @Test
    @DisplayName("Ensures that addResource adds resources in lowercase")
    void addResource() {
        r.addResource("Projector");
        r.addResource("WHITEBOARD");
        r.addResource("computer");
        assertNotNull(r.getResources());
        assertTrue(r.hasResource("projector"));
        assertTrue(r.hasResource("whiteboard"));
        assertTrue(r.hasResource("computer"));
    }

    @Test
    @DisplayName("Ensures that removeResource removes a resource ignoring case")
    void removeResource() {
        assertEquals(0, r.getResources().size());
        assertFalse(r.hasResource("projector"));
        r.addResource("projector");
        assertEquals(1, r.getResources().size());
        assertTrue(r.hasResource("projector"));
        r.removeResource("PROJECTOR");
        assertEquals(0, r.getResources().size());
        assertFalse(r.hasResource("projector"));
    }

    @Test
    @DisplayName("Ensures clearResources clears resources")
    void clearResources() {
        r.addResource("projector");
        assertNotEquals(0, r.getResources().size());
        r.clearResources();
        assertEquals(0, r.getResources().size());
    }

    @Test
    @DisplayName("Ensures hasResource works correctly")
    void hasResource() {
        r.addResource("Computer");
        assertTrue(r.hasResource("cOmPuTeR"));
        assertFalse(r.hasResource("pc"));
    }

    @Test
    @DisplayName("Ensures adding and removing meetings works")
    void addAndRemoveMeeting() {
        Meeting m = new Meeting(null, null, null, null, r);
        r.addMeeting(m);
        assertTrue(r.removeMeeting(m));
        assertFalse(r.removeMeeting(m));
    }

    @Test
    @DisplayName("Ensures that rooms store their availability correctly")
    void isAvailableAtTime() {
        MeetingDate testDate = new MeetingDate(1, 1, 3022);
        MeetingDate otherDate = new MeetingDate(2, 1, 3022);
        MeetingTime t1 = new MeetingTime(15);
        MeetingTime t2 = new MeetingTime(18);
        MeetingTime t3 = new MeetingTime(16);
        MeetingTime t4 = new MeetingTime(17);
        Meeting m1 = new Meeting(null, testDate, t1, t2, r);
        assertTrue(r.isAvailableAtTime(testDate, t1, t2));
        r.addMeeting(m1);
        assertFalse(r.isAvailableAtTime(testDate, t1, t2));
        assertFalse(r.isAvailableAtTime(testDate, t3, t4));
        assertTrue(r.isAvailableAtTime(otherDate, t1, t2));
        r.removeMeeting(m1);
        assertTrue(r.isAvailableAtTime(testDate, t1, t2));
        assertTrue(r.isAvailableAtTime(testDate, t3, t4));
    }

    @Test
    @DisplayName("Ensures toString formats correctly")
    void testToString() {
        assertEquals("Room 01", r.toString());
        Room r2 = new Room(10, 10);
        assertEquals("Room 10", r2.toString());
        Room r3 = new Room(99, 30);
        assertEquals("Room 99", r3.toString());
        Room r4 = new Room(123, 40);
        assertEquals("Room 123", r4.toString());
        Room r5 = new Room(001, 50);
        assertEquals("Room 01", r5.toString());
    }

    @Test
    @DisplayName("Tests if hasCapacity returns true if the room can accommodate the parameter")
    void hasCapacity() {
        assertTrue(r.hasCapacity(30));
        assertFalse(r.hasCapacity(31));
        assertTrue(r.hasCapacity(0));
        assertTrue(r.hasCapacity(-1));
    }

    @Test
    @DisplayName("Ensures getId returns id as int")
    void getId() {
        assertEquals(1, r.getId());
    }
}