package YandexAlgorithms.Sprint1.Exercises;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StringCrypt {
    String input = "2[a]3[bc]1[d]";
    String input2 = "3[a2[b]]";

    String input1ShouldBe = "aabcbcbcd";
    String input2ShouldBe = "abbabbabb";

    public String decryptString2(String input) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder currentString = new StringBuilder();
        StringBuilder result = new StringBuilder();

//        for (Character c : input.toCharArray()) {
//            if(!stack.isEmpty()) {
//                if(c != ']') {
//                    String top = String.valueOf(stack.peek());
//                    if (!top.isEmpty() && Character.isDigit(top.charAt(0)) && Character.isDigit(c))  {
//                        stack.pop();
//                        Integer newDigit = Integer.parseInt(top + c);
//                        stack.push;
//
//
//                    } else {
//                        stack.push(c);
//                    }
//                }
//                else {
//                    while (stack.peek() != '[') {
//                        currentString.append(stack.pop());
//                    }
//                    stack.pop(); // remove the '['
//
//                }
//            }
//
//
//            if (c != ']') {
//                if ()
//            }
//
//        }
//    }
//
//
//    public String decryptString(String input) {
//        Stack<Integer> counts = new Stack<>();
//        Stack<String> resultStack = new Stack<>();
//        StringBuilder currentString = new StringBuilder();
//        int k = 0;
//
//        for (char ch : input.toCharArray()) {
//            if (Character.isDigit(ch)) {
//                k = k * 10 + (ch - '0');
//            } else if (ch == '[') {
//                counts.push(k);
//                resultStack.push(currentString.toString());
//                currentString = new StringBuilder();
//                k = 0;
//            } else if (ch == ']') {
//                StringBuilder decodedString = new StringBuilder(resultStack.pop());
//                int currentK = counts.pop();
//                for (int currentCount = 0; currentCount < currentK; currentCount++) {
//                    decodedString.append(currentString);
//                }
//                currentString = decodedString;
//            } else {
//                currentString.append(ch);
//            }
//        }
//
//        return currentString.toString();
//    }
        return null;

    }



}
