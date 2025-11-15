package SixthSprintPractice.DateAndTimeExercises;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class ZonedDateTimeExercises {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        System.out.println(zoneId);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zoneId);
        System.out.println(zonedDateTime);

        Instant instant = Instant.ofEpochSecond(-386310686L);
        System.out.println("Timestamp: " + instant);

        ZoneId zone = ZoneId.of("Europe/Moscow");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(instant, zone);
        System.out.println(zonedDateTime1);

        ZonedDateTime currentDateTime = ZonedDateTime.now();
        System.out.println("Сейчас: " + currentDateTime);

        ZonedDateTime newTime = currentDateTime.minusWeeks(2).minusDays(3).minusHours(3);
        System.out.println("Две недели назад было: " + newTime);

        Instant now = Instant.now();
        ZoneId moscowZone = ZoneId.of("Europe/Moscow");
        ZonedDateTime moscowDateTime = ZonedDateTime.ofInstant(now, moscowZone);

        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZonedDateTime newYorkDateTime = moscowDateTime.withZoneSameInstant(newYorkZone);
        System.out.println(moscowDateTime);
        System.out.println(newYorkDateTime);

        ZonedDateTime newYorkDateTime2 = moscowDateTime.withZoneSameLocal(newYorkZone);
        System.out.println(moscowDateTime);
        System.out.println(newYorkDateTime2);

    }

}
class Watch {
    private ZonedDateTime currentTime;
    private int numOfZone;
    private final List<String> zones = Arrays.asList("America/New_York", "Asia/Vladivostok", "Europe/Moscow");

    public Watch() {
        numOfZone = 0;
        ZoneId zone = ZoneId.of(zones.get(numOfZone));
        LocalDateTime dateTime = LocalDateTime.of(2025, 11, 15, 13, 0);
        currentTime = ZonedDateTime.of(dateTime, zone);
    }
    public void changeTimeZone() {
        numOfZone = (numOfZone + 1) % zones.size();
    }

    public void addTenHours() {
        currentTime = currentTime.plusHours(10);
    }

    public void addHour() {
        currentTime = currentTime.plusHours(1);
    }
    public void addTenMinutes() {
        currentTime = currentTime.plusMinutes(10);
    }
    public void addMinute() {
        currentTime = currentTime.plusMinutes(1);
    }


    public static void main(String[] args) {

        Instant now = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Время: HH:mm:ss, Регион: VV, смещение: ZZZZZ");
        ZoneId zoneId = ZoneId.of("Asia/Dubai");
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, zoneId);

        System.out.println(zonedDateTime.format(formatter));
    }
}
class AirportExercise {
    public static void main(String[] args) {
        Instant now = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss. ZZZZZ");

        ZoneId moscowZone = ZoneId.of("Europe/Moscow");
        ZonedDateTime moscowDateTime = ZonedDateTime.ofInstant(now, moscowZone);
        convertAndPrintTime(formatter, moscowDateTime,"Осло", "Europe/Oslo");
        convertAndPrintTime(formatter, moscowDateTime, "Москва", "Europe/Moscow");



    }
    private static void printTime (DateTimeFormatter formatter, ZonedDateTime zonedDateTime, String cityName) {

    }

    private static void convertAndPrintTime(DateTimeFormatter formatter, ZonedDateTime zonedDateTime,
                                            String cityName, String region) {
        ZoneId zoneId = ZoneId.of(region);
        ZonedDateTime newZoneDateTime = zonedDateTime.withZoneSameInstant(zoneId);
        System.out.println(cityName + ":");
        System.out.println(newZoneDateTime.format(formatter));
    }
}

