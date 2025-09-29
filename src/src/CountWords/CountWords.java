package CountWords;

import java.util.*;

public class CountWords {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("A");
        input.add("B");
        input.add("AA");
        input.add("BB");
        input.add("A");
        input.add("BB");
        input.add("A");

        Collection<String> result = duplicateRemoving(input);


        System.out.println(result);

    }
    private static Map<String, Integer> countWords(List<String> input) {
        HashMap<String,Integer> countMap = new HashMap<>();
        for (String value : input) {
            int count = countMap.getOrDefault(value, 0);
            count++;
            countMap.put(value, count);
        }
        return countMap;
    }
    private static Collection<String> duplicateRemoving(List<String> input){
        Set<String> uniq = new LinkedHashSet<>();
        for (String value : input) {
            uniq.add(value);
        }
        return uniq;
    }

}
