package SixthSprintPractice;

import java.time.Instant;
import java.util.Random;

public class TimesExercises {

    public static void main(String[] args) {
        Instant satelliteLaunchFromSec = Instant.ofEpochSecond(-386310686L);

        Instant satelliteLaunchFromMillis = Instant.ofEpochMilli(-386310686000L);

        System.out.println(satelliteLaunchFromSec + " - время запуска, заданное через секунды.");
        System.out.println(satelliteLaunchFromMillis + " - время запуска, заданное через миллисекунды.");

        System.out.println("Instant.MAX: " + Instant.MAX);
        System.out.println("Instant.MIN: " + Instant.MIN);
        System.out.println("Instant.EPOCH: " + Instant.EPOCH);

        Instant newSatelliteLaunchFromMillis = satelliteLaunchFromMillis.minusMillis(2000);
        System.out.println("newSatelliteLaunchFromMillis: " + newSatelliteLaunchFromMillis);

        long seconds = 180;

        Instant currentMoment = Instant.now();
        System.out.println("Now is " + currentMoment);
        Instant futureMoment = currentMoment.plusSeconds(seconds);
        System.out.println("In " + seconds + " seconds it will be " + futureMoment);

        int chickenUnixSecond = new Random().nextInt(1000000000);
        Instant chickenMoment = Instant.ofEpochSecond(chickenUnixSecond);
        int eggUnixSecond = new Random().nextInt(1000000000);
        Instant eggMoment = Instant.ofEpochSecond(eggUnixSecond);

        System.out.println("Курица появилась в " + chickenMoment);
        System.out.println("Яйцо появилоь в " + eggMoment);

        if (chickenMoment.isBefore(eggMoment)) {
            System.out.println("Первой была курица!");
        }
        if (chickenMoment.isAfter(eggMoment)) {
            System.out.println("Первой был яйцо!");
        }
        if (chickenMoment.equals(eggMoment)) {
            System.out.println("Яйцо с курицей появились одновременно!");
        }

    }
}
