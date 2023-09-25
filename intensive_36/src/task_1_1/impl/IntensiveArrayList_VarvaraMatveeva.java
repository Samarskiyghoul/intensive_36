package task_1_1.impl;

import task_1_1.IntensiveList;

/**
 * Реализация аналога ArrayList, не потокобезопасного.
 *
 * @param <E> тип элементов в списке
 */
public class IntensiveArrayList_VarvaraMatveeva<E> implements IntensiveList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    /**
     * Конструктор по умолчанию.
     */
    public IntensiveArrayList_VarvaraMatveeva() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Возвращает текущий размер списка.
     *
     * @return размер списка
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param o элемент для добавления
     * @return true, если элемент был успешно добавлен
     */
    @Override
    public boolean add(Object o) {
        addCapacity(size + 1);
        elements[size++] = o;
        return true;
    }

    /**
     * Добавляет элемент в указанную позицию списка.
     *
     * @param index   позиция, в которую нужно добавить элемент
     * @param element элемент для добавления
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        addCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента
     * @return элемент списка
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return elements[index];
    }

    /**
     * Заменяет элемент по указанному индексу новым элементом и возвращает старый элемент.
     *
     * @param index   индекс элемента, который нужно заменить
     * @param element новый элемент
     * @return старый элемент списка
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Object oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }


    /**
     * Удаляет элемент по указанному индексу и возвращает его.
     *
     * @param index индекс элемента, который нужно удалить
     * @return удаленный элемент списка
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Object removedElement = elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removedElement;
    }

    /**
     * Удаляет все элементы из списка, делая его пустым.
     */
    @Override
    public void removeAll() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Убеждается, что список имеет достаточную ёмкость для добавления элементов.
     *
     * @param minCapacity минимальная ёмкость, которую должен иметь список
     */
    private void addCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }
}
