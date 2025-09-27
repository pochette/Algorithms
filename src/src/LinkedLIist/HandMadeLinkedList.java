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
        System.out.println("Размер списка: " + integers.size());
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
        final Node<T> newNode = new Node<T>(oldLast, element, null);
        tail = newNode;
        if (oldLast == null)
            head = newNode;
        else
            oldLast.next = newNode;
        size++;
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

    // Дополнительные методы для полноты функциональности
    public T removeFirst() {
        if (head == null)
            throw new NoSuchElementException();

        T data = head.data;
        head = head.next;
        if (head != null)
            head.prev = null;
        else
            tail = null;
        size--;
        return data;
    }

    public T removeLast() {
        if (tail == null)
            throw new NoSuchElementException();

        T data = tail.data;
        tail = tail.prev;
        if (tail != null)
            tail.next = null;
        else
            head = null;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private static class Node<E> {
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