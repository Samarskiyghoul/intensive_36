package task_1_2.impl;

import task_1_1.IntensiveList;
import util.Util;

/**
 * A utility class containing a method for quick sorting {@link IntensiveList}.
 * @author  Aleksander Tsaregorodtsev
 * @since   1.0
 */
public class IntensiveCollections_AleksanderTsaregorodtsev {

    /**
     * Performs a quick sort of the specified list using the Hoare partition scheme.
     * @param list a list to sort
     * @return the original list object passed as a method parameter, but after sorting
     * @param <E> a type of elements that are stored in the list (including their descendants)
     */
    public static <E extends Comparable<? super E>> IntensiveList<E> quickSort(IntensiveList<E> list) {
        recursiveFuncQuickSort(list, 0, list.size() - 1);
        return list;
    }

    /**
     * A quick sort function based on the Hoare partition scheme, which is called recursively.
     * @param list a list to sort
     * @param leftIndex the index of the left element in the list from the range to sort
     * @param rightIndex the index of the right element in the list from the range to sort
     * @param <E> a type of elements that are stored in the list (including their descendants)
     */
    private static <E extends Comparable<? super E>> void recursiveFuncQuickSort(IntensiveList<E> list, int leftIndex,
            int rightIndex) {

        if (leftIndex < rightIndex) {
            int pivotIndex = partition(list, leftIndex, rightIndex);
            recursiveFuncQuickSort(list, leftIndex, pivotIndex);
            recursiveFuncQuickSort(list, pivotIndex + 1, rightIndex);
        }
    }

    /**
     * Selects the base element (pivot). Virtually splits the specified list into two parts. If necessary, calls a
     * function to swap list elements so that the left side contains elements less than the pivot, and the right side
     * contains elements greater than or equal to the pivot.
     * @param list a list to sort
     * @param leftIndex the index of the left element in the list from the range to sort
     * @param rightIndex the index of the right element in the list from the range to sort
     * @return an index of the pivot element
     * @param <E> a type of elements that are stored in the list (including their descendants)
     */
    private static <E extends Comparable<? super E>> int partition(IntensiveList<E> list, int leftIndex,
            int rightIndex) {
        E pivot = list.get((leftIndex + rightIndex) / 2);

        leftIndex--;
        rightIndex++;

        while (true) {
            do {
                leftIndex++;
            } while (Util.nullSafeCompare(list.get(leftIndex), pivot) < 0);

            do {
                rightIndex--;
            } while (Util.nullSafeCompare(list.get(rightIndex), pivot) > 0);

            if (leftIndex >= rightIndex) {
                return rightIndex;
            }
            swapElements(list, leftIndex, rightIndex);
        }
    }

    /**
     * Swaps the elements at the specified indices in the specified list.
     * @param list a list in which to swap the elements
     * @param leftIndex the left element index in the specified list
     * @param rightIndex the right element index in the specified list
     * @param <E> a type of elements that are stored in the list (including their descendants)
     */
    private static <E extends Comparable<? super E>> void swapElements(IntensiveList<E> list, int leftIndex,
            int rightIndex) {
        E temp = list.get(leftIndex);
        list.set(leftIndex, list.get(rightIndex));
        list.set(rightIndex, temp);
    }
}
