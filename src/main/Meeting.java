import java.time.LocalDateTime;

public class Meeting {
    //private Room location;
    private LocalDateTime time;
    private float durationInHours;
    private int maxAttendees;

    public Meeting(LocalDateTime time, float duration, int maxAttendees) {
        //this.location = location;
        this.time = time;
        durationInHours = duration;
        this.maxAttendees = maxAttendees;
    }
}
