package task_1_3.impl;

import task_1_1.IntensiveList;

public class IntensiveAssertions_VarvaraMatveeva {

    public static <E extends Comparable<E>> boolean assertSort(IntensiveList<E> list) {
        int size = list.size();
        if (size <= 1) {
            return true;
        }

        for (int i = 1; i < size; i++) {
            E prev = (E) list.get(i - 1);
            E current = (E) list.get(i);

            if (prev.compareTo(current) > 0) {
                return false;
            }
        }

        return true;
    }
}

