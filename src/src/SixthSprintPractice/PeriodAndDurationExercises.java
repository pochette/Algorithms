package SixthSprintPractice;


//продолжительность в годах - getYear()
// в месяцах - getMonths()
// в днях - getDays()
// узнать продолжительность -static between(LocalDate startDateInclusive, LocalDate endDateExclusive)
// день, обозначенный датой endDateExclusive в расчете не учитывается.


import ComparatorAndSort.DateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.logging.Formatter;

class PeriodAndDurationExercises {
    public static void main(String[] args) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1994, Month.JANUARY, 29);
        Period age = Period.between(birthday, today);
        System.out.println("Age: " + age.getYears() + " years, " +
                age.getMonths() + " months, " + age.getDays() + " days");

        LocalDateTime now = LocalDateTime.now();
        int yearOfBirth = 1994;
        Month monthOfBirth = Month.JANUARY;
        int dayOfBirth = 29;
        int hourOfBirth = 10;
        int minuteOfBirth = 10;
        LocalDateTime birthday1 = LocalDateTime.of(yearOfBirth, monthOfBirth, dayOfBirth, hourOfBirth, minuteOfBirth);

        Duration duration = Duration.between(birthday1, now);

        System.out.println("На момент запуска кода вы прожили " + duration.getSeconds() + " секунд и " + duration.getNano() + " наносекунд");

        LocalTime start = LocalTime.of(0, 0);
        LocalTime finish = LocalTime.of(1, 30);

        Duration ninetyMinutes  = Duration.between(start, finish);

        LocalTime noon = LocalTime.of(12, 0);
        System.out.println("Старый момент времени: " + noon);
        LocalTime newTime = noon.plus(ninetyMinutes);

        System.out.println("Новый момент времени: " + newTime);



        LocalTime taskStart = LocalTime.of(9, 0);
        LocalTime taskFinish = LocalTime.of(11, 30);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Duration duration2 =Duration.between(taskStart, taskFinish);

        System.out.println("В прошлый раз задача была начата в " + taskStart.format(formatter) + ", а закончена в " +
                taskFinish.format(formatter) + ".");

        System.out.println("Сейчас " + LocalTime.now().format(formatter));
        System.out.println("Instant: " + Instant.now());
        System.out.println("LocalDateTime.now(): " + LocalDateTime.now());

        Period theHundredYearWarPeriod = Period.of(116, 4, 25);
        System.out.println(theHundredYearWarPeriod);

        Period threeWeeks = Period.ofWeeks(3);
        System.out.println(threeWeeks);

        Random random = new Random();
        LocalDateTime start2 = LocalDateTime.now();

        int num = random.nextInt(5000);
        Thread.sleep(num);

        LocalDateTime finish2 = LocalDateTime.now();
        Duration duration1 = Duration.between(start2, finish2);
        System.out.println("Код выполнился за " + duration1.getSeconds() + "." + duration1.getNano());


        LocalTime secondTime = LocalTime.of(23, 40);
        LocalTime firstTime = LocalTime.of(14, 25);

        Duration duration3 = Duration.between(firstTime, secondTime);

        System.out.println("Между двумя моментами времени: \n" +
                duration3.toHours() + " часов, " + duration3.toMinutesPart() + " минут. ");
        System.out.println("Или " + duration3.toMinutes() + " Минут");


    }

}