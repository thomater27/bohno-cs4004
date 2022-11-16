import java.util.ArrayList;

public class Building {
    public Building(Rooms )
    {

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
