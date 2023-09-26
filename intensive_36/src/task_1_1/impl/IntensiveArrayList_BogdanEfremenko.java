package task_1_1.impl;

import task_1_1.IntensiveList;

import java.util.Arrays;

public class IntensiveArrayList_BogdanEfremenko<E> implements IntensiveList<E> {
    private static final int SIZE_CAP = 10;

    /**
     * Initial array to store elements.
     */
    private Object[] elementaryList;

    /**
     * Number of elements the list contains.
     */
    private int listSize;

    /**
     * Constructor contains a list containing an initial number of elements equal 10.
     */
    public IntensiveArrayList_BogdanEfremenko() {
        this.elementaryList = new Object[SIZE_CAP];
        this.listSize = 0;
    }

    /**
     * Constructor an empty list with the specified initial capacity.
     *
     * @param listSize - the initial capacity of the list
     */
    public IntensiveArrayList_BogdanEfremenko(int listSize) {
        if (listSize <= 0) {
            throw new IllegalArgumentException("List size can`t be less 0");
        } else {
            elementaryList = (E[]) new Object[listSize];
            this.listSize = listSize;
        }
    }

    /**
     * Method returns the current size of the list.
     *
     * @return the current size of the list.
     */
    public int size() {
        return listSize;
    }

    /**
     * Method adds an element to the end of the list.
     *
     * @param element - the element to add.
     * @return true if the element was added successfully, false otherwise.
     */
    public boolean add(Object element) {
        if (listSize == elementaryList.length) {
            ensureCapacity();
        }
        int index = listSize++;
        elementaryList[index] = element;
        return true;
    }

    /**
     * Adds an element to the specified list position.
     *
     * @param index   - the index to which the element should be added.
     * @param element the element to add.
     */
    public void add(int index, Object element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (listSize == elementaryList.length) {
            ensureCapacity();
        }
        for (int i = listSize; i > index; i--) {
            elementaryList[i] = elementaryList[i - 1];
        }
        elementaryList[index] = element;
        listSize++;
    }

    /**
     * The method gets the element at the specified index.
     *
     * @param index - index of the element to get.
     * @return the element at the specified index.
     */
    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return (E) elementaryList[index];
    }

    /**
     * Replaces the element at the specified index with the new element and returns the old element.
     *
     * @param index   - index of the element to replace.
     * @param element - new element.
     */
    public void set(int index, Object element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        elementaryList[index] = element;
    }

    /**
     * Method removes the element at the specified index and returns the deleted element.
     *
     * @param index - index of the element to be removed.
     */
    public void remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        E removedElement = (E) elementaryList[index];
        for (int i = index; i < listSize - 1; i++) {
            elementaryList[i] = elementaryList[i + 1];
        }
        elementaryList[--listSize] = null;
    }

    /**
     * Method removes all elements from the list.
     */
    public void removeAll() {
        for (int i = 0; i < listSize; i++) {
            elementaryList[i] = null;
        }
        listSize = 0;
    }

    /**
     * Private method that doubles the length of a list.
     */
    private void ensureCapacity() {
        int newCapacity = elementaryList.length * 2;
        Object[] newElementaryList = new Object[newCapacity];
        System.arraycopy(elementaryList, 0, newElementaryList, 0, listSize);
        elementaryList = newElementaryList;
    }

    /**
     * Method displays all elements of the list to the console
     */
    public void display() {
        for (Object element : elementaryList) {
            System.out.println(element);
        }
    }

    /**
     * Modified toString method for outputting array to console
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementaryList, elementaryList.length));
    }

}
