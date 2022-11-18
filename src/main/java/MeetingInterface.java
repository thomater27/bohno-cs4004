import java.util.ArrayList;
import java.util.Scanner;

public class MeetingInterface {
    private Building csis = new Building(12, 3);
    private Scanner in = new Scanner(System.in);
    private ArrayList<Participant> participants = new ArrayList<>();
    private ArrayList<Meeting> meetings = new ArrayList<>();

    public void run() {
        participants.add(new Participant("John", "123", true));
        participants.add(new Participant("Bob", "aBc"));
        boolean running = true;
        while (running) {
            System.out.println("Input 1 for user login");
            System.out.println("Input 2 to quit");
            int i = in.nextInt();
            if (i == 1) {
                userLogin();
            } else if (i == 2) {
                running = false;
            } else {
                System.out.println("Please select a valid option");
            }
        }
    }

    private void userLogin() {
        while (true) {
            System.out.println("Please enter your username");
            String username = in.next();
            System.out.println("Please enter your password");
            String password = in.next();
            boolean valid = false;
            for (Participant p : participants) {
                if (p.checkLogin(username, password)) {
                    userMenu(p);
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                System.out.println("Invalid username or password");
            }
            System.out.println("Input 1 to log in again");
            System.out.println("Input 2 to exit to previous menu");
            int input = in.nextInt();
            if (input == 2) {
                break;
            }
        }
    }


    private void userMenu(Participant p) {
        boolean running = true;
        while (running) {
            if (p.isPrivileged()) {
                System.out.println("C)reate meeting, D)elete meeting, R)emove meeting, V)iew meetings, M)anage rooms, L)og out");
                String input = in.next().toLowerCase();
                if (input.equals("c") || input.equals("d") || input.equals("r") || input.equals("v") || input.equals("m") || input.equals("l")) {
                    running = userRun(input, p);
                }
            } else {
                System.out.println("V)iew meetings, R)emove meeting, L)og out");
                String input = in.next().toLowerCase();
                if (input.equals("v") || input.equals("r") || input.equals("l")) {
                    running = userRun(input, p);
                }
            }
        }
    }

    private boolean userRun(String s, Participant p) {
        switch (s) {
            case "c":
                createMeeting(p);
                return true;

            case "d":

                return true;

            case "r":
                removeMeeting(p);
                return true;

            case "v":
                viewMeetings(p);
                return true;

            case "m":

                return true;

            case "l":
                return false;
        }
        System.out.println("Invalid option, please select a valid option");
        return true;
    }

    private void createMeeting(Participant p) {
        System.out.println("Enter what the meeting is about");
        String desc = in.next();

        System.out.println("Enter the date you want to create the meeting for");
        MeetingDate date = new MeetingDate(in.next());

        System.out.println("Enter the time you want to start at :");
        MeetingTime start = new MeetingTime(in.nextInt());

        System.out.println("Enter the time you want to finish :");
        MeetingTime to = new MeetingTime(in.nextInt());

        Room r;
        System.out.println(csis.getAvailableRoomAtTime(date, start, to));
        while (true) {
            System.out.println("Enter the id of the room you want");
            r = csis.getRoomWithId(in.nextInt());
            if (r.isAvailableAtTime(date, start, to)) {
                break;
            } else {
                System.out.println("Please enter an available room id");
            }
        }

        Meeting meeting = new Meeting(desc, date, start, to, r);
        meetings.add(meeting);
        p.addMeeting(meeting);
        r.addMeeting(meeting);

        System.out.println("Select the participants you want, input 0 to finish selection");
        int count = 1;
        for (Participant f : participants) {
            System.out.print("[" + count + "] ");
            System.out.println(f.getName());
            count++;
        }
        ArrayList<Participant> selected = new ArrayList<>();

        while (true) {
            int inputValue = in.nextInt();
            if (inputValue != 0) {
                selected.add(participants.get(inputValue - 1));
                System.out.println(participants.get(inputValue - 1));
            } else {
                break;
            }
        }

        boolean success = true;
        for (Participant f : selected) {
            if (f.getExclusionSet().isEmpty()) {
                f.addMeeting(meeting);
            } else {
                for (Meeting m : f.getExclusionSet()) {
                    if (meeting.isDuring(m)) {
                        success = false;
                    } else {
                        f.addMeeting(meeting);
                    }
                }
            }
        }
        if (success) {
            System.out.println("Email sent to participants to accept meeting");
        } else {
            System.out.println("Email sent to available participants, some cannot attend");
        }
    }

    public void removeMeeting(Participant p) {
        viewMeetings(p);
        System.out.println("Please input the name of the meeting to be removed");
        String input = in.next();
        if (p.removeMeeting(input)) {
            System.out.println("Meeting removed successfully");
        } else {
            System.out.println("No meeting found by that name");
        }
    }

    public void viewMeetings(Participant p) {
        for (Meeting m : p.getExclusionSet()) {
            System.out.println(m);
        }
    }
}
