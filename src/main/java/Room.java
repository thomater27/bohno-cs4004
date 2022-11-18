import java.util.ArrayList;

public class Room {
    private final int id;
    private int capacity;
    private ArrayList<String> resources = new ArrayList<>();
    private ArrayList<Meeting> meetings = new ArrayList<>();

    public Room(int id, int seats) {
        this.id = id;
        this.capacity = seats;
    }

    public void setCapacity(int capacity) {
        if (capacity >= 0) {
            this.capacity = capacity;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void addResource(String r) {
        resources.add(r.toLowerCase());
    }

    public void removeResource(String r) {
        r = r.toLowerCase();
        resources.remove(r);
    }

    public boolean hasResource(String r) {
        r = r.toLowerCase();
        return resources.contains(r);
    }

    public ArrayList<String> getResources() {
        return resources;
    }

    public void clearResources() {
        resources.clear();
    }

    public void addMeeting(Meeting m) {
        meetings.add(m);
    }

    public boolean removeMeeting(Meeting m) {
        return meetings.remove(m);
    }

    public void clearMeetings() {
        meetings.clear();
    }

    public boolean isAvailableAtTime(MeetingDate date, MeetingTime start, MeetingTime end) {
        Meeting meeting = new Meeting("sample", date, start, end, this);
        for (Meeting m : meetings) {
            if (m.getDate().equals(date)) {
                return !meeting.isDuring(m);
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Room %02d", id);
    }

    public boolean hasCapacity(int numberOfPeople) {
        return capacity >= numberOfPeople;
    }

    public int getId() {
        return id;
    }

/*
    public boolean checkIfRoomsFree() {
        boolean status = false;
        return this.occupied;
    }

    public boolean checkIfRoomHasMoreThan10Seats() {
        boolean status = false;
        return status;
    }

    public ArrayList roomRequirements(){
        resources.add("Projector");
        resources.add("WhiteBoard");
        resources.add("WiFi");
        resources.add("Refreshments");
        return resources;
    }

    public ArrayList wheelchairAccessibleRoomRequirements(){
        wheelchairAccessibleRoomRequirements().add("stairs");
        return null;
    }
    public boolean wheelchairAccessible(){
        if (Room contains

        return true;
    }


    public boolean String.contains(CharSequence s){
        return ok;
    }
*/
}