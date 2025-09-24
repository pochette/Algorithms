package ForthSprintPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PairGenerator {

    // Random — класс в Java, отвечающих за генерацию случайных элементов.
    private static final Random rnd = new Random();

    /**
     * Разбивает список незнакомцев по парам.
     */

    // Укажите правильный тип, возвращаемый этой функцией. Вам нужно преобразовать список незнакомцев в
    // набор пар, т.е. в список, состоящий из других списков.
    public List<List<Stranger>> splitByPairs(List<Stranger> strangers) {

        // Укажите тип ещё раз.
        List<List<Stranger>> pairs = new ArrayList<>();
        while (!strangers.isEmpty()) {

            List<Stranger> pair = getRandomPair(strangers);
            pairs.addLast(pair);
            // Добавьте новый элемент в набор пар.
        }
        return pairs;
    }

    /**
     * Возвращает одну пару и удаляет её из списка strangers
     */
    private List<Stranger> getRandomPair(List<Stranger> strangers) {

        // Ищем двух незнакомцев
        int p1Index = rnd.nextInt(strangers.size());
        int p2Index = rnd.nextInt(strangers.size());
        while (p2Index == p1Index) {
            p2Index = rnd.nextInt(strangers.size());
        }

        Stranger strangerOne = strangers.get(p1Index);
        Stranger strangerTwo = strangers.get(p2Index);
        strangers.remove(strangerOne);
        strangers.remove(strangerTwo);
        List<Stranger> newStrangers = new ArrayList<>(List.of(strangerOne, strangerTwo));
        return newStrangers;
				/* Осталось только удалить двух найденных незнакомцев из списка strangers,
           а затем вернуть их в качестве результата! */
    }

}

