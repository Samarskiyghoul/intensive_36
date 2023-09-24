package task_1_1;

public class IntensiveArrayList_IvanSemenov<E extends Comparable<E>> implements IntensiveList<E> {
    private Object[] elementData;
    private int size;

    public IntensiveArrayList_IvanSemenov() {
        elementData = new Object[10];
    }

    /**
     * Медод возвращает значение переменной size, отражающее количество элементов в наборе данных.
     *
     * @return значение переменной size, тип int
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Метод добавляет новый элемент в набор данных. Добавление производится в конец.
     *
     * @param o - добавляемый элемент
     * @return - возвращает true при успешном добавлении
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

    /**
     * Метод добавляет элемент в набор данных по указанному индексу. Элемент, ранее находящийся по данному индексу, а
     * также все элементы с большим значением индекса, смещаются на одну ячейку,
     * и приобретают индекс newIndex = oldIndex + 1.
     *
     * @param index   - индекс массива, в который пытаемся добавить элемент
     * @param element - добавляемый элемент
     */
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

    /**
     * Метод для получения элемента по указанному индексу.
     *
     * @param index - индекс искомого элемента
     * @return - искомый элемент
     */
    @Override
    public Object get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    /**
     * Метод устанавливает новое значение элемента по указанному индексу. Проиходит перезапись ранее присутствовавшего
     * значения.
     *
     * @param index   - индекс перезаписываемого элемента массива,
     * @param element - новое значение элемента массива
     * @return - значение элемента массива, который был перезаписан
     */
    @Override
    public Object set(int index, Object element) {
        checkIndex(index);
        Object oldValue = elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    /**
     * Метод удаляет элемент с указанным индексом из набора данных.
     *
     * @param index - индекс удаляемого элемента
     * @return возвращаем удаленный из набора данных элемент
     */
    @Override
    public Object remove(int index) {
        checkIndex(index);
        Object oldValue = elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index);
        size--;
        return oldValue;
    }

    /**
     * Метод удаления всех элементов из набора данных.
     */
    @Override
    public void removeAll() {
        elementData = new Object[10];
        size = 0;
    }

    /**
     * Добавление всех элементов из переданного в качестве параметра IntensiveList list в текущий лист.
     *
     * @param list - IntensiveList, чьи элементы должны быть добавлены в текущий лист
     */
    @Override
    public void add(IntensiveList<E> list) {
        while ((list.size() + size) >= elementData.length) {
            grow();
        }
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    /**
     * Метод проверяет корректность индекса.
     *
     * @param index - проверяемый индекс
     */
    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }
    }

    /**
     * Метод возвращает размер нового массива, проводя проверку на переполнение.
     * Коэффициент роста принят за 2, однако возможна ситуация, когда следующий этап роста может превысить
     * вместимость переменной int. В этом случае будет возвращаться константа Integer.MAX_VALUE.
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
     * - создает новый массив вдвое большего размера,
     * - переписывает в него элементы из старого массива
     * - возвращает новый массив.
     */
    private void grow() {
        Object[] newElementData = new Object[minValue()];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        elementData = newElementData;
    }
}
