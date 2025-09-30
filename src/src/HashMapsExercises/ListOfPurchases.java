package HashMapsExercises;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListOfPurchases {

    private static final List<String> allPurchases = List.of(

            "яблоки",

            "молоко",

            "колбаса",

            "огурцы",

            "сок",

            "хлеб",

            "виноград",

            "молоко",

            "йогурт",

            "хлеб",

            "пельмени"

    );

    public static void main(String[] args) {

// переменная uniquePurchases должна содержать множество уникальных товаров

Set<String> uniquePurchases = findUniquePurchases(allPurchases);

// допишите вывод количества уникальных товаров

        System.out.println( "За месяц было куплено " + uniquePurchases.size() + " уникальных товаров. \n" +
                "Всего товаров было куплено: " + allPurchases.size());

    }

// реализуйте этот метод

    public static Set<String> findUniquePurchases(List<String> allPurchases) {
        return new HashSet<>(Set.copyOf(allPurchases));
    }

}