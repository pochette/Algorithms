package ComparatorAndSort;

public class DateTime {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int secund;

    public DateTime(int day, int month, int year, int hour, int minute, int secund) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.secund = secund;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecund() {
        return secund;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hour=" + hour +
                ", minute=" + minute +
                ", secund=" + secund +
                '}';
    }
}
