package YandexAlgorithms.Sprint1.Exercises;

import java.util.Queue;
import java.util.Stack;

public class StringCrypt {
    String input = "2[a]3[bc]1[d]";
    String input2 = "3[a2[b]]";

    String input1ShouldBe = "aabcbcbcd";
    String input2ShouldBe = "abbabbabb";


    public String decryptString(String input) {
        Stack<Character> stack = new Stack<>();
        int k;
        StringBuilder temp = new StringBuilder();

        char[] chars = input.toCharArray();
    }





}
