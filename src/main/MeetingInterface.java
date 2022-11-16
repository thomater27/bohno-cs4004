import java.util.ArrayList;
import java.util.Scanner;

public class MeetingInterface {
    private Building csis = new Building(12,3);

    Scanner in = new Scanner(System.in);


    public void createMeeting{
        System.out.println("Enter the date you want to creat a meeting");
        String date = in.nextLine();
        System.out.println("Enter the time you want to start at :");
        int from = in.nextInt();
        System.out.println("Enter the time you want to finish :");
        int to = in.nextInt();
        System.out.println(csis.availableRooms);
        System.out.println("Enter the location you want");
        int selection = in.nextInt();

    }


}
