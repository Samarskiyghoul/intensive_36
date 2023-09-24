package task_1_3.impl;

import task_1_1.IntensiveList;

public class IntensiveAssertions_FilatovAndrey {

    public static <E extends Comparable<E>> boolean assertSort(IntensiveList<E> list) {
        int size = list.size();
        if (size <= 1)
            return true;
        for (int i = 0; i < size - 1; i++) {
            if (((Comparable) list.get(i)).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
