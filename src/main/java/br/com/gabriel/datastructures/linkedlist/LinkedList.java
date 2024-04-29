package br.com.gabriel.datastructures.linkedlist;

import java.util.Objects;

public class LinkedList {
    private Node head;

    public void addFirst(int data) {

        Node newNode = new Node(data);

        if (Objects.isNull(head)) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;

    }

    public int getFirst() {

        if (Objects.isNull(head)) {
            throw new IllegalStateException("The list is empty!");
        }

        return head.data;
    }

    public int getLast() {

        if (Objects.isNull(head)) {
            throw new IllegalStateException("The list is empty!");
        }

        Node current = head;

        while (Objects.nonNull(current.next)) {
            current = current.next;
        }

        return current.data;

    }

    public void addLast(int data) {

        Node newNode = new Node(data);

        if (Objects.isNull(head)) {
            head = newNode;
            return;
        }

        Node current = head;

        while (Objects.nonNull(current.next)) {
            current = current.next;
        }

        current.next = newNode;

    }

    public int size() {

        if (Objects.isNull(head)) {
            return 0;
        }

        int size = 1;
        Node current = head;

        while (Objects.nonNull(current.next)) {
            current = current.next;
            size++;
        }

        return size;

    }

    public void clear() {

        if (Objects.isNull(head)) {
            throw new IllegalStateException("The list is empty!");
        }

        head = null;

    }

    public void add(int position, int data) {

        if (position < 0 || position > size()) {
            throw new IllegalArgumentException("Index out of list bounds");
        }

        if (Objects.isNull(head)) {
            return;
        }

        Node newNode = new Node(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        int currentPosition = 1;
        Node current = head;

        while (currentPosition < position) {
            current = current.next;
            currentPosition++;
        }

        newNode.next = current.next;
        current.next = newNode;

    }

    public int get(int position) {

        if (Objects.isNull(head)) {
            throw new IllegalStateException("The list is empty!");
        }

        if (position < 0 || position >= size()) {
            throw new IllegalArgumentException("Index out of list bounds");
        }

        if (position == 0) {
            return head.data;
        }

        int currentPosition = 0;
        Node current = head;

        while (currentPosition < position) {
            current = current.next;
            currentPosition++;
        }

        return current.data;

    }

    public void delete(int data) {

        if (Objects.isNull(head)) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while (Objects.nonNull(current.next)) {

            if (current.next.data == data) {
                current.next = current.next.next;
            }

            current = current.next;
        }

    }

    public void deleteByPosition(int position) {

        if (Objects.isNull(head)) {
            throw new IllegalStateException("The list is empty!");
        }


        if (position < 0 || position >= size()) {
            throw new IllegalArgumentException("Index out of list bounds");
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        int currentPosition = 1;
        Node current = head;

        while (currentPosition < position) {
            current = current.next;
            currentPosition++;
        }

        current.next = current.next.next;


    }

    public boolean contains(int data) {

        if (head.data == data) {
            return true;
        }

        Node current = head;

        while (Objects.nonNull(current.next)) {

            if (current.next.data == data) {
                return true;
            }

            current = current.next;

        }

        return false;

    }

    public void print() {

        Node current = head;

        while (Objects.nonNull(current)) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null\n");

    }

}
