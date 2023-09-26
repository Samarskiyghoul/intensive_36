package task_1_2.impl;

import task_1_1.IntensiveList;

public class IntensiveCollections_OlgaPestova {
    /**
     * Method sorting list.
     * @param list - list to be sorted
     * @return sorted list
     * @param <T> - the type of elements in this list
     */
    public static <T extends Comparable<T>> IntensiveList<T> quickSort(IntensiveList<T> list) {
        if (list.size() <= 1) {
            return list;
        }
        sort(list, 0, list.size() - 1);
        return list;
    }

    /**
     * Internal sort method
     * @param list - list to be sorted
     * @param start - starting index
     * @param end - end index
     * @param <T> - the type of elements in this list
     */
    private static <T extends Comparable<T>> void sort(IntensiveList<T> list, int start, int end) {

        if (start > end) return;

        int leftIndex = start;
        int rightIndex = end;
        // selection of support element
        int pivotIndex = start + (end - start) / 2;
        T pivot = list.get(pivotIndex);

        while (leftIndex <= rightIndex) {
            while (list.get(leftIndex).compareTo(pivot) < 0) {
                leftIndex++;
            }
            while (list.get(rightIndex).compareTo(pivot) > 0) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(list, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        // If there are more subarrays, call sorting in them.
        if (start < rightIndex) {
            sort(list, start, rightIndex);
        }
        if (end > leftIndex) {
            sort(list, leftIndex, end);
        }
    }

    /**
     * This helper method is for rearranging the elements of a list.
     * @param list - list in which the elements will be rearranged
     * @param i - index one for rearrange
     * @param j - index two for rearrange
     * @param <T> - the type of elements in this list
     */
    private static <T extends Comparable<T>> void swap(IntensiveList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}