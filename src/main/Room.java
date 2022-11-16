import java.lang.reflect.Array;
import java.util.ArrayList;


public class Room {
    private String id;
    private boolean occupied;
    private int seats;
    private ArrayList requirements = new ArrayList<>();

    public Room(String id, boolean occupied, int seats) {
        this.id = id;
        this.occupied = occupied;
        this.seats = seats;
    }

    public boolean checkIfRoomsFree() {
        boolean status = false;
        return this.occupied;
    }

    public boolean checkIfRoomHasMoreThan10Seats() {
        boolean status = false;
        return status;
    }

    public ArrayList roomRequirements(){
        requirements.add("Projector");
        requirements.add("WhiteBoard");
        requirements.add("WiFi");
        requirements.add("Refreshments");
        return requirements;
    }

    /*
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
