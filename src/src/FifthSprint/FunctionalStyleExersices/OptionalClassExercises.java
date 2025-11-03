package FifthSprint.FunctionalStyleExersices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        String longest = longestName(names);
        System.out.println("The longest name contains " + longest.length() + " characters.");
    }
}

