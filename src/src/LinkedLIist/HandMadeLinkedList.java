package LinkedLIist;

import java.util.NoSuchElementException;

public class HandMadeLinkedList<T> {

    /**
     * Указатель на первый элемент списка. Он же first
     */

    private Node<T> head;
    /**
     * Указатель на последний элемент списка. Он же last
     */
package LinkedLIist;

import java.util.NoSuchElementException;

    public class HandMadeLinkedList<T> {

        /**
         * Указатель на первый элемент списка. Он же first
         */

        private LinkedLIist.HandMadeLinkedList.Node<T> head;
        /**
         * Указатель на последний элемент списка. Он же last
         */

        private LinkedLIist.HandMadeLinkedList.Node<T> tail;
        private int size = 0;

        public static void main(String[] args) {

            LinkedLIist.HandMadeLinkedList<Integer> integers = new LinkedLIist.HandMadeLinkedList<>();

            integers.addFirst(1);

            integers.addFirst(2);

            integers.addFirst(3);

            integers.addLast(4);

            integers.addLast(5);

            System.out.println(integers.getFirst());

            System.out.println(integers.getLast());

        }

        public void addFirst(T element) {
            final LinkedLIist.HandMadeLinkedList.Node<T> oldHead = head;
            final LinkedLIist.HandMadeLinkedList.Node<T> newNode = new LinkedLIist.HandMadeLinkedList.Node<>(null, element, oldHead);
            head = newNode;
            if (oldHead == null)
                tail = newNode;
            else
                oldHead.prev = newNode;
            size++;
        }

        public T getFirst() {
            final LinkedLIist.HandMadeLinkedList.Node<T> curHead = head;
            if (curHead == null)
                throw new NoSuchElementException();
            return head.data;
        }

        public void addLast(T element) {
            final LinkedLIist.HandMadeLinkedList.Node<T> oldLast = tail;
            final LinkedLIist.HandMadeLinkedList.Node<T> newNode= new LinkedLIist.HandMadeLinkedList.Node<T>(tail, element, null);
            tail = newNode;
            if(oldLast == null)
                head = newNode;
            else
                oldLast.next = newNode;
            size++;




// Реализуйте метод

        }

        public T getLast() {

            final LinkedLIist.HandMadeLinkedList.Node<T> curTail = tail;

            if (curTail == null)

                throw new NoSuchElementException();

            return tail.data;
        }

        public int size() {

            return this.size;

        }

        class Node<E> {

            public E data;

            public LinkedLIist.HandMadeLinkedList.Node<E> next;

            public LinkedLIist.HandMadeLinkedList.Node<E> prev;

            public Node(LinkedLIist.HandMadeLinkedList.Node<E> prev, E data, LinkedLIist.HandMadeLinkedList.Node<E> next) {

                this.data = data;

                this.next = next;

                this.prev = prev;

            }

        }

    }

    private Node<T> tail;
    private int size = 0;

    public static void main(String[] args) {

        HandMadeLinkedList<Integer> integers = new HandMadeLinkedList<>();

        integers.addFirst(1);

        integers.addFirst(2);

        integers.addFirst(3);

        integers.addLast(4);

        integers.addLast(5);

        System.out.println(integers.getFirst());

        System.out.println(integers.getLast());

    }

    public void addFirst(T element) {
        final Node<T> oldHead = head;
        final Node<T> newNode = new Node<>(null, element, oldHead);
        head = newNode;
        if (oldHead == null)
            tail = newNode;
        else
            oldHead.prev = newNode;
        size++;
    }

    public T getFirst() {
        final Node<T> curHead = head;
        if (curHead == null)
            throw new NoSuchElementException();
        return head.data;
    }

    public void addLast(T element) {
        final Node<T> oldLast = tail;
        final Node<T> newNode= new Node<T>(tail, element, null);
        tail = newNode;
        if(oldLast == null)
            head = newNode;
        else
            oldLast.next = newNode;
        size++;




// Реализуйте метод

    }

    public T getLast() {

        final Node<T> curTail = tail;

        if (curTail == null)

            throw new NoSuchElementException();

        return tail.data;
    }

    public int size() {

        return this.size;

    }

    class Node<E> {

        public E data;

        public Node<E> next;

        public Node<E> prev;

        public Node(Node<E> prev, E data, Node<E> next) {

            this.data = data;

            this.next = next;

            this.prev = prev;

        }

    }

}
