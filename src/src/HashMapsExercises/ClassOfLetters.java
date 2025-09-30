package HashMapsExercises;
import java.time.LocalDate;

import java.util.*;

public class ClassOfLetters {
    private static final Set<Letter> letters = new HashSet();



    public static void main(String[] args) {

       // информация о письмах (в порядке занесения в систему)

        letters.add(new Letter("Джон Смит", LocalDate.of(2021, 7, 7), "текст письма №1 ..."));

        letters.add(new Letter("Аманда Линс", LocalDate.of(2021, 6, 17), "текст письма №2 ..."));

        letters.add(new Letter("Джо Кью", LocalDate.of(2021, 7, 5), "текст письма №3 ..."));

        letters.add(new Letter("Мишель Фернандес", LocalDate.of(2021, 8, 23), "текст письма №4 ..."));

        printOrderedById(letters);

        printOrderedByDateReceived(letters);

    }

    private static void printOrderedById(Set<Letter> letters) {

        System.out.println("Все письма с сортировкой по ID ");

        for (Letter letter : letters) {

            System.out.println(" Письмо от "+ letter.authorName +" поступило "+ letter.dateReceived);

        }

    }

    private static void printOrderedByDateReceived(Set<Letter> letters) {
        Set<Letter> dateSortedLetters = new TreeSet<>(new ComparatorDateLetter());
        dateSortedLetters.addAll(letters);
        System.out.println("\nВсе письма с сортировкой по дате: ");
        for (Letter letter : dateSortedLetters) {

            System.out.println(" Письмо от "+ letter.authorName +" поступило "+ letter.dateReceived);

        }
    }

    private static void printOrderedByDateReceived2 (Set<Letter> letters) {
        Set<Letter> dateSortedLetter2 = new TreeSet<>(Comparator.comparing(letter -> letter.dateReceived));
        dateSortedLetter2.addAll(letters);
        System.out.println("\nВсе письма с сортировкой по дате: ");
        for (Letter letter : dateSortedLetter2) {

            System.out.println(" Письмо от "+ letter.authorName +" поступило "+ letter.dateReceived);

        }

    }
    static class Letter {

        public String authorName; //имя отправителя

        public LocalDate dateReceived;// дата получения письма

        public String text;// текст письма

        public Letter(String senderName, LocalDate dateReceived, String text) {

            this.authorName = senderName;

            this.dateReceived = dateReceived;

            this.text = text;

        }

    }
    public static class ComparatorDateLetter implements Comparator<Letter> {

        @Override
        public int compare(Letter o1, Letter o2) {
            return o1.dateReceived.compareTo(o2.dateReceived);
        }
    }

}