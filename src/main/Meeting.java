public class Meeting {

    private String description;
    private MeetingDate day;
    private MeetingTime from;
    private MeetingTime to;

    public Meeting(String details){
        String[] arr = details.split(" ");
        this.description = arr[0];
        this.day = new MeetingDate(arr[1]);
        this.from = new MeetingTime(arr[2]) ;
        this.to = new MeetingTime(arr[3]);
    }

    public Meeting(String description, MeetingDate day, MeetingTime from, MeetingTime to) {
        this.description = description;
        this.day = day;
        this.from = from;
        this.to = to;
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


