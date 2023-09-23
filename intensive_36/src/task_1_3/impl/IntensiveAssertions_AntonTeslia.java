package task_1_3.impl;

import task_1_1.IntensiveList;

import java.util.Comparator;

public class IntensiveAssertions_AntonTeslia {
    public static <E> boolean assertSort(IntensiveList<E> list, Comparator<E> comparator) {
        if (list.size() <= 1) {
            return true;
        }
        for (int i = 1; i < list.size() - 1; i++) {
            if (comparator.compare(list.get(i - 1), list.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> boolean assertSort(IntensiveList<E> list) {
        if (list.size() <= 1) {
            return true;
        }
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }
}
