import java.util.ArrayList;

public class Building {
    int roomsOnEachFloor ;
    int floors;
    int amountOfRooms;
    public Building(int roomsOnEachFloor, int floors )
    {
        this.roomsOnEachFloor = roomsOnEachFloor;
        this.floors = floors;
        amountOfRooms = floors * roomsOnEachFloor;
        for (int i = 0; i < amountOfRooms; i++) {
            allRooms.add(new Room(i+1, (int)(Math.random()*20+20)));
        }
    }
    ArrayList<Room> allRooms = new ArrayList<>();
    //ArrayList<Room> availableRooms = new ArrayList<>();


    public ArrayList<Room> getAllRooms() {
        return allRooms;
    }

    public Room getRoomWithId(int id) {
        for (Room r : allRooms) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public ArrayList<Room> getAvailableRoomAtTime(MeetingDate date, MeetingTime start, MeetingTime end) {
        ArrayList<Room> available = new ArrayList<>();
        for (Room r : allRooms) {
            if (r.isAvailableAtTime(date, start, end)) {
                available.add(r);
            }
        }
        return available;
    }
}
