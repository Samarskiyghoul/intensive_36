package task_1_1.impl;

import task_1_1.IntensiveList;

/**
 * An object of this class is a mutable list that can store values of the specified type E (including all descendant
 * types).
 * <p/>
 * In fact, the values are stored in an internal dynamically expanding array. This gives a time efficiency of O(n) for
 * inserting or removing an element by its index, and O(1) for getting or updating an element by its index.
 *
 * @param <E> a type of elements that can be stored in this list (including their descendants)
 * @author  Aleksander Tsaregorodtsev
 * @since   1.0
 */
public class IntensiveArrayList_AlexanderTsaregorodtsev<E> implements IntensiveList<E> {

    /**
     * The maximum possible array size due to JVM and platform limitations.
     */
    private static final int ARRAY_MAX_SIZE = Integer.MAX_VALUE - 8;

    /**
     * If the current capacity of the internal array is greater than this value, then this capacity becomes equal to the
     * ARRAY_MAX_SIZE after the next expansion.
     */
    private static final int PRE_MAX_CAPACITY = ARRAY_MAX_SIZE / 3 * 2;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    private static final String EXCEEDING_MAX_SIZE_EXCEPTION =
            "This list cannot contain more than " + ARRAY_MAX_SIZE + " elements.";
    private static final String NEGATIVE_NUMBER_OF_ELEMENTS_EXCEPTION =
            "Expected non-negative number of elements to add. Received %d.";
    private static final String NEGATIVE_CAPACITY_EXCEPTION =
            "Expected non-negative initial capacity. Received %d.";
    private static final String NEGATIVE_INDEX_EXCEPTION =
            "Expected non-negative index. Received %d.";
    private static final String INDEX_GREATER_THAN_SIZE_EXCEPTION =
            "Expected index less than the list size %d. Received %d.";

    /**
     * The number of elements of this list available to the user, starting from 0 index.
     */
    private int size;

    /**
     * An internal array storing the elements of the list.
     */
    private Object[] elementData;


    /**
     * Creates a new IntensiveArrayList_AlexanderTsaregorodtsev instance with the default initial capacity of the
     * internal array.
     */
    public IntensiveArrayList_AlexanderTsaregorodtsev() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * Creates a new instance of the IntensiveArrayList_AlexanderTsaregorodtsev with the user defined initial capacity.
     * @throws IllegalArgumentException if the specified initialCapacity is less than 0 or greater than the internal
     *                                  array maximum possible value
     */
    public IntensiveArrayList_AlexanderTsaregorodtsev(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException(String.format(NEGATIVE_CAPACITY_EXCEPTION,
                    initialCapacity));
        }

        if (initialCapacity > ARRAY_MAX_SIZE) {
            throw new IllegalArgumentException(EXCEEDING_MAX_SIZE_EXCEPTION);
        }

        elementData = new Object[initialCapacity];
    }


    /**
     * Returns the current size of the list.
     * @return the current size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds a new element to the end of the list. The list size increases by 1.
     * @param o an element to add
     * @return true if no exception is thrown
     */
    @Override
    public boolean add(Object o) {
        ensureCapacity(1);
        elementData[size] = o;
        size++;
        return true;
    }

    /**
     * Adds a new element at the given index. The remaining elements are shifted to the right if necessary, so that no
     * element is overwritten. The list size increases by 1.
     * @param index an index at which to add a new element
     * @param element an element to add
     * @throws IndexOutOfBoundsException if the specified index is below 0 or greater than the size of the list
     */
    @Override
    public void add(int index, Object element) {
        if (index == size) {
            add(element);
            return;
        }
        checkIndex(index);
        ensureCapacity(1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    /**
     * Finds and returns the element stored in the list at the specified index.
     * @param index an index of the element of interest
     * @return the element stored in the list at the specified index
     * @throws IndexOutOfBoundsException    if the specified index is below 0 or equal to or greater than the size of
     *                                      the list
     */
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    /**
     * Updates the value of the element at the specified index.
     * @param index an index of the element to update
     * @param element a new value of the element
     * @return the previous value of the element at the specified index
     * @throws IndexOutOfBoundsException    if the specified index is below 0 or equal to or greater than the size of
     *                                      the list
     */
    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }


    /**
     * Removes the element at the specified index from the list. The remaining elements are shifted to the left if
     * necessary, taking the place of the removed element. The list size decreases by 1.
     * @param index an index of the element to remove
     * @return the value of the removed element
     * @throws IndexOutOfBoundsException    if the specified index is below 0 or equal to or greater than the size of
     *                                      the list
     */
    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);
        Object elementToRemove = elementData[index];
        size--;
        System.arraycopy(elementData, index + 1, elementData, index, size - index);
        return (E) elementToRemove;
    }

    /**
     * Removes all the elements from the list. The list size becomes 0.
     */
    @Override
    public void removeAll() {
        size = 0;
    }

    /**
     * Checks that the internal array has enough capacity to add numberOfElementsToAdd elements. Otherwise, creates a
     * new array that can hold (size + numberOfElementsToAdd) elements, or approximately 1.5 times the old array's
     * capacity if that number is less than (size + numberOfElementsToAdd), or ARRAY_MAX_SIZE if the internal array's
     * capacity would otherwise exceed the possible max value. Copies the values of the old internal array to the new
     * one, if necessary.
     * @param numberOfElementsToAdd the number of elements to add to the list
     * @throws IllegalArgumentException if the specified numberOfElementsToAdd is less than 0. if the specified number
     *                                  of elements to add is less than zero. If the code is written correctly, this
     *                                  exception must never be thrown
     * @throws OutOfMemoryError if after adding the new elements the size of the internal array exceeds the maximum
     *                          possible value
     */
    @SuppressWarnings("SameParameterValue")
    private void ensureCapacity(int numberOfElementsToAdd) {
        if (numberOfElementsToAdd < 0) {
            throw new IllegalArgumentException(String.format(NEGATIVE_NUMBER_OF_ELEMENTS_EXCEPTION,
                    numberOfElementsToAdd));
        }

        if (ARRAY_MAX_SIZE - size < numberOfElementsToAdd) {
            throw new OutOfMemoryError(EXCEEDING_MAX_SIZE_EXCEPTION);
        }

        int newCapacity;

        if (elementData.length >= PRE_MAX_CAPACITY) {
            newCapacity = ARRAY_MAX_SIZE;
        } else {
            newCapacity = Math.max(size + numberOfElementsToAdd, elementData.length + elementData.length >> 2);
        }

        Object[] oldElementData = elementData;
        elementData = new Object[newCapacity];
        System.arraycopy(oldElementData, 0, elementData, 0, size);
    }

    /**
     * Checks that the index is within the bounds of the list size.
     * @param index an index to check
     * @throws IndexOutOfBoundsException    if the specified index is below 0 or equal to or greater than the size of
     *                                      the list
     */
    private void checkIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format(NEGATIVE_INDEX_EXCEPTION, index));
        }

        if (index >= size) {
            throw new IndexOutOfBoundsException(String.format(INDEX_GREATER_THAN_SIZE_EXCEPTION, size, index));
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            sb.append(elementData[i]).append(", ");
        }

        if (size >= 1) {
            sb.append(elementData[size - 1]);
        }

        sb.append("}");

        return sb.toString();
    }
}
