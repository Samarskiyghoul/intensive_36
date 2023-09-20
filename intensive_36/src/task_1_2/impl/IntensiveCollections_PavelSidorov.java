package task_1_2.impl;

import task_1_1.IntensiveList;
import task_1_1.impl.IntensiveArrayList_PavelSidorov;

import java.util.Comparator;

/**
 * IntensiveCollections utils.
 *
 * @param <E> Generic parameter.
 */

public class IntensiveCollections_PavelSidorov<E extends Comparable<E>> {
    private static final String LIST_ERROR = "List is null";
    private Comparator<E> comparator;

    public IntensiveCollections_PavelSidorov(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * Quick sort for IntensiveList structure
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
            E pivot = (E) list.get(0);

            for (int i = 0; i < list.size(); i++) {
                if (pivot.compareTo((E) list.get(i)) < 0) {
                    right.add(list.get(i));
                } else if (pivot.compareTo((E) list.get(i)) > 0) {
                    left.add(list.get(i));
                } else if (pivot.compareTo((E) list.get(i)) == 0) {
                    central.add(list.get(i));
                }
            }

            return merge(quickSort(left), quickSort(right), central);
        }
        throw new IllegalArgumentException(LIST_ERROR);
    }

    private static <E extends Comparable<E>> IntensiveList<E> merge(
            IntensiveList<E> left,
            IntensiveList<E> right,
            IntensiveList<E> central
    ) {
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
