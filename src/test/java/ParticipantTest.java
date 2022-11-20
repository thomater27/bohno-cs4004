import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {
    Building csis = new Building(20,4);
    Participant pete = new Participant( "pete" ,"1223", true);
    @Test
    @Description("Making sure exceptionSet takes a meeting when pete.adds a meeting and that add meeting works")
    void checkExclusionSetTakesMeeting() {
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
    @Description("Can exceptionSet take more then one meeting ")
    void checkMoreThenOneMeetingInExceptionSet(){
        MeetingDate day = new MeetingDate("2022/12/12");
        MeetingTime from = new MeetingTime(2);
        MeetingTime to = new MeetingTime(4);
        Meeting m = new Meeting("choresformammy", day, from,to,csis.getRoomWithId(4));
        MeetingDate day2 = new MeetingDate("2022/12/12");
        MeetingTime from2 = new MeetingTime(2);
        MeetingTime to2 = new MeetingTime(4);
        Meeting m2 = new Meeting("cleaningoutthecar", day2, from2,to2,csis.getRoomWithId(5));
        pete.addMeeting(m2);
        pete.addMeeting(m);

        ArrayList<Meeting> mA=new ArrayList<>();
        mA.add(m2);
        mA.add(m);

        assertEquals(mA,pete.getExclusionSet());

    }


    @Test
    void getName() {
        Participant bob = new Participant("bob", "123");
        assertEquals("bob", bob.getName());
    }

    @Test
    void getPassword() {
        Participant bob = new Participant("bob","123");
        assertEquals("123",bob.getPassword());
    }

    @Test
    @Description("make sure login works HAPPY PATH")
    void loginSuccesful(){
        Participant bob = new Participant("bob","123A");
        assertTrue(bob.checkLogin("bob","123A"));
    }

    @Test
    @Description("wrong name NOT happy path grrr")
    void wrongNameOnLogin(){
        Participant bob = new Participant("bob","123A");
        assertFalse(bob.checkLogin("penelope","123A"));
    }

    @Test
    @Description("wrong password right name")
    void wrongPwordOnLogin(){
        Participant bob = new Participant("bob","123A");
        assertFalse(bob.checkLogin("bob","7890"));
    }

    @Test
    @Description("nothing right")
    void nameAndPwordWrong(){
        Participant bob = new Participant("bob","123A");
        assertFalse(bob.checkLogin("thomas","handsome"));
    }

    @Test
    @Description("Making sure privileged boolean works")
    void privileged(){
        Participant gleb = new Participant("gleb", "123",true);
        assertTrue(gleb.isPrivileged());

    }

    @Test
    @Description("Isnt priviliged sad because unhappy path")
    void  notPriviliged(){
        Participant sad = new Participant("sad","123");
        assertFalse(sad.isPrivileged());
    }

    @Test
    @Description("Isnt priviliged")
    void  otherConstructorForNotPrivileged(){
        Participant sad = new Participant("sad","123",false);
        assertFalse(sad.isPrivileged());
    }

    @Test
    @Description("Checking does remove meeting work")
    void removeMeeting() {
        MeetingDate day = new MeetingDate("2022/12/12");
        MeetingTime from = new MeetingTime(2);
        MeetingTime to = new MeetingTime(4);
        Meeting m = new Meeting("choresformammy", day, from,to,csis.getRoomWithId(4));
        pete.addMeeting(m);
        ArrayList<Meeting> mA =new ArrayList<>();


        assertTrue(pete.removeMeeting("choresformammy"));
        assertEquals(mA,pete.getExclusionSet());


    }

    @Test
    @Description("Making sure it returns false when trying to remove a meeting that doesnt exist")
    public void removeNonExistingMeeting(){
        assertFalse(pete.removeMeeting("meetingthatdoesntexist"));

    }

    @Test
    @Description("Checking does remove meeting return null")
    void removeNullMeeting() {
        assertFalse(pete.removeMeeting("fakemeeting"));
    }



}