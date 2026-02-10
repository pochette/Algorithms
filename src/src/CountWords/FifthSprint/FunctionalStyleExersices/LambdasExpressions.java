package CountWords.FifthSprint.FunctionalStyleExersices;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdasExpressions {

    public static void main(String[] args) {
        Consumer<String> greeter = name -> System.out.println("Hello, " + name + "!");

        greeter.accept("Andrew");

        Comparator<String> comparator = (s1, s2) -> s1.length() - s2.length();

        System.out.println(comparator.compare("Hello", "World!"));

        Predicate<List<Integer>> sortedPredicate = list -> {
            if (list.size() <= 1) return true;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(i - 1)) {
                    return false;
                }
            }
            return true;
        };

        List<Integer> list = List.of(4, 8, 15, 16, 19, 20, 23);
        System.out.println(sortedPredicate.test(list));

        Person person = new Person("Alice", "Thine", 5);
        Person kostya = new Person("Костя", "перец", 10);

        System.out.println(kostya.isOlderPredicate().test(new Person("Старше", "salt", 16)));
        System.out.println(kostya.isOlderPredicate().test(new Person("Младше", "Paprika", 2)));
        System.out.println("old Favourite spice: " + kostya.getFavouriteSpice());
        kostya.trySpice().accept("Кардамон");
        System.out.println("new Favourite spice: " + kostya.getFavouriteSpice());
        Person alice = new Person("Alice", "salt");
        Person bob = new Person("Bob", "pepper");

// Каждый человек создает свой собственный "дегустатор"
        Consumer<String> aliceTaster = alice.trySpice();
        Consumer<String> bobTaster = bob.trySpice();

// Теперь можно "угощать" разными специями:
        aliceTaster.accept("cinnamon");  // Alice попробует корицу
        bobTaster.accept("paprika");     // Bob попробует паприку

        System.out.println("Alices favourite spice is " + alice.getFavouriteSpice());
        System.out.println("Bobs favourite spice is " + bob.getFavouriteSpice());

        List<String> countries = new ArrayList<>(List.of(
                "Мозамбик",
                "Japan",
                "",
                "USA",
                ""
        ));
        countries.removeIf(country -> country.isEmpty());
        countries.removeIf(String::isEmpty);
        Predicate<String> hasCountry = countries::contains;

        Predicate<String> hasCountry1 = country -> countries.contains(country);



    }
}

class Person {
    private String name;
    private String favouriteSpice;
    private int age;

    public Person(String name, String favoriteSpice, int age) {
        this.favouriteSpice = favoriteSpice;
        this.name = name;
        this.age = age;
    }
    public Person(String name, String favouriteSpice) {
        this.name = name;
        this.favouriteSpice = favouriteSpice;
    }

    public Consumer<String> trySpice() {
        return spice -> {
            if (spice.length() > favouriteSpice.length()) {
                favouriteSpice = spice;
            }
        };
    }

    public Predicate<Person> isOlderPredicate() {
        return person -> person.age > age;
    }

    // Генерация мельницы для добавления любимой специи в блюдо
    public UnaryOperator<String> addFavouriteSpice() {
        return recipe -> recipe + " " + favouriteSpice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavouriteSpice() {
        return favouriteSpice;
    }

    public void setFavouriteSpice(String favouriteSpice) {
        this.favouriteSpice = favouriteSpice;
    }
}

class Countries {





}






