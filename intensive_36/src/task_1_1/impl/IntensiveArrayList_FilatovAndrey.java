package task_1_1.impl;

import task_1_1.IntensiveList;

import java.util.Arrays;

/**
 * Динамически расширяемый список реализующий интерфейс {@code IntensiveList}
 * @param <E> тип элемента в этом списке
 *
 * @see IntensiveList
 * @author Filatov Andrey
 *
 */
public class IntensiveArrayList_FilatovAndrey<E> implements IntensiveList<E> {

    /**
     * Стандартный размер массива
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Структура хранящая элементы списка
     */
    private Object[] arr;

    /**
     * Вместимость списка
     */
    private int capacity;

    /**
     * Количество элементов в списке
     */
    private int nElems;

    /**
     * Конструктор класса без параметров
     * <p>Создает пустой список со стандартным размером</p>
     */
    public IntensiveArrayList_FilatovAndrey() {
        this.capacity = DEFAULT_CAPACITY;
        this.arr = new Object[DEFAULT_CAPACITY];
        this.nElems = 0;
    }

    /**
     * Конструктор класса с параметром
     * <p>Создает пустой список с размером capacity</p>
     * @param capacity размер списка
     * @throws IllegalArgumentException если {@code capacity < 0}
     */
    public IntensiveArrayList_FilatovAndrey(int capacity) {
        if (capacity >= 0) {
            this.capacity = capacity;
            this.arr = new Object[capacity];
            this.nElems = 0;
        } else {
            throw new IllegalArgumentException("Размер должен быть больше нуля" + " \n Capacity = " + capacity);
        }
    }

    /**
     * Количество элементов в этом списке
     * @return количество элементов в этом списке
     */
    @Override
    public int size() {
        return nElems;
    }

    /**
     * Добавляет элемент в список
     * <p>Увеличивает количество элементов в этом списке</p>
     * @param o добавляемый элемент
     * @return {@code true} (как определено в {@link java.util.Collection#add})
     */
    @Override
    public boolean add(Object o) {
        checkCapacity();
        arr[nElems] = o;
        nElems++;
        return true;
    }

    /**
     * Добавляет элемент в список на определенную позицию в списке
     * <p>Увеличивает количество элементов в этом списке</p>
     * <p>Сдвигает остальные элементы вправо от нового</p>
     * @param index позиция добавляемого элемента
     * @param element добавляемый элемент
     * @see IntensiveArrayList_FilatovAndrey#checkIndexBounds
     */
    @Override
    public void add(int index, Object element) {
        checkCapacity();
        checkIndexBounds(index);
        if (index == nElems) {
            arr[index] = element;
            nElems++;
        }
        for (int i = nElems; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        nElems++;
    }

    /**
     * Возвращает элемент из списка на определённой позиции
     * @param index позиция элемента
     * @return элемент списка на позиции {@code index}
     * @see IntensiveArrayList_FilatovAndrey#checkIndexBounds
     */
    @Override
    public Object get(int index) {
        checkIndexBounds(index);
        return arr[index];
    }

    /**
     * Заменяет элемент на определённой позиции
     * @param index позиция элемента
     * @param element добавляемый элемент
     * @return заменённый элемент
     * @see IntensiveArrayList_FilatovAndrey#checkIndexBounds
     */
    @Override
    public Object set(int index, Object element) {
        checkIndexBounds(index);
        Object old = arr[index];
        arr[index] = element;
        return old;
    }

    /**
     * Удаляет элемент на определённой позиции
     * <p>Сдвигает элементы влево после удаления</p>
     * <p>Уменьшает количество элементов в списке</p>
     * @param index индекс удаляемого элемента
     * @return удалённый элемент
     */
    @Override
    public Object remove(int index) {
        checkIndexBounds(index);
        Object removed = arr[index];
        nElems--;
        for (int i = index; i < nElems; i++) {
            arr[i] = arr[i + 1];
        }
        return removed;
    }

    /**
     * Очищает список от элементов
     * <p>Устанавливает стандартный размер списка</p>
     * @see IntensiveArrayList_FilatovAndrey#DEFAULT_CAPACITY
     */
    @Override
    public void removeAll() {
        this.arr = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.nElems = 0;
    }

    /**
     * Проверяет если индекс выходит за границы
     * <p>Считается что индекс выходит за границы в следующих случаях:</p>
     * <ul>
     *     <li>{@code index < 0}</li>
     *     <li>{@code index > nElems}</li>
     * </ul>
     * @param index проверяемый индекс
     * @throws IllegalArgumentException если индекс выходит за границы
     */
    private void checkIndexBounds(int index) {
        if (index < 0 || index > nElems)
            throw new IllegalArgumentException("Индекс выходит за границы массива ");
    }

    private void grow() {
        this.capacity += 10;
        Object[] newArr = new Object[capacity];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    private void checkCapacity() {
        if (nElems == capacity) grow();
    }

    @SafeVarargs
    public static <E extends Comparable<E>> IntensiveArrayList_FilatovAndrey<E> of(E... data) {
        IntensiveArrayList_FilatovAndrey<E> list = new IntensiveArrayList_FilatovAndrey<>();
        for (E datum : data) {
            list.add(datum);
        }
        return list;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof IntensiveArrayList_FilatovAndrey<?> that)) return false;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }
}

