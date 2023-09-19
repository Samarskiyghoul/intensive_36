package task_1_1.impl;

import task_1_1.IntensiveList;
/**
 * Реализация интерфейса IntensiveList с использованием массива.
 * Этот класс представляет собой динамический массив, способный хранить элементы различных типов.
 *
 * @param <E> Тип элементов, которые будут храниться в списке.
 */
public class IntensiveArrayList_ZhirayrAvanesyan<E> implements IntensiveList<E> {
    private Object[] arrayData;
    private int capacity;
    private  int size = 0;
    /**
     * Создает новый экземпляр IntensiveArrayList_ZhirayrAvanesyan с начальной емкостью 10 элементов.
     */
    public IntensiveArrayList_ZhirayrAvanesyan() {
        this.capacity = 10;
        arrayData = new Object[capacity];
    }
    /**
     * Создает новый экземпляр IntensiveArrayList_ZhirayrAvanesyan с указанной начальной емкостью.
     *
     * @param capacity Начальная емкость списка.
     */
    public IntensiveArrayList_ZhirayrAvanesyan(int capacity) {
        this.capacity = capacity;
        arrayData = new Object[capacity];
    }

    /**
     * @return Количество элементов в списке.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param o Элемент для добавления.
     * @return true, если элемент был успешно добавлен.
     */
    @Override
    public boolean add(Object o) {
        if(size == capacity)
            resize(capacity * 2 + 1);
        arrayData[size++] = o;
        return true;
    }

    /**
     * Вставляет элемент в список по указанному индексу.
     *
     * @param index   Индекс, по которому следует вставить элемент.
     * @param element Элемент для вставки.
     */
    @Override
    public void add(int index, Object element) {
       validateIndex(index);
        if(size == capacity)
            resize(capacity * 2 + 1);
        System.arraycopy(arrayData,index,arrayData,index + 1,this.size++);
        arrayData[index] = element;
    }

    /**
     * Получает элемент списка по указанному индексу.
     *
     * @param index Индекс элемента для получения.
     * @return Элемент списка.
     */
    @Override
    public Object get(int index) {
        validateIndex(index);
        return arrayData[index];
    }

    /**
     * Заменяет элемент в списке по указанному индексу новым элементом и возвращает старый элемент.
     *
     * @param index   Индекс элемента для замены.
     * @param element Новый элемент для замены.
     * @return Старый элемент, который был заменен.
     */
    @Override
    public Object set(int index, Object element) {
        Object oldElement = arrayData[index];
        arrayData[index] = element;
        return oldElement;
    }

    /**
     * Удаляет элемент из списка по указанному индексу и возвращает удаленный элемент.
     *
     * @param index Индекс элемента для удаления.
     * @return Удаленный элемент.
     */
    @Override
    public Object remove(int index) {
        validateIndex(index);
        Object removedObject = arrayData[index];
        System.arraycopy(arrayData,index + 1,arrayData,index,this.size--);
        return removedObject;
    }

    /**
     * Удаляет все элементы из списка, делая его пустым.
     */
    @Override
    public void removeAll() {
        this.arrayData = new Object[capacity];
        this.size = 0;
    }
    private void resize(int newCapacity){
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(arrayData,0,newArray,0,arrayData.length);
        arrayData = newArray;
        this.capacity = newArray.length;
    }
    private void validateIndex(int index){
        if(index < 0 || index > this.size)
            throw new IndexOutOfBoundsException("Illegal index");
    }
}
