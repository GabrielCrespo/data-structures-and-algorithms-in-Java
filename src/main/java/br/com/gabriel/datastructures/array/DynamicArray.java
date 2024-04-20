package br.com.gabriel.datastructures.array;

public class DynamicArray {

    private static final int DEFAULT_CAPACITY = 16;

    private int[] data;

    private int capacity;

    private int size;

    public DynamicArray() {
        data = new int[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public DynamicArray(int capacity) {
        data = new int[capacity];
        this.capacity = capacity;
    }

    public int get(int index) {
        validateArrayIndexOutOfBounds(index);
        return data[index];
    }

    public void set(int index, int value) {
        validateArrayIndexOutOfBounds(index);
        data[index] = value;
    }

    public void insert(int index, int value) {

        validateArrayIndexOutOfBounds(index);

        if (size == capacity) {
            resize();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;

    }

    public void delete(int index) {

        validateArrayIndexOutOfBounds(index);

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        if (index == size) {
            data[index] = 0;
        } else {
            data[index - 1] = 0;
        }

        size--;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(int value) {

        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return true;
            }

        }

        return false;
    }

    public void resize() {

        int[] newData = new int[capacity * 2];

        for (int i = 0; i < capacity; i++) {
            newData[i] = data[i];
        }

        data = newData;
        capacity *= 2;

    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    private void validateArrayIndexOutOfBounds(int index) {
        if(index < 0 || index > capacity) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

}
