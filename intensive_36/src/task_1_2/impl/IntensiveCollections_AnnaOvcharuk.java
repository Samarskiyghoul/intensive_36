package task_1_2.impl;

import org.example.task_1_1.IntensiveList;
import org.example.task_1_1.impl.IntensiveArrayList_AnnaOvcharuk;

import java.util.Comparator;

/**
 * Класс IntensiveCollections_AnnaOvcharuk предоставляет статические методы для сортировки списка и массива.
 */
public class IntensiveCollections_AnnaOvcharuk {

    /**
     * Выполняет быструю сортировку списка в возрастающем порядке (по умолчанию).
     *
     * @param list Список, который требуется отсортировать.
     * @param <E>  Тип элементов списка, должен быть сравнимым (реализующим интерфейс Comparable).
     * @return Отсортированный список.
     */
    public static <E extends Comparable<E>> IntensiveList<E> quickSort(IntensiveList<E> list) {
        quickSortHelper(list, 0, list.size() - 1);
        return list;
    }

    /**
     * Вспомогательный метод для быстрой сортировки списка.
     *
     * @param list Список, который требуется отсортировать.
     * @param low  Индекс начального элемента в подсписке.
     * @param high Индекс конечного элемента в подсписке.
     * @param <E>  Тип элементов списка, должен быть сравнимым (реализующим интерфейс Comparable).
     */
    private static <E extends Comparable<E>> void quickSortHelper(IntensiveList<E> list, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(list, low, high);

            quickSortHelper(list, low, partitionIndex - 1);
            quickSortHelper(list, partitionIndex + 1, high);
        }
    }

    /**
     * Вспомогательный метод для разделения списка при быстрой сортировке.
     *
     * @param list Список, который требуется отсортировать.
     * @param low  Индекс начального элемента в подсписке.
     * @param high Индекс конечного элемента в подсписке.
     * @param <E>  Тип элементов списка, должен быть сравнимым (реализующим интерфейс Comparable).
     * @return Индекс опорного элемента после разделения.
     */
    private static <E extends Comparable<E>> int partition(IntensiveList<E> list, int low, int high) {
        E pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;

                E temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        E temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }

    /**
     * Сортирует список с использованием заданного компаратора.
     *
     * @param list       список, который требуется отсортировать.
     * @param comparator компаратор для сравнения элементов списка.
     * @param <E>        тип элементов списка.
     * @return отсортированный список.
     */
    public static <E> IntensiveList<E> sort(IntensiveList<E> list, Comparator<E> comparator) {
        Object[] array = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        java.util.Arrays.sort(array, (a, b) -> comparator.compare((E) a, (E) b));
        IntensiveList<E> sortedList = new IntensiveArrayList_AnnaOvcharuk<>();
        for (Object element : array) {
            sortedList.add((E) element);
        }
        return sortedList;
    }
}


