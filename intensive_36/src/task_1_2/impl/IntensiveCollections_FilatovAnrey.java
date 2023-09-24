package task_1_2.impl;

import task_1_1.IntensiveList;

public class IntensiveCollections_FilatovAnrey {

    public static <E extends Comparable<E>> IntensiveList<E> quickSort(IntensiveList<E> list) {
        return qsort(list, 0, list.size() - 1);
    }

    private static <E extends Comparable<E>> IntensiveList<E> qsort(IntensiveList<E> list, int left, int right) {
        int size = right - left + 1;
        switch (size) {
            case 0:
            case 1:
                break;
            case 2:
                if (compare(list.get(left), list.get(right)) > 0) swap(list, left, right);
                break;
            case 3:
                if (compare(list.get(left), list.get(right - 1)) > 0) swap(list, left, right - 1);
                if (compare(list.get(left), list.get(right)) > 0) swap(list, left, right);
                if (compare(list.get(left + 1), list.get(right)) > 0) swap(list, left + 1, right);
                break;
            default:
                int median = median(list, left, right);
                int partition = partition(list, left, right, median);
                qsort(list, left, partition - 1);
                qsort(list, partition + 1, right);
        }
        return list;
    }


    private static int compare(Object a, Object b) {
        if (a == null) {
            return b == null ? 0 : -1;
        } else if (b == null) {
            return 1;
        } else {
            return ((Comparable) a).compareTo(b);
        }
    }

    private static int median(IntensiveList<?> list, int left, int right) {
        int center = (left + right) / 2;
        if (compare(list.get(left), list.get(center)) > 0) {
            swap(list, left, center);
        }
        if (compare(list.get(left), list.get(right)) > 0) {
            swap(list, left, right);
        }
        if (compare(list.get(center), list.get(right)) > 0) {
            swap(list, center, right);
        }
        swap(list, center, right - 1);
        return right - 1;
    }

    private static int partition(IntensiveList<?> list, int left, int right, int pivotIndex) {
        int leftIndex = left;
        int rightIndex = right - 1;

        while (true) {
            while (compare(list.get(++leftIndex), list.get(pivotIndex)) < 0);
            while (compare(list.get(--rightIndex), list.get(pivotIndex)) > 0);
            if (leftIndex >= rightIndex) {
                break;
            } else {
                swap(list, leftIndex, rightIndex);
            }
        }
        swap(list, leftIndex, right - 1);
        return leftIndex;
    }

    private static void swap(IntensiveList<?> list, int leftIndex, int rightIndex) {
        Object temp = list.get(leftIndex);
        list.set(leftIndex, list.get(rightIndex));
        list.set(rightIndex, temp);
    }

}
