package task_1_3.impl;

import task_1_1.IntensiveList;

public class IntensiveAssertions_BogdanEfremenko {

    /**
     * Method checks whether the specified list is sorted according to the natural order of its elements.
     *
     * @param list collection to check.
     * @return true if the collection is sorted in ascending order, otherwise returns false.
     */
    public static <E extends Comparable<E>> boolean assertSort(IntensiveList<E> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }
}