package br.com.gabriel.datastructures.linkedlist;

import br.com.gabriel.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    private LinkedList linkedList;

    @BeforeEach
    void setup() {
        linkedList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            int data = Utils.getRandomInteger(1, 10);
            linkedList.addLast(data);
        }
    }

    @Test
    public void shouldAddNodeInFirstPositionWhenHeadIsNull() {

        int data = Utils.getRandomInteger(1, 100);

        linkedList.clear();
        linkedList.addFirst(data);

        Assertions.assertEquals(data, linkedList.getFirst());

    }

    @Test
    public void shouldAddNodeInFirstPositionWhenHeadIsNotNull() {

        int data = Utils.getRandomInteger(1, 100);

        linkedList.addFirst(data);
        Assertions.assertEquals(data, linkedList.getFirst());

    }

    @Test
    public void getFirstShouldThrowsExceptionWhenListIsEmpty() {

        linkedList.clear();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.getFirst();
        });

    }

    @Test
    public void shouldAddNodeInLastPositionWhenHeadIsNull() {

        int data = Utils.getRandomInteger(1, 100);

        linkedList.clear();
        linkedList.addLast(data);

        Assertions.assertEquals(data, linkedList.getLast());

    }

    @Test
    public void shouldAddNodeInLastPositionWhenHeadNotIsNull() {

        int data = Utils.getRandomInteger(1, 100);

        linkedList.addLast(data);

        Assertions.assertEquals(data, linkedList.getLast());

    }

    @Test
    public void getLastShouldThrowExceptionWhenListIsEmpty() {

        linkedList.clear();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.getLast();
        });

    }

    @Test
    public void sizeShouldReturn0WhenListIsEmpty() {

        int expectedSize = 0;

        linkedList.clear();

        Assertions.assertEquals(expectedSize, linkedList.size());

    }

    @Test
    public void sizeShouldReturnTheSizeWhenListIsEmpty() {
        int size = linkedList.size();
        Assertions.assertTrue(size > 0);
    }

    @Test
    public void shouldClearTheList() {

        int expectedSize = 0;

        linkedList.clear();
        int currentSize = linkedList.size();

        Assertions.assertEquals(expectedSize, currentSize);

    }

    @Test
    public void clearShouldThrowsExceptionWhenListIsEmpty() {

        linkedList.clear();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.clear();
        });
    }

    @Test
    public void shouldAddNodeInAGivenPosition() {

        int data = Utils.getRandomInteger(1, 100);
        int position = Utils.getRandomInteger(0, linkedList.size());

        linkedList.add(position, data);

        Assertions.assertEquals(data, linkedList.get(position));

    }

    @Test
    public void addShouldThrowsExceptionWhenPositionIsLessThanZero() {

        int data = Utils.getRandomInteger(1, 100);
        int position = Utils.getRandomInteger(-100, 0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.add(position, data));

    }

    @Test
    public void addShouldThrowsExceptionWhenPositionIsGreaterThanSize() {

        int data = Utils.getRandomInteger(1, 100);
        int position = Utils.getRandomInteger(linkedList.size(), linkedList.size() * 2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.add(position, data));

    }

    @Test
    public void shouldAddInTheHeadWhenPositionIsZero() {

        int data = Utils.getRandomInteger(1, 100);
        int position = 0;

        linkedList.add(position, data);

        Assertions.assertEquals(data, linkedList.getFirst());

    }

    @Test
    public void shouldGetDataForTheGivenPosition() {

        int data = Utils.getRandomInteger(1, 100);
        int position = Utils.getRandomInteger(0, linkedList.size());

        linkedList.add(position, data);

        int returnedData = linkedList.get(position);

        Assertions.assertEquals(data, returnedData);

    }

    @Test
    public void shouldGetFirstDataWhenPositionIsZero() {

        int data = Utils.getRandomInteger(1, 100);
        int position = 0;

        linkedList.add(position, data);

        int returnedData = linkedList.get(position);

        Assertions.assertEquals(data, returnedData);

    }

    @Test
    public void getShouldThrowsAnExceptionWhenListIsEmpty() {

        int position = Utils.getRandomInteger(0, 100);

        linkedList.clear();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.get(position);
        });
    }

    @Test
    public void getShouldThrowsAnExceptionWhenPositionIsLessThanZero() {

        int position = Utils.getRandomInteger(-100, 0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            linkedList.get(position);
        });
    }

    @Test
    public void getShouldThrowsAnExceptionWhenPositionIsGreaterThanSize() {

        int position = Utils.getRandomInteger(linkedList.size(), linkedList.size() * 2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            linkedList.get(position);
        });
    }

    @Test
    public void shouldDeleteNodeIfNodeIsInTheHead() {

        int data = linkedList.getFirst();
        int expectedSize = linkedList.size() - 1;

        linkedList.delete(data);

        Assertions.assertEquals(expectedSize, linkedList.size());

    }

    @Test
    public void shouldDeleteNodeIfDataExists() {

        int position = Utils.getRandomInteger(0, linkedList.size());
        int data = linkedList.get(position);
        int expectedSize = linkedList.size() - 1;

        linkedList.delete(data);

        Assertions.assertEquals(expectedSize, linkedList.size());

    }

    @Test
    public void shouldNotDeleteNodeIfDataNotExists() {

        int data = Utils.getRandomInteger(11, 15);
        int expectedSize = linkedList.size();

        linkedList.delete(data);

        Assertions.assertEquals(expectedSize, linkedList.size());

    }

    @Test
    public void shouldDeleteNodeHeadWhenPositionIsZero() {

        int position = 0;
        int expectedSize = linkedList.size() - 1;

        linkedList.deleteByPosition(position);

        Assertions.assertEquals(expectedSize, linkedList.size());
    }

    @Test
    public void shouldDeleteInAnyPosition() {

        int position = Utils.getRandomInteger(0, linkedList.size());
        int expectedSize = linkedList.size() - 1;

        linkedList.deleteByPosition(position);

        Assertions.assertEquals(expectedSize, linkedList.size());

    }

    @Test
    public void shouldDeleteTheLastPosition() {

        int position = linkedList.size() - 1;
        int expectedSize = linkedList.size() - 1;

        linkedList.deleteByPosition(position);

        Assertions.assertEquals(expectedSize, linkedList.size());

    }

    @Test
    public void deleteByPositionShouldThrowAnExceptionWhenListIsEmpty() {

        int position = 1;

        linkedList.clear();

        Assertions.assertThrows(IllegalStateException.class, () -> linkedList.deleteByPosition(position));

    }

    @Test
    public void deleteByPositionShouldThrowExceptionWhenPositionIsLessThanZero() {

        int position = Utils.getRandomInteger(-10, 0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.deleteByPosition(position));

    }

    @Test
    public void deleteByPositionShouldThrowExceptionWhenPositionIsGreaterThanSize() {

        int size = linkedList.size();
        int position = Utils.getRandomInteger(size, size * 2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.deleteByPosition(position));

    }

    @Test
    public void shouldReturnTrueWhenListContainsDataInHead() {

        int data = linkedList.getFirst();

        Assertions.assertTrue(linkedList.contains(data));

    }

    @Test
    public void shouldReturnTruWhenListContainsData() {

        int position = Utils.getRandomInteger(0, linkedList.size());
        int data = linkedList.get(position);

        Assertions.assertTrue(linkedList.contains(data));

    }

    @Test
    public void shouldReturnFalseWhenListDoesNotContaisData() {

        int data = Utils.getRandomInteger(10, 15);

        Assertions.assertFalse(linkedList.contains(data));

    }
}
