public class Meeting {
    private final String description;
    private final MeetingDate date;
    private final MeetingTime from;
    private final MeetingTime to;
    private Room room;

    public Meeting(String description, MeetingDate day, MeetingTime from, MeetingTime to, Room room) {
        this.description = description;
        this.date = day;
        this.from = from;
        this.to = to;
        this.room = room;
    }

    public boolean isDuring(Meeting m) {
        if (date.equals(m.getDate())) {
            int from1 = from.getHours();
            int to1 = to.getHours();
            int from2 = m.getFrom().getHours();
            int to2 = m.getTo().getHours();

            return from1 < to2 && to1 > from2;
        }
        return false;
    }

    public MeetingDate getDate() {
        return date;
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
        return String.format("%s on %s from %s until %s in %s", description, date, from, to, room);
    }
}
