import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {
    Building csis = new Building(8,3);

    ArrayList<Room> available = csis.getAllRooms();



    @Test
    @Description("Find out how many rooms in the building are available at a certain time")
    public void getAvailableRoomAtTime(){
        MeetingDate day = new MeetingDate("2022/12/12");
        MeetingTime from = new MeetingTime(2);
        MeetingTime to = new MeetingTime(4);
        Meeting m = new Meeting("doingprojectwork", day, from,to,csis.getRoomWithId(4));
        csis.getRoomWithId(4).addMeeting(m);
        ArrayList<Room> exclude4 = new ArrayList<>() ;
        for (Room r : csis.getAllRooms())
        {
            if(r != csis.getRoomWithId(4)){
                exclude4.add(r);
            }
        }
        assertEquals(exclude4 ,  csis.getAvailableRoomAtTime(new MeetingDate("2022/12/12"),new MeetingTime( 2),new MeetingTime(4)));
    }

    @Test
    @Description("Testing if i can get a room from its ID")
    public void getRoomWithId(){
        Room r = new Room(50, 50);
        csis.addRoom(r);
        assertEquals(r ,csis.getRoomWithId(50));
    }

    @Test
    @Description("Testing if getRoomWithId returns null if a room isn't found")
    public void getRoomWithIdNullTest(){
        assertNull(csis.getRoomWithId(40));
    }
}