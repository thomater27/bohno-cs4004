import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MeetingTest {
    public MeetingTest(){
    }
    // Adam - Test 1
    @Test
    @DisplayName("Test 1 : Check if the room is free")
    public void checkRoomStatus() {
        ArrayList<String> equipment = new ArrayList<>();
        Room adamsRoom = new Room("001", false, 2);
        Room thomasRoom = new Room("002", true, 4);
        assertTrue(thomasRoom.checkIfRoomsFree());
    }

    //Adam - Test 2
    @Test
    @DisplayName("Test 2 : Check if a room has more than 10 seats")
    public void checkRoomSeatNumber(){
        ArrayList<String> equipment = new ArrayList<>();
        Room johnsRoom = new Room("003", true, 7);
        Room bayansRoom = new Room("004", false, 12);
        assertFalse(bayansRoom.checkIfRoomHasMoreThan10Seats());
    }

    //Adam - Test 3
    @Test
    @DisplayName("Test 3 : Check if a room contains basic requirements")
    public void checkRoomRequirements(){
        ArrayList<String> requirements = new ArrayList<>();
        Room bestRoom = new Room("005", false,15);
        assertEquals(Arrays.asList("Projector", "WhiteBoard", "WiFi", "Refreshments"), bestRoom.roomRequirements());
    }

    // Adam - Test 4 very much work in progress commented out code in room.java aswell, not finished yet
    @Test
    @DisplayName("Test 4: Check if the room is wheelchair accessible")
    public void checkWheelchairAccessibility(){
        Room wheelchairAccessibleRoom = new Room("006", true, 6);
    }
}