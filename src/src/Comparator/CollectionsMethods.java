package Comparator;

import java.util.*;

public class CollectionsMethods {
    public static void main(String[] args) {
        final List<String> emptyList = Collections.emptyList();
        final List<String> singletonList = Collections.singletonList("Привет, мир!");
        final List<String> nCopiesList = Collections.nCopies(5, "Java");

        System.out.println(emptyList);
        System.out.println(singletonList);
        System.out.println(nCopiesList);

        final List<String> immutableList = List.of("неизменяемый список строка 1", "неизменяемый список строка 2", "неизменяемый список строка 3", "неизменяемый список строка 4");
        final ArrayList<String> mutableList = new ArrayList<>(immutableList);

        System.out.println(mutableList);
        final Map<Integer, String> emptyMap = Collections.EMPTY_MAP;
        System.out.println(emptyMap);

//        final Map<Integer, String> map = Collections.checkedMap();

    }
}
