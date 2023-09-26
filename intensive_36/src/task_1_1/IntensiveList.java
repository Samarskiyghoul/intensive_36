package task_1_1.impl.task_1_1;

import java.util.Comparator;

public interface IntensiveList<T> {

    T getItem(int index);
    int size();
    void addItem(T item);
    void update(int index, T item);
    void delete(int index);
    void increaseArray();
    void printArray();
    void sort(Comparator<? super T> c);
    void filterNulls();

}
