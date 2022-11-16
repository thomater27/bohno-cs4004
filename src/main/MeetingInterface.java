import java.util.ArrayList;
import java.util.Scanner;

public class MeetingInterface {
    private Building csis = new Building(12,3);

    Scanner in = new Scanner(System.in);


    public void createMeeting(){
        System.out.println("Enter what the meeting is about");
        String desc = in.nextLine();

        System.out.println("Enter the date you want to creat a meeting");
        MeetingDate date = new MeetingDate(in.nextLine());

        System.out.println("Enter the time you want to start at :");
        MeetingTime start = new MeetingTime(in.nextInt());

        System.out.println("Enter the time you want to finish :");
        MeetingTime to = new MeetingTime(in.nextInt());

        System.out.println(csis.availableRooms);
        System.out.println("Enter the location you want");
        int selection = in.nextInt();

        Meeting BLEH = new Meeting(desc , date, start, to, selection);

    }


}
