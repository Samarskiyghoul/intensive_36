package task_1_1;

/**
 * Реализация интерфейса IntensiveList с использованием массива.
 * Класс представляет собой динамический массив, который хранит элементы различных типов.
 *
 * @param <E> - тип элементов в списке.
 */
public class IntensiveArrayList_EgorPrilepskiy<E> implements IntensiveList {

    private Object[] arrayData;
    private int capacity;
    private  int size = 0;

    /**
     * Конструктор без параметров, устанавливающий значение capacity по умолчанию
     */
    public IntensiveArrayList_EgorPrilepskiy() {
        capacity = 10;
        arrayData = new Object[capacity];
    }

    /**
     * Конструктор для создания объектов с другим значением capacity
     * @param capacity - значение capacity
     */
    public IntensiveArrayList_EgorPrilepskiy (int capacity) {
        this.capacity = capacity;
        arrayData = new Object[capacity];
    }

    /**
     * Метод изменения capacity
     * @param newCapacity - новое значение capacity
     */
    private void resizer (int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(arrayData,0, newArray,0, arrayData. length);
        arrayData = newArray;
        capacity = newArray.length;
    }

    /**
     * Метод, выбрасывающий исключение при попытке обратится к несуществующему индексу
     * @param index - несуществующий индекс
     */
    private void invalidIndex (int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * метод, возвращающий размер нашего списка
     * @return - размер списка
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * метод добавления объекта в конец списка и увеличивает capacity в полтора раза, если добавление элемента
     * вызовет превышение размера массива
     * @param o - объект, который необходимо добавить
     * @return - true (успешное добавление)
     */
    @Override
    public boolean add (Object o) {
        if (size == capacity) {
            resizer(capacity + capacity / 2);
        }
        arrayData[size++] = o;
        return true;
    }

    /**
     * метод добавления объекта в определенное место и увеличивает capacity в полтора раза, если добавление элемента
     * вызовет превышение размера массива
     * @param index - место, вв которое добавляется объект
     * @param element - объект, который необходимо добавить
     * @return - true (успешное добавление)
     */
    @Override
    public void add (int index, Object element) {
        invalidIndex(index);
        if (size == capacity)
            resizer(capacity + capacity / 2);
        System.arraycopy(arrayData,index,arrayData,index + 1,this.size++);
        arrayData[index] = element;
    }

    /**
     * Получение объекта по его позиции в списке
     * @param index - позиция объекта в списке
     * @return - объект на позиции index
     */
    @Override
    public Object get (int index) {
        invalidIndex(index);
        return arrayData[index];
    }

    /**
     * изменение объекта, который находится в определенном месте
     * @param index - место объекта в списке
     * @param element - новое значение объекта
     * @return - старое значение объекта
     */
    @Override
    public Object set (int index, Object element) {
        Object oldObj = arrayData[index];
        arrayData[index] = element;
        return oldObj;
    }

    /**
     * Удаляет элемент по его индексу
     * @param index - место элемента в списке
     * @return - удаленный объект
     */
    @Override
    public Object remove (int index) {
        invalidIndex(index);
        Object o = arrayData[index];
        System.arraycopy(arrayData,index + 1, arrayData, index, size--);
        return o;
    }

    /**
     * Удаляет все элементы из списка
     */
    @Override
    public void removeAll() {
        arrayData = new Object[capacity];
        size = 0;
    }
}
