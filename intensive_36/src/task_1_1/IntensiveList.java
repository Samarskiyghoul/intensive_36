package task_1_1;

public interface IntensiveList<E> {
    int size();

    boolean add(E o);

    void add(int index, E element);

    E get(int index);

    void set(int index, E element);

    void remove(int index);

    void removeAll();

    void display();
}
