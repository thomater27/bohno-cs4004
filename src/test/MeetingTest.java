
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertTrue;


public class MeetingTest {
    public MeetingTest(){
    }
    @Test
    @DisplayName("Test 1 : Check if room is fee")
    public void checkRoomStatus() {
        ArrayList<Requirements> equipment = new ArrayList<>();
        Room adamsRoom = new Room("1", false, 2, equipment);
        Room thomasRoom = new Room("2", true, 4, equipment);
        assertTrue(thomasRoom.checkIfRoomsFree());

    }
}