package task_1_1;

public class IntensiveArrayList_IvanSemenov<E> implements IntensiveList<E> {
    private Object[] elementData;
    private int size;

    public IntensiveArrayList_IvanSemenov() {
        elementData = new Object[10];
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Метод добавляет новый элемент в коллекцию
     *
     * @param o
     * @return
     */
    @Override
    public boolean add(Object o) {
        if (size >= elementData.length) {
            grow();
        }
        elementData[size] = o;
        size++;
        return true;
    }

    @Override
    public void add(int index, Object element) {
        checkIndex(index);
        if (size == elementData.length) {
            grow();
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    @Override
    public Object set(int index, Object element) {
        checkIndex(index);
        Object oldValue = elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        Object oldValue = elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index);
        size --;
        return oldValue;
    }

    @Override
    public void removeAll() {
        elementData = new Object[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }
    }
    /**
     * метод возвращает размер нового массива, проводя проверку на переполнение.
     * Коэффициент роста принят за 2, однако возможна ситуация, когда следующий этап роста может превысить
     * вместимость переменной int. В этом случае будет возвращаться константа Integer.MAX_VALUE
     *
     * @return - размер массива, до которого должен "вырасти" заполненный старый массив.
     */
    private int minValue() {
        if (this.elementData.length <= Integer.MAX_VALUE / 2) {
            return this.elementData.length * 2;
        } else {
            return Integer.MAX_VALUE;
        }
    }
    /**
     * Метод увеличивает размер размер массива вдвое:
     * создает новый массив вдвое большего размера,
     * переписывает в него элементы из старого массива
     * возвращает новый массив.
     */

    private void grow() {
        Object[] newElementData = new Object[minValue()];
        for (int i = 0; i < elementData.length; i++) {
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
    }
}
