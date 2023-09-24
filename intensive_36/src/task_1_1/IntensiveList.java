package task_1_1;

public interface IntensiveList<E extends Comparable<E>> {

    int size();

    boolean add(Object o);

    void add(int index, Object element);

    Object get(int index);

    Object set(int index, Object element);

    Object remove(int index);

    void removeAll();

    void add (IntensiveList<E> list);
}
