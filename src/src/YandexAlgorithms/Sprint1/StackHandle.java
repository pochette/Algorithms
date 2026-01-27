package YandexAlgorithms.Sprint1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackHandle<T> {

    List<T> list = new ArrayList<>();

    public void init() {
        list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return list.getLast();
        }
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        } else
            return list.removeLast();
    }

    public void push(T item) {
        list.add(item);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        StackHandle<Integer> stack = new StackHandle<>();
        stack.init();
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()); // 3
        System.out.println(stack.pop());  // 3
        System.out.println(stack.size()); // 2

        StackHandle<String> stringStack = new StackHandle<>();
        stringStack.init();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println(stringStack.peek()); // World
        System.out.println(stringStack.pop());  // World
        System.out.println(stringStack.size()); // 1

        Stack<Integer> javaStack = new Stack<>();
        javaStack.push(1);
        javaStack.push(2);
        javaStack.push(3);
        System.out.println(javaStack.peek()); // 3
        System.out.println(javaStack.pop());  // 3
        System.out.println(javaStack.size()); // 2


        Stack<String> javaStringStack = new Stack<>();
        javaStringStack.push("Hello");
        javaStringStack.push("World");
        System.out.println(javaStringStack.peek()); // World
        System.out.println(javaStringStack.pop());  // World
        System.out.println(javaStringStack.size()); // 1

    }
}
