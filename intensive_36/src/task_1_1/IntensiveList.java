package task_1_1;

public interface IntensiveList<E> {

    int size();

    boolean add(Object o);

    void add(int index, Object element);

    E get(int index);

    E set(int index, Object element);

    E remove(int index);

    void removeAll();
}
