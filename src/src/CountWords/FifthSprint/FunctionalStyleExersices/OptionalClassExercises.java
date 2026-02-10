package CountWords.FifthSprint.FunctionalStyleExersices;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class OptionalClassExercises {
    public static Optional<String> longestName(List<String> names) {
        if (names.isEmpty()) {
            return Optional.empty();
        }
        String max = names.get(0);
        for (String name : names) {
            if (name.length() > max.length()) {
                max = name;
            }
        }
        return Optional.of(max);
    }



    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Optional<String> longest = longestName(names);
        if (longest.isPresent()) {

            System.out.println("The longest name contains " + longest.get().length() + " characters.");
        } else {
            System.out.println("There are no names in the list.");
        }
    }
}
class Practicum {
    public static Optional<String> longestName(List<Optional<String>> maybeNames) {
        int max = 0;
        Optional<String> strMax = Optional.empty();
        for (Optional<String> str : maybeNames) {
            if (str.isPresent()) {
                if (max < str.get().length()) {
                    max = str.get().length();
                    strMax = str;
                }
            }
        }
        return strMax;
    }
    public static void main(String[] args) {
        Optional<String> longest = longestName(List.of(
                Optional.of("Max"),
                Optional.empty(),
                Optional.of("Alexey"),
                Optional.empty(),
                Optional.empty(),
                Optional.of("Alex")
        ));
        if (longest.isPresent()) {
            System.out.println("The longest name contains " + longest.get().length() + " characters.");
        } else {
            System.out.println("There are no names in the list.");
        }
    }
}

class Practicum2 {
    public static void main(String[] args) {
        int[] ages = { 5, 13, 20, 5, 25, 19, 48, 11};
        OptionalInt youngest = youngestAdult(ages);
        if (youngest.isPresent()) {
            System.out.println("The youngest adult is " + youngest.getAsInt() + " years old.");
        } else {
            System.out.println("There are no adults in the list");
        }
    }

    public static OptionalInt youngestAdult(int[] ages) {
        int youngest = -1;
        for (int age : ages) {
            if (age >= 18) {
                if (youngest == -1 || age < youngest) {
                    youngest = age;
                }
            }
        }
        return youngest != -1 ? OptionalInt.of(youngest) : OptionalInt.empty();

    }
}

