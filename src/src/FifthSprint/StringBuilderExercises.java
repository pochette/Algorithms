package FifthSprint;

import com.sun.security.jgss.GSSUtil;

import java.util.Formatter;

public class StringBuilderExercises {
    public static void main(String[] args) {
        String excellent = "Марина Голубева, Анна Иванова, Василий Рябов, Екатерина Белых, Иван Засонин,";

        int lastNameStart = 0;
        for (int i = 0; i < excellent.length(); i++) {
            if (excellent.charAt(i) == ',') {
                System.out.println(excellent.substring(lastNameStart, i) + " - отлично!");
                lastNameStart = i + 1;
            }

        }

        String[] excArray =  excellent.split(",");
        for (String s : excArray) {
            System.out.println(s.trim() + " - отлично");
        }

        String students = "Примечание 1.1*Примечание 1.2*Примечание 1.3" ;
        String[] split = students.split("\\*");
        System.out.println(split[0].equals("Примечание 1.1"));
        System.out.println(split[1].equals("Примечание 1.2"));
        System.out.println(split[2].equals("Примечание 1.3"));


        String[] rainbow = new String[] {
                "Красный",
                "Оранжевый",
                "Желтый",
                "Зеленый",
                "Голубой",
                "Синий",
                "Фиолетовый"
        };
        String rainbowInString = String.join(", ", rainbow);
        System.out.println(rainbowInString);

        String[] colors = new String[] {"красный", "жёлтый", "зеленый"};
        String trafficLights = String.format("Цвета светофора: %s, %s и %s", colors[0], colors[1], colors[2]);
        System.out.println(trafficLights);
        Formatter.
    }
}
