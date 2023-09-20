package task_1_1;

public interface IntensiveList<E> {

    int size();

    boolean add(E o);

    void add(int index, E element);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    void removeAll();
}
