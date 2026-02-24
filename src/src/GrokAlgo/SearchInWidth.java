package GrokAlgo;

import java.util.*;

public class SearchInWidth {




    boolean search (String name) {
        Deque<String> searchDeque = new ArrayDeque<>();
        Map<String, ArrayList<String>> graph = new HashMap<>();
        Deque<String> searched = new ArrayDeque<>();

        while(!searchDeque.isEmpty()) {
            String person = searchDeque.getFirst();
            if (!searched.contains(person)) {
                if (person.contains("mango")) {
                    System.out.println(person + " is a mango seller");
                    return true;
                } else {
                    searchDeque.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        return false;
    }
}
