package task_1_3.impl;

import task_1_1.IntensiveList;

import java.util.Comparator;

/**
 * Assertion of sort for IntensiveList Collection
 */
public class IntensiveAssertions_PavelSidorov {
    private static final String LIST_ERROR = "List is null";

    /**
     * Checks list is sorted or not by Comparable
     *
     * @param list Collection of IntensiveList
     * @param <E>  generic parameter
     * @return true if list is sorted
     */
    public static <E extends Comparable<E>> boolean assertSort(IntensiveList<E> list) {
        if (list != null) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (((E) list.get(i)).compareTo((E) list.get(i + 1)) > 0) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException(LIST_ERROR);
    }

    /**
     * Checks list is sorted or not by Comparator
     *
     * @param list       Collection of IntensiveList
     * @param comparator sorting comparator
     * @param <E>        generic parameter
     * @return true if list is sorted
     */
    public static <E> boolean assertSort(IntensiveList<E> list, Comparator<E> comparator) {
        if (list != null) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (comparator.compare((E) list.get(i), (E) list.get(i + 1)) > 0) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException(LIST_ERROR);
    }
}
