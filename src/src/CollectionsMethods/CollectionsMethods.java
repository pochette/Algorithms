package CollectionsMethods;
//TODO выполнить задание на знание методов Collections Framework

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Понял — вы хотите именно задачи на статические методы java.util.Collections (типа fill(), singletonList(), nCopies() и т.д.). Ниже — компактный набор упражнений от простых к сложным и пошаговые решения для нескольких ключевых заданий, чтобы можно было быстро запустить и понять тонкости.
 * <p>
 * Задания — на методы Collections
 * Базовые (разобраться с поведением и иммутабельностью)
 * <p>
 * Collections.fill() — создайте ArrayList<Integer> из 10 элементов (произвольные значения), затем замените все элементы на одно значение с помощью Collections.fill(). (метод: fill)
 * <p>
 * Collections.singletonList() и Collections.nCopies() — создайте List<String> с помощью singletonList и nCopies. Попробуйте изменить полученные списки (и объясните результат). (методы: singletonList, nCopies, emptyList)
 * <p>
 * Collections.unmodifiableList() — оберните изменяемый список в unmodifiableList и продемонстрируйте UnsupportedOperationException. (метод: unmodifiableList)
 * <p>
 * Средние (работа с копированием, поиском, заменой)
 * <p>
 * Collections.copy() — скопируйте один список в другой. Обратите внимание на размер принимающего списка (подсказка: используйте Collections.nCopies() для подготовки). (метод: copy, nCopies)
 * <p>
 * Collections.sort() + Collections.binarySearch() — отсортируйте список строк и найдите индекс заданной строки через binarySearch. (методы: sort, binarySearch)
 * <p>
 * Collections.replaceAll() и Collections.frequency() — замените все вхождения одного значения на другое и подсчитайте частоту перед/после. (методы: replaceAll, frequency)
 * <p>
 * Collections.reverse(), Collections.swap(), Collections.rotate() — выполните серию преобразований списка и объясните результат. (методы: reverse, swap, rotate)
 * <p>
 * Продвинутые (потоки, типобезопасность, поиск подсписков)
 * <p>
 * Collections.synchronizedList() — создайте синхронизованный список. Покажите, как правильно и безопасно его итерировать (поясните, почему нужен внешний synchronized). (метод: synchronizedList)
 * <p>
 * Collections.checkedList() — создайте «проверяемый» список List<String> и вызовите вставку неправильного типа так, чтобы получить ClassCastException во время выполнения. Объясните разницу между compile-time и run-time проверками. (метод: checkedList)
 * <p>
 * Collections.disjoint() и Collections.indexOfSubList()/lastIndexOfSubList() — проверьте пересечение двух списков и найдите индекс вхождения подсписка. (методы: disjoint, indexOfSubList, lastIndexOfSubList)
 * <p>
 * Развёрнутые решения — несколько примеров (готово к копированию и запуску)
 * <p>
 * Ниже — решения для нескольких задач с комментариями и ожидаемым выводом.
 * <p>
 * Пример A — fill, singletonList, nCopies, unmodifiableList
 * import java.util.*;
 * <p>
 * public class CollectionsBasics {
 * public static void main(String[] args) {
 * // fill()
 * List<Integer> list = new ArrayList<>();
 * for (int i = 0; i < 10; i++) list.add(i);
 * System.out.println("До fill(): " + list);
 * Collections.fill(list, 7);
 * System.out.println("После fill(7): " + list);
 * <p>
 * // singletonList() — immutable single-element list
 * List<String> single = Collections.singletonList("only");
 * System.out.println("singletonList: " + single);
 * try {
 * single.add("x"); // UnsupportedOperationException
 * } catch (UnsupportedOperationException e) {
 * System.out.println("singletonList: изменение не разрешено -> " + e);
 * }
 * <p>
 * // nCopies() — возвращает неизменяемый список из N одинаковых ссылок
 * List<String> copies = Collections.nCopies(4, "hello");
 * System.out.println("nCopies(4, \"hello\"): " + copies);
 * // Если нужен изменяемый список:
 * List<String> mutableCopies = new ArrayList<>(Collections.nCopies(4, "hello"));
 * mutableCopies.set(0, "changed");
 * System.out.println("mutable копия после set: " + mutableCopies);
 * <p>
 * // unmodifiableList()
 * List<Integer> base = new ArrayList<>(Arrays.asList(1,2,3));
 * List<Integer> unmod = Collections.unmodifiableList(base);
 * System.out.println("unmodifiable: " + unmod);
 * try {
 * unmod.add(4);
 * } catch (UnsupportedOperationException e) {
 * System.out.println("unmodifiableList: нельзя добавить -> " + e);
 * }
 * }
 * }
 * <p>
 * <p>
 * Ожидаемый вывод (смысловой):
 * <p>
 * До fill(): [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 * После fill(7): [7, 7, 7, 7, 7, 7, 7, 7, 7, 7]
 * singletonList: [only]
 * singletonList: изменение не разрешено -> java.lang.UnsupportedOperationException
 * nCopies(4, "hello"): [hello, hello, hello, hello]
 * mutable копия после set: [changed, hello, hello, hello]
 * unmodifiable: [1, 2, 3]
 * unmodifiableList: нельзя добавить -> java.lang.UnsupportedOperationException
 * <p>
 * <p>
 * Пояснения / подводные камни:
 * <p>
 * Collections.fill() заменяет все элементы существующего списка — список должен уже содержать элементы.
 * <p>
 * singletonList и nCopies возвращают немодифицируемые списки; если нужно изменять — создайте new ArrayList<>(...).
 * <p>
 * unmodifiableList создаёт просмотр, который запрещает изменения через этот просмотр — но если изменить базовый список base, изменения отразятся в unmod.
 * <p>
 * Пример B — copy, sort, binarySearch
 * import java.util.*;
 * <p>
 * public class CollectionsCopySearch {
 * public static void main(String[] args) {
 * List<String> src = Arrays.asList("orange", "apple", "banana", "kiwi");
 * // Для copy() принимающий список должен иметь размер >= src.size()
 * List<String> dest = new ArrayList<>(Collections.nCopies(src.size(), "")); // заполнили "плейсхолдерами"
 * Collections.copy(dest, src);
 * System.out.println("После copy: " + dest);
 * <p>
 * // Перед использованием binarySearch список должен быть отсортирован по тому же компаратору
 * Collections.sort(dest);
 * System.out.println("После sort: " + dest);
 * int idx = Collections.binarySearch(dest, "banana");
 * System.out.println("Индекс 'banana' (binarySearch): " + idx);
 * }
 * }
 * <p>
 * <p>
 * Ожидаемый вывод:
 * <p>
 * После copy: [orange, apple, banana, kiwi]
 * После sort: [apple, banana, kiwi, orange]
 * Индекс 'banana' (binarySearch): 1
 * <p>
 * <p>
 * Подводные камни: Collections.copy(dest, src) бросит IndexOutOfBoundsException, если dest.size() < src.size(). Частая ошибка — пытаться copy в пустой ArrayList<>(); — нужно заранее обеспечить размер (например, с nCopies()).
 * <p>
 * Пример C — synchronizedList и checkedList
 * import java.util.*;
 * <p>
 * public class CollectionsAdvanced {
 * public static void main(String[] args) {
 * // synchronizedList: методы синхронизированы, но итерация требует внешней синхронизации
 * List<Integer> sync = Collections.synchronizedList(new ArrayList<>());
 * sync.addAll(Arrays.asList(1,2,3,4,5));
 * // корректная безопасная итерация:
 * synchronized(sync) {
 * for (Integer v : sync) {
 * System.out.print(v + " ");
 * }
 * }
 * System.out.println();
 * <p>
 * // checkedList: runtime-проверка типов
 * List raw = new ArrayList(); // raw type
 * List<String> checked = Collections.checkedList(raw, String.class);
 * checked.add("one"); // ок
 * try {
 * // Добавление через raw-вид всё равно попадёт в проверяемую view и проверится:
 * ((List) checked).add(123); // вызовет ClassCastException во время выполнения
 * } catch (ClassCastException e) {
 * System.out.println("checkedList: поймали ClassCastException -> " + e);
 * }
 * }
 * }
 * <p>
 * <p>
 * Ожидаемый вывод:
 * <p>
 * 1 2 3 4 5
 * checkedList: поймали ClassCastException -> java.lang.ClassCastException: Attempt to insert class java.lang.Integer element into collection with element type class java.lang.String
 * <p>
 * <p>
 * Пояснение:
 * <p>
 * synchronizedList синхронизирует методы, но при итерации вы должны брать synchronized(list) { ... }, иначе возможен ConcurrentModificationException при параллельных изменениях.
 * <p>
 * checkedList — полезно при интеграции старого «сыро типизированного» кода: проверки типов происходят во время выполнения и дают ClassCastException, если пытаются вставить несовместимый объект.
 */

public class CollectionsMethods {
    /**
     * Collections.fill() — создайте ArrayList  из 10 элементов (произвольные значения), затем замените все элементы
     * на одно значение с помощью Collections.fill(). (метод: fill)
     */
    ArrayList<Integer> tenElements = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Pineapple");

        System.out.println(fruits);
        Collections.sort(fruits, String.CASE_INSENSITIVE_ORDER);
        System.out.println(fruits);
        System.out.println();
    }
//        System.out.println(tenElements);
//        Collections.fill(tenElements, 999);
//        System.out.println(tenElements);
//        /// /////////////////////////////
//        List<String> singletonList = Collections.singletonList("6");
//        System.out.println(singletonList);
//        singletonList = Collections.nCopies(10, "1");
//        List<String> mutableList = new ArrayList<>(singletonList);
//        mutableList.add(1, "2nd element");
//        System.out.println(mutableList);
//
//        List<String> emptyList = Collections.emptyList();
//        emptyList = Collections.nCopies(45, "2");
//        System.out.println(emptyList);
//     //   emptyList.add(0, "1st element");
//        List<String> notEmpty = List.of("er", "123", "23434");
//      //  notEmpty.addFirst("232323");
//        System.out.println(emptyList);


}

/**
 * Collections.unmodifiableList() — оберните изменяемый список в unmodifiableList и продемонстрируйте UnsupportedOperationException. (метод: unmodifiableList)
 * Средние (работа с копированием, поиском, заменой)
 * Collections.copy() — скопируйте один список в другой. Обратите внимание на размер принимающего списка (подсказка: используйте Collections.nCopies() для подготовки). (метод: copy, nCopies)
 * Collections.sort() + Collections.binarySearch() — отсортируйте список строк и найдите индекс заданной строки через binarySearch. (методы: sort, binarySearch)
 * Collections.replaceAll() и Collections.frequency() — замените все вхождения одного значения на другое и подсчитайте частоту перед/после. (методы: replaceAll, frequency)
 */

