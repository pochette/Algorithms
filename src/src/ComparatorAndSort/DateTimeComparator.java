package ComparatorAndSort;

import java.util.Comparator;

public class DateTimeComparator implements Comparator <DateTime>{

    @Override
    public int compare(DateTime today, DateTime timeOfReturn) {
        if (today.getYear() != timeOfReturn.getYear()) {
            return Integer.compare(today.getYear(), timeOfReturn.getYear());
        } else if (today.getMonth() != timeOfReturn.getMonth()) {
            return Integer.compare(today.getMonth(), timeOfReturn.getMonth());
        } else if (today.getDay() != timeOfReturn.getDay()) {
            return Integer.compare(today.getDay(), timeOfReturn.getDay());
        } else if (today.getHour() != timeOfReturn.getHour()) {
            return Integer.compare(today.getHour(), timeOfReturn.getHour());
        } else if (today.getMinute() != timeOfReturn.getMinute()) {
            return Integer.compare(today.getMinute(), timeOfReturn.getMinute());
        } else
            return Integer.compare(today.getSecund(), timeOfReturn.getSecund());
    }
}
