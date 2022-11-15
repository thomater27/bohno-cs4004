import java.util.ArrayList;

public class Room {
    private String id ;
    private boolean occupied;
    private int seats;
    private ArrayList<Requirements>  equipment = new ArrayList<>();

    public Room (String id, boolean occupied, int seats, ArrayList<Requirements> equipment){
        this.id = id;
        this.occupied = occupied;
        this.seats = seats;
        this.equipment = equipment;
    }


    public boolean checkIfRoomsFree(){
        boolean status = false;
        return this.occupied;
    }
}
