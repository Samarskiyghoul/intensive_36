package task_1_1.impl;

import task_1_1.IntensiveList;

import java.util.Arrays;
import java.util.Objects;


public class IntensiveArrayList_AntonTeslia<E> implements IntensiveList<E> {
    private int size;
    Object[] elementData;

    public IntensiveArrayList_AntonTeslia() {
        elementData = (E[]) new Object[10];
    }

    public IntensiveArrayList_AntonTeslia(int capacity) {
        if (capacity > 0) {
            elementData = (E[]) new Object[capacity];
        } else {
            throw new IllegalArgumentException("the value must be greater than 0");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E o) {
        if (size + 1 > elementData.length) {
            Object[] oldElementData = elementData;
            elementData = (E[]) new Object[(size * 3) / 2 + 1];
            System.arraycopy(oldElementData, 0, elementData, 0, size);
            elementData[size] = o;
            size++;
            return true;
        }
        elementData[size] = o;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (size + 1 > elementData.length) {
            Object[] oldElementData = elementData;
            elementData = (E[]) new Object[(size * 3) / 2 + 1];
            System.arraycopy(oldElementData, 0, elementData, 0, size);
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
            elementData[index] = element;
            size++;
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[size - 1] = null;
        size--;
        return oldValue;
    }

    @Override
    public void removeAll() {
        elementData = (E[]) new Object[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > elementData.length - 1) {
            throw new IllegalArgumentException("wrong index: " + index);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntensiveArrayList_AntonTeslia<?> that = (IntensiveArrayList_AntonTeslia<?>) o;
        return size == that.size && Arrays.equals(elementData, that.elementData);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elementData);
        return result;
    }
}
