package ComparatorAndSort;

public class RentedFilm {
    private String title;
    private DateTime timeOfRent;
    private DateTime timeOfReturn;

    public RentedFilm (String title, DateTime timeOfRent, DateTime timeOfReturn) {
        this.title = title;
        this.timeOfRent = timeOfRent;
        this.timeOfReturn = timeOfReturn;
    }

    public String getTitle() {
        return title;
    }

    public DateTime getTimeOfRent() {
        return timeOfRent;
    }

    public DateTime getTimeOfReturn() {
        return timeOfReturn;
    }

    @Override
    public String toString() {
        return "RentedFilm{" +
                "title='" + title + '\'' +
                ", timeOfRent=" + timeOfRent +
                ", timeOfReturn=" + timeOfReturn +
                '}';
    }
}
