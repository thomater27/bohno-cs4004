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
    }
    ArrayList<Room> allRooms = new ArrayList<>();
    ArrayList<Room> availableRooms = new ArrayList<>();


    public ArrayList<Room> getAllRooms() {
        return allRooms;
    }

    public ArrayList<Room> getAvailableRooms() {
        return availableRooms;
    }

    public StringBuilder availableRooms() {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(Room f : getAvailableRooms()) {
            sb.append(count + " ");
            sb.append(f);
            sb.append("\n");
            count++;
        }
        return sb;
    }
}
