package task_1_1.impl;

import task_1_1.IntensiveList;

public class IntensiveArrayList_IlyaEgorov<Type> implements IntensiveList<Type> {

    // Начальная вместимость массива при использовании конструктора по умолчанию
    private final int DEFAULT_INITIAL_CAPACITY = 10;
    // Сам массив элементов
    private Type[] array;
    // Текущий размер листа
    private int size;

    // Конструктор без параметров
    public IntensiveArrayList_IlyaEgorov() {
        array = (Type[]) new Object[DEFAULT_INITIAL_CAPACITY];
        size = 0;
    }

    // Конструктор с заданной начальной величиной листа
    public IntensiveArrayList_IlyaEgorov(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new NegativeArraySizeException("Capacity cannot be under 0");
        }
        else {
            array = (Type[]) new Object[initialCapacity];
            size = 0;
        }
    }

    // Метод возвращающий текущий размер листа
    @Override
    public int size() {
        return size;
    }

    // Метод добавляет элемент в конец листа, если добавлено, то возвращает тру
    @Override
    public boolean add(Object o) {
        try {
            checkCapacity();
            Type item = (Type) o;
            array[size] = item;
            size++;
            return true;
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    // Добавляет элемент по индексу на указанную позицию, если такая есть. Смещает все остальные элементы вправо
    @Override
    public void add(int index, Object element) {
        if(index <= size) {
            checkCapacity();
            for(int i = size; i > index; i--) {
                array[i] = array[i-1];
            }
            array[index] = (Type) element;
            size++;
        }
        else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Возвращает элемент по его индексу
    @Override
    public Type get(int index) {
        if(index < size) {
            return array[index];
        }
        else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Замена элемента
    @Override
    public Type set(int index, Object element) {
        if(index < size) {
            array[index] = (Type) element;
            return (Type) array[index];
        }
        else if(index == size) {
            checkCapacity();
            this.add(element);
            return (Type) array[index];
        }
        else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Удаляет объект из списка
    @Override
    public Type remove(int index) {
        if(index < size) {
            Type removed = array[index];
            for(int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            size--;
            return removed;
        }
        else {
            return null;
        }
    }

    // Удаляет все объекты коллекции
    @Override
    public void removeAll() {
        for (int i = (size - 1); i >= 0; i--) {
            this.remove(i);
        }
    }

    // Метод проверки вместимости
    private void checkCapacity() {
        if(array.length == size) {
            // Создаем временный массив
            Type[] temp = (Type[]) new Object[size];
            // Переписываем в него значения из текущего
            temp = (Type[]) array;
            // Создаем массив новой бОльшей вместимости
            array = (Type[]) new Object[size * 2];
            // Переписываем в новым массив значения из временного
            for (int i = 0; i < temp.length; i++) {
                array[i] = temp[i];
            }
        }
    }

    // Метод для отображения листа
    public void display() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(this.get(i) + ", ");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }
}