import java.time.LocalDate;

public class MeetingDate {
    private int day;
    private int month;
    private int year;
    private final String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private final int[] shortMonths = {4, 6, 9, 11};

    public MeetingDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MeetingDate(String line) {
        String[] arr = line.split("/");
        year = Integer.parseInt(arr[0]);
        month = Integer.parseInt(arr[1]);
        day = Integer.parseInt(arr[2]);
    }

    public void correctDate() {
        LocalDate today = LocalDate.now();
        //past dates are changed to current date
        if (isPast()) {
            day = today.getDayOfMonth();
            month = today.getMonthValue();
            year = today.getYear();
        } else {
            correctMonth();
            correctDay();
        }
    }

    public boolean isPast() {
        LocalDate today = LocalDate.now();
        if (year < today.getYear()) {
            return true;
        }
        if (year == today.getYear() && month < today.getMonthValue()) {
            return true;
        }
        if (year == today.getYear() && month == today.getMonthValue() && day < today.getDayOfMonth()) {
            return true;
        }
        return false;
    }

    public void correctMonth() {
        if (month < 1) {
            month = 1;
        } else if (month > 12) {
            month = 12;
        }
    }

    public void correctDay() {
        if (day < 1) {
            day = 1;
        } else if (month == 2 && day > 28) {
            if (year % 4 == 0) {
                day = 29;
            } else {
                day = 28;
            }
        } else if (day > 30) {
            boolean found = false;
            for (int shortMonth : shortMonths) {
                if (month == shortMonth) {
                    found = true;
                    break;
                }
            }
            if (found) {
                day = 30;
            } else {
                day = 31;
            }
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonthValue() {
        return month;
    }

    public String getMonthName() {
        return monthNames[month-1];
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MeetingDate that = (MeetingDate) o;
        return day == that.day && month == that.month && year == that.year;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%4d", day, month, year);
    }
}
