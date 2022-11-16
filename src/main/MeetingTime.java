public class MeetingTime
{ 
   private int hours;
   private int minutes;
    
    public MeetingTime(String h){
      String[] arr = h.split(":");
      hours = Integer.parseInt(arr[0]);
      minutes = Integer.parseInt(arr[1]);
    }

    public MeetingTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }
    
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }
}
