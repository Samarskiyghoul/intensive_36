package task_1_2.imlp;

import task_1_1.IntensiveList;

public class IntensiveCollections_BogdanEfremenko {
    /**
     * Method sort list with using Comparable. Implemented Quicksort algorithm.
     *
     * @param list - sorting list
     * @return ready sorted list
     */
    public static <E extends Comparable<E>> IntensiveList<E> quickSort(IntensiveList<E> list) {
        if (list.size() <= 1) {
            return list;
        }
        sort(list, 0, list.size() - 1);
        return list;
    }

    /**
     * Private method realizing sorting
     *
     * @param list - sorting list
     * @param high - highest point
     * @param low  - lowest point
     */
    private static <E extends Comparable<E>> void sort(IntensiveList<E> list, int high, int low) {

        if (high > low) {
            return;
        }
        int i = high;
        int j = low;
        E pivot = list.get(high);

        while (i <= j) {
            while (list.get(i).compareTo(pivot) < 0) {
                i++;
            }
            while (list.get(j).compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(list, i, j);
                i++;
                j--;
            }
        }
        if (high < j) {
            sort(list, high, j);
        }
        else {
            sort(list, i, low);
        }
    }

    /**
     * Private method for rearranging list elements.
     *
     * @param list - list in which the elements will be rearranged
     * @param i    - index 1
     * @param j    - index 2
     */
    private static <E extends Comparable<E>> void swap(IntensiveList<E> list, int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}