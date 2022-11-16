public class MeetingTime
{ 
   private int hours;
    
    public MeetingTime(String h){
      hours = Integer.parseInt(h);
    }

    public MeetingTime(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return String.format("%02d:00", hours);
    }
}
