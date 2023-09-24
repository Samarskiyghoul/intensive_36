package task_1_1.impl;

import org.example.task_1_1.IntensiveList;

/**
 *  @author anna ovcharuk
 * Класс, реализующий интерфейс IntensiveList.
 *
 * @param <E> тип элементов, которые будут храниться в списке.
 */
public class IntensiveArrayList_AnnaOvcharuk<E> implements IntensiveList<E> {
    private static final int SIZE_CAP = 10; // Задаем начальную емкость массива по умолчанию
    private Object[] elements; // Массив для хранения элементов
    private int size; // Текущий размер списка
    /**
     * Создает список с начальной емкостью по умолчанию.
     */
    public IntensiveArrayList_AnnaOvcharuk() {
        this.elements = new Object[SIZE_CAP]; // Инициализируем массив с начальной емкостью
        this.size = 0; // Устанавливаем размер списка в 0, так как изначально список пуст
    }
    /**
     * Возвращает текущий размер списка.
     *
     * @return текущий размер списка.
     */
    public int size() {
        return size; // Возвращает текущий размер списка
    }
    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления.
     * @return true, если элемент был успешно добавлен, в противном случае - false.
     */
    public boolean add(E element) {
        if (size == elements.length) {
            ensureCapacity(); // Если массив полностью заполнен, увеличиваем его размер
        }
        elements[size++] = element; // Добавляем элемент в конец списка и увеличиваем размер списка
        return true;
    }
    /**
     * Добавляет элемент в указанную позицию списка.
     *
     * @param index   индекс, в который следует добавить элемент.
     * @param element элемент для добавления.
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (size == elements.length) {
            ensureCapacity(); // Если массив полностью заполнен, увеличиваем его размер
        }
        // Сдвигаем элементы вправо, начиная с конца списка
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element; // Добавляем элемент на указанную позицию
        size++;
    }
    /**
     * Получает элемент по указанному индексу.
     *
     * @param index индекс элемента, который нужно получить.
     * @return элемент по указанному индексу.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return (E) elements[index];
    }
    /**
     * Заменяет элемент по указанному индексу новым элементом и возвращает старый элемент.
     *
     * @param index   индекс элемента, который нужно заменить.
     * @param element новый элемент.
     * @return старый элемент, который был заменен новым элементом.
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        E oldElement = (E) elements[index];
        elements[index] = element;
        return oldElement;
    }
    /**
     * Удаляет элемент по указанному индексу и возвращает удаленный элемент.
     *
     * @param index индекс элемента, который нужно удалить.
     * @return удаленный элемент.
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        E removedElement = (E) elements[index];
        // Сдвигаем элементы влево, чтобы закрыть пустую ячейку
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Уменьшаем размер и удаляем ссылку на последний элемент
        return removedElement;
    }
    /**
     * Удаляет все элементы из списка.
     */
    public void removeAll() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    private void ensureCapacity() {
        int newCapacity = elements.length * 2; // Увеличиваем размер вдвое
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size); // Копируем элементы в новый массив
        elements = newElements; // Переключаемся на новый массив
    }
}

