import java.util.ArrayList;
import java.util.Scanner;

public class MeetingInterface {
    private Building csis = new Building(12, 3);
    private Participants p;
    Scanner in = new Scanner(System.in);


    public void createMeeting() {
        System.out.println("Enter what the meeting is about");
        String desc = in.nextLine();

        System.out.println("Enter the date you want to creat a meeting");
        MeetingDate date = new MeetingDate(in.nextLine());

        System.out.println("Enter the time you want to start at :");
        MeetingTime start = new MeetingTime(in.nextInt());

        System.out.println("Enter the time you want to finish :");
        MeetingTime to = new MeetingTime(in.nextInt());


        System.out.println(csis.availableRooms);
        System.out.println("Enter the room you want");
        Room r = csis.getRoomWithId(in.nextInt());

        Meeting description = new Meeting(desc, date, start, to, r);


        System.out.println("Select the participants you want");


        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (Participants f : p.getAllP()) {
            sb.append(count + " ");
            sb.append(f);
            sb.append("\n");
            count++;
        }
        System.out.println(sb);


        ArrayList<Participants> participants = new ArrayList<>();

        for (Participants f : participants) {
            for (Meeting m : f.getExclusionSet()) {
                if (description != m) {
                    System.out.println("Email sent to participants to accept meeting");
                } else {
                    System.out.println("Some participants cannot attend");


                }


            }
        }
    }
}
