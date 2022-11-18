import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParticipantTest {
    Building csis = new Building(20,4);
    Participant pete = new Participant( "pete" ,"1223", true);
    @Test
    @Description("Making sure exceptionSet takes a meeting when pete.adds a meeting and that add meeting works")
    void checkExceptionTakesMeeting() {
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
        Participant bob = new Participant("bob", "123");
        assertEquals("bob", bob.getName());
    }

    @Test
    void getPassword() {
        Participant dopey = new Participant("dopey","123");
        assertEquals("123",dopey.getPassword());
    }

    @Test
    @Description("make sure login works HAPPY PATH")
    void checkLogin(){
        Participant boob = new Participant("boob","123A");
        assertEquals(true,boob.checkLogin("boob","123A"));
    }

    @Test
    @Description("wrong name NOT happy path grrr")
    void wrongNameOnLogin(){
        Participant boob = new Participant("boob","123A");
        assertEquals(false,boob.checkLogin("penelope","123A"));
    }

    @Test
    @Description("wrong password right name")
    void wrongPwordOnLogin(){
        Participant boob = new Participant("boob","123A");
        assertEquals(false,boob.checkLogin("boob","7890"));
    }

    @Test
    @Description("nothing right")
    void bad(){
        Participant boob = new Participant("boob","123A");
        assertEquals(false,boob.checkLogin("thomas","handsome"));
    }

    @Test
    @Description("Making sure privileged boolean works")
    void privileged(){
        Participant gleb = new Participant("gleb", "123",true);
        assertEquals(true,gleb.isPrivileged());

    }

    @Test
    @Description("Isnt priviliged")
    void  otherConstructor(){
        Participant sad = new Participant("sad","123");
        assertEquals(false,sad.isPrivileged());
    }

    @Test
    @Description("Isnt priviliged")
    void  Constructor(){
        Participant sad = new Participant("sad","123",false);
        assertEquals(false,sad.isPrivileged());
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


        pete.removeMeeting("choresformammy");
        assertEquals(mA,pete.getExclusionSet());

    }








}