package YandexAlgorithms.Sprint1.Exercises;

import SixthSprintPractice.DateAndTimeExercises.InstantExercises;

public class LinkedListExercise {

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        void swapNodes(Node<T> head) {
            Node<T> current = head;
            while (current != null && current.next != null) {
                T temp = current.value;
                current.value = current.next.value;
                current.next.value = temp;
                current = current.next.next;
            }
        }
    }



    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(1, new Node<Integer>(2, new Node<Integer>(3, new Node<Integer>(4, null))));
        head.swapNodes(head);
        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

}
