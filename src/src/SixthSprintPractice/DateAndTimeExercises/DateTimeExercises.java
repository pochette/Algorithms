package SixthSprintPractice.DateAndTimeExercises;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.time.Month.*;

public class DateTimeExercises {
    public static void main(String[] args) {
        // Создайте объект LocalDate для 1 января 2023 года
        // Создайте объект LocalTime для 10 часов 30 минут 0 секунд
        // Создайте объект LocalDateTime, объединив LocalDate и LocalTime
        // Выведите все три объекта на консоль

        // Прибавьте 5 дней к LocalDate и выведите результат
        // Прибавьте 2 часа к LocalTime и выведите результат
        // Прибавьте 1 месяц к LocalDateTime и выведите результат

        // Сравните два LocalDate: 1 января 2023 года и 15 января 2023 года
        // Выведите, какой из них раньше, какой позже, или они равны

        LocalDateTime currentMoment = LocalDateTime.now();
        System.out.println(currentMoment);

        LocalDateTime newMillennium = LocalDateTime.of(2000, 1, 1, 0, 0, 0, 0);
        System.out.println(newMillennium);

        LocalDateTime alsoNewMillennium = LocalDateTime.of(2222, 1, 1, 0, 0);
        System.out.println(alsoNewMillennium);

        LocalDateTime dateTimeOfTwos = LocalDateTime.of(2222, FEBRUARY, 2, 22, 22);
        System.out.println(dateTimeOfTwos);

        LocalDateTime withYear = currentMoment.withYear(1990);
        LocalDateTime twoWeekAgo = currentMoment.minusWeeks(2);
        LocalDateTime leapDay = LocalDateTime.of(2028, 2, 29, 0, 0);
        LocalDateTime noLeapDay = LocalDateTime.of(2027, 2, 28, 0, 0);
        LocalDateTime errorMayBe = leapDay.plusYears(1);
        System.out.println("leapDay: " + leapDay);
        System.out.println("leapDay plus 1 year: " + errorMayBe);

    }

    static class Practicum {
        public static final int START_YEAR = 2025;
        public static final int START_DAY = 1;

        public static final int MAX_SHIFT = 8;

        public static void main(String[] args) {
            printWorkHours(8, 30, 5, 5);
        }

        private static void printWorkHours(
                int startHours, //час, с которого начинается рабочая смена.
                int startMinutes, // минута, с которой начинается рабочая смена.
                int startContinuation, // продолжительность смены в часах.
                int shiftHours // количество смен
        ) {
            if (shiftHours > MAX_SHIFT) {
                System.out.println("Превышено максимальное время смены. Измените продолжительность смены.");
            }
            int shiftsCount = 1;
            LocalDateTime startTime = LocalDateTime.of(START_YEAR, JULY, START_DAY, startHours, startMinutes);
            int hoursFromStart = 0;
            int nextShiftHour = hoursFromStart + startContinuation;

            while (shiftsCount <= shiftHours) {

                System.out.println(shiftsCount + " смена. Начало: " + startTime.plusHours(hoursFromStart) + ", конец: " + startTime.plusHours(nextShiftHour));
                shiftsCount++;
                hoursFromStart += startContinuation;
                nextShiftHour += startContinuation;
            }
        }
    }
}

class Practicum2 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Было: " + now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        String formatDate = now.format(formatter);
        System.out.println("Стало: " + formatDate);

        LocalDateTime dateTime = LocalDateTime.parse("2025-07-21T21:21:21");
        System.out.println(dateTime);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");

        LocalDateTime anotherDateTime = LocalDateTime.parse("22.02.2022, 22:22", formatter1);
        System.out.println(anotherDateTime);

        System.out.println(dateTime.isAfter(anotherDateTime));
    }
}
class Practicum3 {
    public static void main(String[] args) {
        String input = "14 часов 09 минут. Месяц: 02, День: 14, Год: 1966.";
        printCorrectDateTime(input);

    }

    private static void printCorrectDateTime(String input) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("HH часов mm минут. Месяц: MM, День: dd, Год: yyyy.");
        LocalDateTime dateTime = LocalDateTime.parse(input, inputFormatter);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy|HH:mm");
        System.out.println(dateTime.format(outputFormatter));
    }
}
class Practicum4 {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        LocalTime time = dateTime.toLocalTime();
        System.out.println("local time from dateTime: " + time);

        LocalDate date = dateTime.toLocalDate();
        System.out.println("local date from dateTime: " + date);

        LocalTime time2 = LocalTime.now();
        LocalDate date2 = LocalDate.now();

        LocalDateTime newDateTime = LocalDateTime.of(date2, time2);

        System.out.println(newDateTime);
    }
}
class Practicum5 {
    public static final int PROGRAMMER_YEAR_DAY = 256;

    public static void main(String[] args) {
        System.out.println("День программиста отмечается в " + PROGRAMMER_YEAR_DAY + "-й день в году.");
        LocalDate today = LocalDate.now();
        System.out.println("Сегодня " + today.getYear() + " год.");

        LocalDate programmerDay = LocalDate.ofYearDay(today.getYear(), PROGRAMMER_YEAR_DAY);
        System.out.println("День программиста отмечается в " + programmerDay.getDayOfMonth() +
                " " + programmerDay.getMonth());
        System.out.println("День недели: " + programmerDay.getDayOfWeek());

    }
}
class Practicum6 {
    public static void main(String[] args) {
        LocalDate secretDate = LocalDate.of(2020, 1, 10);
        LocalTime secretTime = LocalTime.of(12, 30);

        int result = decode(secretDate, secretTime);
        System.out.println(result);
    }

    private static int decode(LocalDate secretDate, LocalTime secretTime) {
        LocalDateTime secretDateTime = LocalDateTime.of(secretDate, secretTime);

        LocalDateTime decodedDateTime = secretDateTime.minusMonths(2).minusDays(25).minusMinutes(100);
        return decodedDateTime.getDayOfYear();
    }
}