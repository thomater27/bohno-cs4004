public class Meeting {

    private String description;
    private MeetingDate day;
    private MeetingTime from;
    private MeetingTime to;
    private Room room;

    public Meeting(String details){
        String[] arr = details.split(" ");
        this.description = arr[0];
        this.day = new MeetingDate(arr[1]);
        this.from = new MeetingTime(arr[2]) ;
        this.to = new MeetingTime(arr[3]);
    }

    public Meeting(String description, MeetingDate day, MeetingTime from, MeetingTime to, Room room) {
        this.description = description;
        this.day = day;
        this.from = from;
        this.to = to;
        this.room = room;
    }

    public boolean isDuring(Meeting m) {
        int from1 = from.getHours();
        int to1 = to.getHours();
        int from2 = m.getFrom().getHours();
        int to2 = m.getTo().getHours();

        return from1 <= to2 && to1 >= from2;
    }

    public MeetingDate getDay() {
        return day;
    }
    
    public String getDescription() {
        return description;
    }

    public MeetingTime getFrom() {
        return from;
    }

    public MeetingTime getTo() {
        return to;
    }

    public String toString() {
        return String.format("%s on %s from %s until %s");
    }
}


