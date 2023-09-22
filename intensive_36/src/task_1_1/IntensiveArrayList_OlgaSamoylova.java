package task_1_1;


/**
 * Реализация IntensiveArrayList
 * @author Olga Samoylova
 */

public class IntensiveArrayList_OlgaSamoylova implements IntensiveList{
    Object[] intensiveArrayList;
    int length;
    int size;


    public IntensiveArrayList_OlgaSamoylova (){
        intensiveArrayList = new Object[10];
        length = 10;
        size = 0;
    }

    public IntensiveArrayList_OlgaSamoylova (int length){
        intensiveArrayList = new Object[length];
        this.length = length;
        size = 0;
    }

    /**
     * Количество элементов в IntensiveArrayList
     * @return целое число равное количеству элементов в листе
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Добавление элемента в конец IntensiveArrayList
     * @return true если элемент добавлен
     */
    @Override
    public boolean add(Object o) {
        if (intensiveArrayList[length-1] != null){
            extendArray();
        }
        intensiveArrayList[size()] = o;
        size = size + 1;
        return true;
    }

    /**
     * Добавление элемента по заданному индексу
     */
    @Override
    public void add(int index, Object element) {

        if (intensiveArrayList[length-1] != null){
            extendArray();
        }
        if (index >= 0 && index < size()){
            for (int k = size(); k>index; k--){
                intensiveArrayList[k] = intensiveArrayList[k-1];
            }
            intensiveArrayList[index] = element;
            size = size + 1;
        }
        else if (index == size()){
            intensiveArrayList[index] = element;
            size = size + 1;
        }
        else{
            System.out.println("Index is not correct");
        }
    }

    /**
     * Получение элемента по индексу
     * @return значение элемента, если индекс корректен; null если индекс не корректен
     */
    @Override
    public Object get(int index) {
        if (index >= 0 && index < size){
            return intensiveArrayList[index];
        }
        else{
            System.out.println("Index is not correct");
            return null;
        }
    }

    /**
     * Изменение значения элемента в листе
     * @return новое значение измененного элемента; null если не корректный индекс
     */
    @Override
    public Object set(int index, Object element) {
        if (index >= 0 && index < size){
            intensiveArrayList[index] = element;
            return element;
        }
        else if (index == size){
            if (index == length){
                extendArray();
            }
            intensiveArrayList[index] = element;
            return element;
        }
        else{
            System.out.println("Index is not correct");
            return null;
        }
    }

    /**
     * Удаление элемента по индексу
     * @return значение удаленного элемента; null если индекс не корректен
     */
    @Override
    public Object remove(int index) {
        if (index >= 0 && index < size){
            Object removeObject = intensiveArrayList[index];
            for (int i = index; i<size()-1; i++){
                intensiveArrayList[i] = intensiveArrayList[i+1];
            }
            intensiveArrayList[size-1] = null;
            size = size-1;
            return removeObject;
        }
        else {
            System.out.println("Index is not correct");
            return null;
        }
    }

    /**
     * Удаление всех элементов
     */
    @Override
    public void removeAll() {
        intensiveArrayList = new Object[length];
        size = 0;
    }

    @Override
    public String toString(){
        String st = new String();
        for (int i = 0; i < size-1; i++){
            st = st + intensiveArrayList[i] + ", ";
        }
        st = st + intensiveArrayList[size-1];
        return st;
    }

    /**
     * Проверка массива на наличие свободных ячеек
     */
    private void extendArray(){
        Object[] extendedArray = new Object[2*length];
        for(int i = 0; i<length; i++){
            extendedArray[i] = intensiveArrayList[i];
        }
        length = 2*length;
        intensiveArrayList = extendedArray;
    }

}
