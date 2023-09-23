package task_1_1.impl;

import task_1_1.IntensiveList;

import java.util.Arrays;
import java.util.Objects;

/**
 * Custom ArrayList Implementation
 *
 * @param <E> Generic parameter.
 * @author Pavel Sidorov
 */
public class IntensiveArrayList_PavelSidorov<E> implements IntensiveList<E> {
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Ratio is the coefficient for increasing array's capacity.
     */
    private static final int CAPACITY_RATIO = 2;
    /**
     * User's initial capacity.
     */
    private int initialCapacity;
    /**
     * Current array's capacity.
     */
    private int capacity;
    /**
     * Current array's size of elements.
     */
    private int size;
    /**
     * The main elements storage of this data structure.
     */
    private E[] data;

    /**
     * Constructs an empty list with the default initial capacity
     */
    public IntensiveArrayList_PavelSidorov() {
        defaultData(initialCapacity);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity - the initial capacity of the list
     */
    public IntensiveArrayList_PavelSidorov(int initialCapacity) {
        defaultData(initialCapacity);
    }

    /**
     * Returns current size of array.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds an element to the end of array.
     *
     * @param element for adding.
     * @return true on success.
     */
    @Override
    public boolean add(E element) {
        data[size++] = element;
        newCapacity();
        return true;
    }

    /**
     * Adds an element to the specific index and shifts elements to the right.
     *
     * @param index   index to adding at.
     * @param element for adding.
     */
    @Override
    public void add(int index, E element) {
        checkRange(index);
        System.arraycopy(data, index, data, index + 1, (size++) - index);
        data[index] = element;
        newCapacity();
    }

    /**
     * Returns the element at specific index.
     *
     * @param index index to getting element from.
     * @return the element at the specified position.
     */
    @Override
    public E get(int index) {
        checkRange(index);
        return data[index];
    }

    /**
     * Replaces an element at the specified position.
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @return the element previously at the specified position.
     */
    @Override
    public E set(int index, E element) {
        checkRange(index);
        E removedElement = data[index];
        data[index] = element;
        return removedElement;
    }

    /**
     * Removes the element at the specified position and shifts elements to the left.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed.
     */
    @Override
    public E remove(int index) {
        checkRange(index);
        E removedElement = data[index];
        System.arraycopy(data, index + 1, data, index, (size--) - index);
        return removedElement;
    }

    /**
     * Removes all elements and sets all data to defaults values.
     */
    @Override
    public void removeAll() {
        defaultData(initialCapacity);
    }

    /**
     * Sets defaults values for new instance of the list.
     *
     * @param initialCapacity initial capacity of list.
     */
    private void defaultData(int initialCapacity) {
        if (initialCapacity > 0) {
            this.initialCapacity = initialCapacity;
            data = (E[]) new Object[initialCapacity];
            capacity = initialCapacity;

        } else if (initialCapacity == 0) {
            this.initialCapacity = DEFAULT_CAPACITY;
            data = (E[]) new Object[DEFAULT_CAPACITY];
            capacity = DEFAULT_CAPACITY;

        } else {
            throw new IllegalArgumentException("Capacity must be positive but it's: " + initialCapacity);

        }

        size = 0;
    }

    /**
     * Increases the capacity when it's getting to threshold value.
     */
    private void newCapacity() {
        if (size == data.length) {
            capacity = capacity * CAPACITY_RATIO;
            data = Arrays.copyOf(data, capacity);
        }
    }

    /**
     * Checks index to be inside of array range.
     *
     * @param index specified index.
     */
    private void checkRange(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Index: " + index + " is out of array size bounds");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntensiveArrayList_PavelSidorov<?> that = (IntensiveArrayList_PavelSidorov<?>) o;
        return capacity == that.capacity && size == that.size && Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(capacity, size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "IntensiveArrayList_PavelSidorov{" +
                "capacity=" + capacity +
                ", size=" + size +
                ", data=" + Arrays.toString(data) +
                '}';
    }

}
