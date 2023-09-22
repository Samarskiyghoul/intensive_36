package task_1_2.impl;

import task_1_1.IntensiveList;
import task_1_1.impl.IntensiveArrayList_PavelSidorov;

import java.util.Comparator;

/**
 * IntensiveCollections utils.
 *
 * @author Pavel Sidorov
 */

public class IntensiveCollections_PavelSidorov {
    private static final String LIST_ERROR = "List is null";

    /**
     * Quicksort function for IntensiveList structure using Comparable
     *
     * @param list unsorted IntensiveList
     * @param <E>  Generic parameter for IntensiveList.
     * @return sorted IntensiveList
     */
    public static <E extends Comparable<E>> IntensiveList<E> quickSort(IntensiveList<E> list) {
        if (list != null) {

            if (list.size() <= 1) {
                return list;
            }

            IntensiveList<E> right = new IntensiveArrayList_PavelSidorov<>();
            IntensiveList<E> left = new IntensiveArrayList_PavelSidorov<>();
            IntensiveList<E> central = new IntensiveArrayList_PavelSidorov<>();
            int mid = list.size() - (list.size() / 2);
            E pivot = list.get(mid);

            for (int i = 0; i < list.size(); i++) {

                if (pivot.compareTo(list.get(i)) < 0) {
                    right.add(list.get(i));

                } else if (pivot.compareTo(list.get(i)) > 0) {
                    left.add(list.get(i));

                } else if (pivot.compareTo(list.get(i)) == 0) {
                    central.add(list.get(i));
                }

            }

            return merge(quickSort(left), quickSort(right), central);
        }
        throw new IllegalArgumentException(LIST_ERROR);
    }

    /**
     * Quicksort function for IntensiveList structure using Comparator
     *
     * @param list       unsorted IntensiveList
     * @param comparator sorting comparator
     * @param <E>        Generic parameter for IntensiveList.
     * @return sorted IntensiveList
     */
    public static <E> IntensiveList<E> quickSort(IntensiveList<E> list, Comparator<E> comparator) {
        if (list != null && comparator != null) {

            if (list.size() <= 1) {
                return list;
            }

            IntensiveList<E> right = new IntensiveArrayList_PavelSidorov<>();
            IntensiveList<E> left = new IntensiveArrayList_PavelSidorov<>();
            IntensiveList<E> central = new IntensiveArrayList_PavelSidorov<>();
            E pivot = list.get(0);

            for (int i = 0; i < list.size(); i++) {

                if (comparator.compare(pivot, list.get(i)) < 0) {
                    right.add(list.get(i));

                } else if (comparator.compare(pivot, list.get(i)) > 0) {
                    left.add(list.get(i));

                } else if (comparator.compare(pivot, list.get(i)) == 0) {
                    central.add(list.get(i));
                }

            }

            return merge(quickSort(left, comparator), quickSort(right, comparator), central);
        }
        throw new IllegalArgumentException(LIST_ERROR);
    }

    private static <E> IntensiveList<E> merge(IntensiveList<E> left, IntensiveList<E> right, IntensiveList<E> central) {
        if (left != null && right != null) {

            for (int i = 0; i < central.size(); i++) {
                left.add(central.get(i));

            }
            for (int i = 0; i < right.size(); i++) {
                left.add(right.get(i));

            }

            return left;
        }
        throw new IllegalArgumentException(LIST_ERROR);
    }
}
