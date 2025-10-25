package ForthSprintPractice.StringsExercises;

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

        String[] colors = new String[] {"красный", "жёлтый", "Зеленый"};
        String trafficLights = String.format("Цвета светофора: %S, %S и %S", colors[0], colors[1], colors[2]);
        System.out.println(trafficLights);

        boolean theTruth = true;
        System.out.printf("%b", theTruth);
        System.out.printf("\n%B", theTruth);

        System.out.printf("\n%S\n", trafficLights);

        String pizza = "Пицца, 1 шт.,  310.50";
        String tea = "Tea, 1 pc., 113.30";
        int[]  numbers = {1,2,3,4,5,6,7,8,9,10};
        System.out.print(numbers[0]);
        System.out.printf("%40s", pizza);
        System.out.print("\n" + numbers[1]);
        System.out.printf("%40s", tea);

        String discount = "-10%";
        System.out.printf("\n%-40s", pizza);
        System.out.println(discount);

        double price = 12345.6789;
        System.out.printf("\n%1.0f", price);
        System.out.printf("\n%sn%s%n%s", pizza,tea,discount);

    }

}
