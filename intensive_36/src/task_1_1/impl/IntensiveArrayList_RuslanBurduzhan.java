package task_1_1.impl;

import task_1_1.IntensiveList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Класс представляет собой реализацию интерфейсов IntensiveList и Iterable.
 * Он предоставляет функциональность для работы с динамическим списком, основанном на внутреннем массиве.
 *
 * @param <E> класс объектов в коллекции.
 */
public class IntensiveArrayList_RuslanBurduzhan<E> implements IntensiveList<E>, Iterable<E> {
    /**
     * Количество элементов в коллекции.
     */
    private int size;
    /**
     * Размер внутреннего массива коллекции.
     */
    private int capacity;
    /**
     * Внутренний массив, на котором основана коллекция.
     */
    private E[] dataArray;

    public IntensiveArrayList_RuslanBurduzhan() {
        this.dataArray = (E[]) new Object[0];
    }

    public IntensiveArrayList_RuslanBurduzhan(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity < 0");
        }
        this.capacity = capacity;
        this.dataArray = (E[]) new Object[capacity];
    }

    /**
     * Возвращает количество элементов в коллекции.
     *
     * @return количество элементов в коллекции.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Добавляет указанный элемент в конец коллекции.
     *
     * @param o элемент, который будет добавлен в коллекцию.
     * @return true, если коллекция изменится в результате вызова.
     */
    @Override
    public boolean add(E o) {
        if (size == capacity) {
            resize();
        }
        dataArray[size++] = o;
        return true;
    }

    /**
     * Вставляет указанный элемент в указанную позицию коллекции.
     * Смещает элемент, находящийся в данный момент в этой позиции (если есть), и любые последующие элементы вправо.
     *
     * @param index   индекс, по которому должен быть вставлен указанный элемент.
     * @param element элемент, который нужно вставить.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона ( index < 0 || index > size ).
     */
    @Override
    public void add(int index, E element) {
        checkByIndexOutOfBoundsException(index, size);
        if (size == capacity) {
            resize();
        }
        System.arraycopy(dataArray, index, dataArray, index + 1, size - index);
        size++;
        dataArray[index] = element;
    }

    /**
     * Возвращает элемент в указанной позиции коллекции.
     *
     * @param index индекс возвращаемого элемента.
     * @return элемент в указанной позиции.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона ( index < 0 || index > size - 1 ).
     */
    @Override
    public E get(int index) {
        checkByIndexOutOfBoundsException(index, size - 1);
        return (E) dataArray[index];
    }

    /**
     * Заменяет элемент в указанной позиции коллекции указанным элементом.
     *
     * @param index   индекс элемента для замены.
     * @param element элемент, который будет сохранен в указанной позиции.
     * @return элемент ранее находившийся в указанной позиции.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона ( index < 0 || index > size - 1 ).
     */
    @Override
    public E set(int index, E element) {
        checkByIndexOutOfBoundsException(index, size - 1);
        E data = (E) dataArray[index];
        dataArray[index] = element;
        return data;
    }

    /**
     * Удаляет элемент в указанной позиции в коллекции. Сдвигает любые последующие элементы влево (вычитает единицу из их индексов).
     *
     * @param index индекс элемента, который нужно удалить.
     * @return элемент, который был удален из списка.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона ( index < 0 || index > size - 1 ).
     */
    @Override
    public E remove(int index) {
        checkByIndexOutOfBoundsException(index, size - 1);
        E data = (E) dataArray[index];
        if (size != 1) {
            System.arraycopy(dataArray, index + 1, dataArray, index, size - index - 1);
        }
        size--;
        return data;
    }

    /**
     * Очищает все элементы в коллекции.
     */
    @Override
    public void removeAll() {
        size = 0;
    }

    /**
     * Изменяет емкость массива, увеличивая ее в два раза или устанавливая в 1, если исходная емкость была нулевой.
     * Копирует существующие элементы в новый массив с обновленной емкостью.
     */
    private void resize() {
        capacity = capacity > 0 ? capacity * 2 : 1;
        E[] newDataArray = (E[]) new Object[capacity];
        System.arraycopy(dataArray, 0, newDataArray, 0, size);
        dataArray = newDataArray;
    }

    /**
     * Проверяет индекс на валидность и, если не проходит, выбрасывает IndexOutOfBoundsException
     *
     * @param index      индекс.
     * @param upperBound верхняя граница.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона ( index < 0 || index > upperBound ).
     */
    private void checkByIndexOutOfBoundsException(int index, int upperBound) {
        if (index < 0 || index > upperBound) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, size));
        }
    }

    /**
     * Возвращает строковое представление коллекции.
     *
     * @return строковое представление коллекции.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            E data = dataArray[i];
            if (data != null) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(data);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Создает объект Spliterator.
     *
     * @return Разделитель из итератора.
     */
    @Override
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(dataArray, 0, size, 0);
    }

    /**
     * Возвращает последовательность Stream этой коллекцией в качестве источника.
     *
     * @return Последовательный поток элементов этой коллекции.
     */
    @Override
    public Stream<E> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    /**
     * Возвращает итератор для элементов типа E.
     *
     * @return итератор для элементов типа E.
     */
    @Override
    public Iterator<E> iterator() {
        return new IntensiveArrayList_RuslanBurduzhanIterator();
    }

    /**
     * Итератор над коллекцией.
     */
    private class IntensiveArrayList_RuslanBurduzhanIterator implements Iterator<E> {
        private int currentIndex;

        public IntensiveArrayList_RuslanBurduzhanIterator() {
            currentIndex = 0;
        }

        /**
         * Проверяет, есть ли следующий элемент в последовательности данных.
         *
         * @return если элемент есть, то метод возвращает true, иначе возвращает false.
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        /**
         * Возвращает следующий элемент в итерации.
         *
         * @return следующий элемент в итерации.
         * @throws NoSuchElementException если в итерации больше нет элементов.
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return dataArray[currentIndex++];
        }
    }
}
