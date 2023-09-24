package task_1_1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *This class implements an interface IntensiveList
 * with methods for working with a dynamically expandable array.
 */
public class IntensiveListEmp_StephanDalla<E> implements IntensiveList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    private E[] list;

    public IntensiveListEmp_StephanDalla() {
        list = (E[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;

    }

    public IntensiveListEmp_StephanDalla(int capacity) {
        list = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    /**
     * This method returns the length of the list;
     *
     */
    @Override
    public int size() {
        return list.length;
    }

    // проверка заполненности массива;
    private void check_capacity() {
        if (size == capacity) {
            E[] old = list;
            capacity += 1;
            list = (E[]) new Object[capacity];
            System.arraycopy(old, 0, list, 0, size);
        }
    }

    /**
     * This method adds an element to the list at the end.
     * The capacity of the list is checked before adding.
     * @param e element to add.
     * @return true if element add.
     */
    @Override
    public boolean add(E e) {
        check_capacity();
        list[size++] = e;
        return true;

    }

    /**
     * This method adds an element by index.
     * The capacity of the list is checked before adding.
     * @param index - index by which the element will be added
     * @param element to add
     */
    @Override
    public void add(int index, E element) {
        check_capacity();
        //сдвиг в лево елементов массива от индекса на 1
        for (int i = size; index < i; i--) {
            list[i] = list[i - 1];
        }
        list[index] = element;
        size++;
    }

    /**
     * This method return element by index.
     * @param index - index which will be return
     *
     */
    @Override
    public E get(int index) {
        return list[index];
    }

    /**
     * This method set element by index.
     * @param index - index by which element will be changed
     * @param element - element which will be set
     *
     */
    @Override
    public void set(int index, E element) {
        list[index] = element;

    }

    /**
     * This method remove element by index. If size == 0, return false else True
     * @param index - index by which the element will be  removed.
     */
    @Override
    public boolean remove(int index) {
        if (size == 0) return false;
        E[] with_elem = list;
        list = (E[]) new Object[size - 1];
        System.arraycopy(with_elem, 0, list, 0, index);

        System.arraycopy(with_elem,
                index + 1,
                list,
                index,
                with_elem.length - index - 1); // оставшиеся элементы после первого копирования
        size--;
        return true;
        /*
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        size--;
        list[size] = null;*/


    }

    /**
     * This method remove all elements.
     */
    @Override
    public void removeAll() {
        //list = (E[]) new Object[capacity];
        Arrays.fill(list, null);
    }

    /**
     * This method show the elements of the list.
     */
    public void showList() {
        for (E element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * This method returns a private field storing an array of elements
     */
    public E[] getList() {
        return list;
    }

}
