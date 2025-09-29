package HashMapsExercises;
import java.util.HashMap;

import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

public class AviaTickets {

   // private static int seat = 1;

// Пример списка пассажиров (на самом деле их больше)

    private static List<String> passengerNames = List.of(

            "Василий Петров",

            "Анна Ягирская",

            "Виктория Сотова",

            "Игорь Серов",

            "Людмила Ульянова"

    );

    public static void main(String[] args) {

        Map<String, Integer> seats = assignSeats(passengerNames);

        System.out.println("Места пассажиров: " + seats);

    }

    public static Map<String, Integer> assignSeats(List<String> passengerNames) {
        int seat = 1;
        Map<String, Integer> seats = new LinkedHashMap<>();
        for (String passengerName : passengerNames) {
            seats.put(passengerName, seat);
            seat++;
        }
        return seats;
// Тут нужно написать код, который будет распределять места в самолёте ??
    }

}