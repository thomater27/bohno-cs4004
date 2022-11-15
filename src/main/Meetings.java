public class Meetings {

    private String description;
    private MeetingDate day;
    private MeetingTime from;
    private MeetingTime to;

    public  Meetings(String all){
        String[] splitted = all.split(" ");
      
        this.description = splitted[0];
        this.day = new MeetingDate(splitted[1]);
        this.from = new MeetingTime(splitted[2]) ;
        this.to = new MeetingTime(splitted[3]);
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
        
        return getDescription().toString() + getDay().toString() + " "+ getFrom().toString() +" until "+ getTo().toString();
    }
}


