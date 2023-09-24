package task_1_3.impl;

import org.example.task_1_1.IntensiveList;

public class IntensiveAssertions_AnnaOvcharuk {
    /**
     * Проверяет, является ли список отсортированным в возрастающем порядке.
     *
     * @param list список, который требуется проверить на сортировку.
     * @param <E>  тип элементов списка, должен быть сравнимым (реализующим интерфейс Comparable).
     * @return true, если список отсортирован в возрастающем порядке, иначе false.
     */
    public static <E extends Comparable<E>> boolean assertSort(IntensiveList<E> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                return false; // Найден неотсортированный элемент, список не отсортирован.
            }
        }
        return true; // Все элементы прошли проверку на сортировку.
    }
}
