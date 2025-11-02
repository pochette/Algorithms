package FifthSprint.FunctionalStyleExersices;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StringSaverStandard {
    public static final int MAX_SIZE = 10_000;

    List<String> saved = new LinkedList<>();
    private Function<String, String> transformer;
    private Consumer<String> onSaveListener;
    private Consumer<String> onRemoveListener;


    public void setTransformer(Function<String, String> transformer) {
        this.transformer = transformer;
    }

    public void setOnSaveListener(Consumer<String> onSaveListener) {
        this.onSaveListener = onSaveListener;
    }

    public void setOnRemoveListener(Consumer<String> onRemoveListener) {
        this.onRemoveListener = onRemoveListener;
    }

    public List<String> getSaved() {
        return new ArrayList<>(saved);
    }

    public void save(String line) {
        if (saved.size() == MAX_SIZE) {
            String removedLine = saved.remove(0);
            if (onRemoveListener != null) {
                onRemoveListener.accept(removedLine);
            }
        }
        if (onSaveListener != null) {
            onSaveListener.accept(line);
        }
        if (transformer != null) {
            line = transformer.apply(line);
        }
        saved.add(line);
    }

    public void remove(String line) {
        if (saved.contains(line)) {
            saved.remove(line);
            if (onRemoveListener != null) {
                onRemoveListener.accept(line);
            }
        }
    }

    public static void main(String[] args) {

        Predicate<String> tooLongPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 100;
            }
        };

        String name = "Агафья";

        System.out.println("Слишком длинное имя " + name + "?");
        System.out.println("Answer: " + tooLongPredicate.test(name));

        Supplier<Double> randomDoubleSupplier = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };

        Double supplied = randomDoubleSupplier.get();
        System.out.println(supplied);



        List<String> people = new ArrayList<>(List.of(
                "Мария Зуева",
                "Анна Дарк",
                "Кирилл Филимонов",
                "Ева Пинк"
        ));
        StringSaverStandard saver = new StringSaverStandard();

        saver.setTransformer(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toLowerCase(Locale.ROOT);
            }
        });

        // 3. Set a listener to log when a string is removed
        saver.setOnRemoveListener(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Removed: " + s);
            }
        });

        System.out.println("--- Saving initial names ---");
        saver.save("Мария Зуева");
        saver.save("Анна Дарк");
        saver.save("Кирилл Филимонов");
        saver.save("Ева Пинк");
        System.out.println("\n--- Current saved list ---");
        System.out.println(saver.getSaved());
        System.out.println("\n--- Removing an element ---");
        saver.remove("АННА ДАРК"); // Try to remove the transformed version

        System.out.println("\n--- Final saved list ---");
        System.out.println(saver.getSaved());

        System.out.println("\n--- Trying to remove a non-existent element ---");
        saver.remove("Неизвестный"); // Nothing should happen
        System.out.println(saver.getSaved());

    }


}
