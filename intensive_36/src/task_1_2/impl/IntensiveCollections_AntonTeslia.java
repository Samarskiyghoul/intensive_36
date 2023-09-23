package task_1_2.impl;

import task_1_1.IntensiveList;

import java.util.Comparator;

public class IntensiveCollections_AntonTeslia {
    public static <E extends Comparable<E>> IntensiveList<E> quickSort(IntensiveList<E> list) {
        if (list.size() == 0) {
            return list;
        }
        sort(list, 0, list.size() - 1);
        return list;
    }

    private static <E extends Comparable<E>> void sort(IntensiveList<E> list, int begin, int end) {
        if (list.size() == 0 || begin >= end) return;
        int middle = begin + (end - begin) / 2;
        E border = list.get(middle);
        int i = begin, j = end;

        while (i <= j) {
            while (list.get(i).compareTo(border) < 0) i++;
            while (list.get(j).compareTo(border) > 0) j--;
            if (i <= j) {
                E swap = list.get(i);
                list.set(i, list.get(j));
                list.set(j, swap);
                i++;
                j--;
            }
        }
        if (begin < j) sort(list, begin, j);
        if (end > i) sort(list, i, end);
    }

    public static <E> IntensiveList<E> quickSort(IntensiveList<E> list, Comparator<E> comparator) {
        if (list.size() == 0 || comparator == null) {
            return list;
        }
        sortWithComparator(list, 0, list.size() - 1, comparator);
        return list;
    }

    private static <E> void sortWithComparator(IntensiveList<E> list, int begin, int end, Comparator<E> comparator) {
        if (list.size() == 0 || begin >= end) return;
        int middle = begin + (end - begin) / 2;
        E border = list.get(middle);
        int i = begin, j = end;

        while (i <= j) {
            while (comparator.compare(list.get(i), border) < 0) i++;
            while (comparator.compare(list.get(j), border) > 0) j--;
            if (i <= j) {
                E swap = list.get(i);
                list.set(i, list.get(j));
                list.set(j, swap);
                i++;
                j--;
            }
        }
        if (begin < j) sortWithComparator(list, begin, j, comparator);
        if (end > i) sortWithComparator(list, i, end, comparator);
    }
}
