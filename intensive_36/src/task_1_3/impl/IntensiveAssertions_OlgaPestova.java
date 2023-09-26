package task_1_3.impl;

import task_1_1.IntensiveList;

public class IntensiveAssertions_OlgaPestova {
    /**
     * The method checks if the list is sorted.
     *
     * @param list - list to check
     * @param <E>  - the type of elements in this list
     * @return true if this list sorted
     */
    public static <E extends Comparable<E>> boolean assertSort(IntensiveList<E> list) {
        if (list.size() <= 1) {
            return true;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
