package task_1_1.impl;

import task_1_1.IntensiveList;

/**
 * Реализация интерфейса IntensiveList.
 * @param <E> Тип элементов, которые будут храниться в списке.
 * @author Tsarev Sergei
 */

public class IntensiveArrayList_SergeiTsarev <E> implements IntensiveList<E>{

    /**
     * Стандартный размер массива
     */
    private static int DEFAULT_CAPACITY = 10;
    /**
     * Вместимость списка
     */
    private int capacity;
    /**
     * Массив данных
     */
    private E[] arr;
    /**
     * Колличество элементов в массиве
     */
    private int size;

    /**
     * Конструктор по умолчанию.
     */
    public IntensiveArrayList_SergeiTsarev(){
        this.capacity = DEFAULT_CAPACITY;
        this.arr = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Конструктор в параметром, задающим размер списка
     * @param capacity размер списка
     */
    public IntensiveArrayList_SergeiTsarev(int capacity){
        if(capacity >= 0){
            this.capacity = capacity;
            this.arr = (E[]) new Object[capacity];
            this.size = 0;
        }
        else{
            throw new IllegalArgumentException("Illegal capacity : " + capacity);
        }
    }

    /**
     * Возвращает текущий размер списка.
     * @return размер списка
     */
    @Override
    public int size(){
        return arr.length;
    }

    /**
     * Проверяет заполненность списка
     * Если нет свободных ячеек, повышает вместимость
     */
    private void checkCapacity(){
        if(size == capacity){
            int newCapacity = (capacity*3) / 2 + 1;
            capacity = newCapacity;
            E[] newArray = (E[]) new Object[newCapacity];
            System.arraycopy(arr, 0, newArray, 0, arr.length);
            arr = newArray;
        }
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param o элемент для добавления
     * @return true, если элемент был успешно добавлен
     */
    @Override
    public boolean add(E o){
        checkCapacity();
        arr[size++] = o;
        return true;
    }

    private void checkIndex(int index){
        if(index < 0 || index > this.size)
            throw new IndexOutOfBoundsException("Illegal index");
    }

    /**
     * Добавляет элемент в список по индексу
     * Проверяет список на наличие свободных индексов
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element){
        checkIndex(index);
        checkCapacity();
        System.arraycopy(arr, index, arr, index + 1, this.size++);
        arr[index] = element;
    }

    /**
     * Возвращает элемент из списка с индексом index
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        return arr[index];
    }

    /**
     * Задает значение элемента в списке по индексу
     * Возвращает значение, которое было до этого
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E old = arr[index];
        arr[index] = element;
        return old;
    }

    /**
     * Удаляет элемент по индексу, возвращает его значение
     * @param index
     * @return
     */
    @Override
    public E remove(int index){
        checkIndex(index);
        E removedObject = (E) arr[index];
        System.arraycopy(arr, index + 1, arr, index, this.size--);
        return  removedObject;
    }

    /**
     * Удаляет все элементы
     */
    @Override
    public void removeAll(){
        this.arr = (E[]) new Object[capacity];
        this.size = 0;
    }
}
