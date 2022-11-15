
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;


public class MeetingTest {
    public MeetingTest(){
    }
    // Adam - Test 1
    @Test
    @DisplayName("Test 1 : Check if the room is free")
    public void checkRoomStatus() {
        ArrayList<Requirements> equipment = new ArrayList<>();
        Room adamsRoom = new Room("001", false, 2, equipment);
        Room thomasRoom = new Room("002", true, 4, equipment);
        assertTrue(thomasRoom.checkIfRoomsFree());
    }

    //Adam - Test 2
    @Test
    @DisplayName("Test 2 : Check if a room has more than 10 seats")
    public void checkRoomSeatNumber(){
        ArrayList<Requirements> equipment = new ArrayList<>();
        Room johnsRoom = new Room("003", true, 7, equipment);
        Room bayansRoom = new Room("004", false, 12, equipment);
        assertFalse(bayansRoom.checkIfRoomHasMoreThan10Seats());
    }
}