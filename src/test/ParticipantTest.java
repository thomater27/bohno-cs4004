import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParticipantTest {
    Building csis = new Building(20,4);
    Participant pete = new Participant( "pete" ,"1223", true);
    @Test
    @Description("Making sure exceptionSet takes a meeting when pete.adds a meeting")
    void getExceptions() {
        MeetingDate day = new MeetingDate("2022/12/12");
        MeetingTime from = new MeetingTime(2);
        MeetingTime to = new MeetingTime(4);
        Meeting m = new Meeting("choresformammy", day, from,to,csis.getRoomWithId(4));
        pete.addMeeting(m);
        ArrayList<Meeting> mA=new ArrayList<>();
        mA.add(m);

        assertEquals(mA,pete.getExclusionSet());



    }

    @Test
    void getExclusionSet() {

    }

    @Test
    void getName() {
    }

    @Test
    void getPassword() {
    }
}