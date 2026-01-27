package YandexAlgorithms.Sprint1;

import java.util.*;

    public class QueueAndDeque {
        public static void main(String[] args) {
            // Queue - FIFO (First In First Out)
            Queue<Integer> queue = new LinkedList<>();
            queue.add(15);      // Добавить в конец
            queue.poll();       // Удалить из начала
            queue.peek();       // Посмотреть первый элемент

            // Deque - двусторонняя очередь
            Deque<Integer> deque = new ArrayDeque<>();
            deque.addFirst(10);    // В начало
            deque.add(50);         // В конец (то же, что и addLast)
            deque.addLast(20);     // В конец
//            deque.pollFirst();     // Удалить из начала
//            deque.pollLast();      // Удалить с конца
            System.out.println(deque.peekFirst());     // Посмотреть начало
            System.out.println(deque.peekLast());      // Посмотреть конец
            System.out.println(deque.pop());
            System.out.println(deque);

            // PriorityQueue - приоритетная очередь
            PriorityQueue<String> pq = new PriorityQueue<>();
            pq.add("afdsa");
            pq.add("a");
            pq.add("cvvv");
            System.out.println(pq.poll());  // 10 (минимальный элемент)
        }
    }