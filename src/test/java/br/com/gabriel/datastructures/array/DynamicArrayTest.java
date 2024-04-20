package br.com.gabriel.datastructures.array;

import br.com.gabriel.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicArrayTest {

    private DynamicArray dynamicArray;

    @BeforeEach
    void setup() {

        dynamicArray = new DynamicArray();

        for (int i = 0; i < dynamicArray.getCapacity() / 2; i++) {
            int value = Utils.getRandomInteger(1, 1000);
            dynamicArray.insert(i, value);
        }

    }

    @Test
    public void shouldGetTheElementSetInAGivenIndex() {

        int index = 2;
        int value = 10;

        dynamicArray.set(index, value);

        Assertions.assertEquals(value, dynamicArray.get(index));

    }

    @Test
    public void shouldInsertAValueInGivenIndex() {

        int index = 2;
        int value = 33;

        dynamicArray.insert(index, value);

        Assertions.assertEquals(value, dynamicArray.get(index));

    }

    @Test
    public void shouldThrowAnExceptionWhenInsertAIndexOutOfBounds() {

        int index = dynamicArray.getCapacity() + 1;
        int value = 10;

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            dynamicArray.insert(index, value);
        });

    }

    @Test
    public void shouldIncreaseTheSizeWhenInsertAValue() {

        int index = 2;
        int value = 19;

        int currentSize = dynamicArray.getSize();

        dynamicArray.insert(index, value);

        Assertions.assertEquals(currentSize + 1, dynamicArray.getSize());

    }

    @Test
    public void shouldDeleteAValueFromAGivenIndex() {

        int index = 2;

        int currentValueAtIndex = dynamicArray.get(index);

        dynamicArray.delete(index);

        Assertions.assertNotEquals(currentValueAtIndex, dynamicArray.get(index));

    }

    @Test
    public void shouldThrowAnExceptionWhenDeleteAIndexOutOfBounds() {

        int index = dynamicArray.getCapacity() + 1;

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            dynamicArray.delete(index);
        });

    }

    @Test
    public void shouldDecreaseTheSizeWhenInsertAValue() {

        int index = 2;

        int currentSize = dynamicArray.getSize();

        dynamicArray.delete(index);

        Assertions.assertEquals(currentSize - 1, dynamicArray.getSize());

    }

    @Test
    public void shouldValidateIfTheArrayIsEmpty() {
        Assertions.assertFalse(dynamicArray.isEmpty());
    }

    @Test
    public void shouldValidateIfTheArrayContainsAValue() {

        int index = Utils.getRandomInteger(1, dynamicArray.getSize());
        int value = dynamicArray.get(index);

        Assertions.assertTrue(dynamicArray.contains(value));
    }

}
