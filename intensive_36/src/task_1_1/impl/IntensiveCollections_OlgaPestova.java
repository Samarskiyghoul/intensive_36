package task_1_1.impl;

import task_1_1.IntensiveList;

/**
 * Resizable-array implementation of the IntensiveList interface.
 * This class is unsynchronized.
 *
 * @param <T> - the type of elements in this list
 */
public class IntensiveCollections_OlgaPestova<T> implements IntensiveList<T> {
    /**
     * Buffer into which the elements.
     */
    private T[] values;
    /**
     * The number of elements in list.
     */
    private int size = 0;
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public IntensiveCollections_OlgaPestova() {
        values = (T[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param capacity - the initial capacity of the list
     */
    public IntensiveCollections_OlgaPestova(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else {
            values = (T[]) new Object[capacity];
            this.capacity = capacity;
        }
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element – element to be appended
     * @return true
     */
    @Override
    public boolean add(T element) {
        checkAndResizeCapacity();
        values[size] = element;
        size++;
        return true;
    }

    /**
     * Appends the element at the specified position in this list.
     *
     * @param index   - position to be appended
     * @param element – element to be appended
     * Throws: IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public void add(int index, T element) {
        checkIndex(index);
        checkAndResizeCapacity();
        System.arraycopy(values,index,values,index+1,size-index);
        values[index] = element;
        size++;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return values[index];
    }

    /**
     * Replaces the element at the specified position in this list.
     *
     * @param index   - position to be replaces
     * @param element – element to be replaces
     * Throws: IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public T set(int index, T element) {
        checkIndex(index);
        T oldValue = values[index];
        values[index] = element;
        return oldValue;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left.
     *
     * @param index - the index of the element to be removed
     * @return the element that was removed from the list
     * Throws: IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public T remove(int index) {
        checkIndex(index);
        T removeValue = values[index];
        System.arraycopy(values, index + 1, values, index, size - index - 1);
        size--;
        return removeValue;
    }

    /**
     * Removes all the elements from this list.
     */
    @Override
    public void removeAll() {
        values = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * Checking the correctness of the entered index.
     *
     * @param index - index to be checked
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index value: " + index);
        }
    }

    /**
     * Checking capacity and increasing capacity of this list.
     */
    private void checkAndResizeCapacity() {
        if (size == capacity) {
            this.capacity = capacity * 2;
            T[] newValues = (T[]) new Object[capacity];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
    }

    @Override
    public String toString() {
        int iMax = size - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; ; i++) {
            sb.append(values[i]);
            if (i == iMax)
                return sb.append(']').toString();
            sb.append(", ");
        }
    }
}
