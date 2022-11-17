public class MeetingTime
{
    private int hours;

    public MeetingTime(String h) throws IllegalArgumentException {
        this(Integer.parseInt(h));
    }

    public MeetingTime(int hours) throws IllegalArgumentException {
        if (hours < 0 || hours > 24) {
            throw new IllegalArgumentException("Hours must be in the range 0 - 24 inclusive");
        }
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
