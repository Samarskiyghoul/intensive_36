package task_1_2.impl;

import task_1_1.IntensiveList;
import task_1_1.impl.IntensiveArrayList_VarvaraMatveeva;

public class IntensiveCollections_VarvaraMatveeva {

    public static <E extends Comparable<E>> IntensiveList<E> quickSort(IntensiveList<E> list) {
        if (list.size() <= 1) {
            return list;
        }

        E pivot = (E) list.get(0);

        IntensiveList<E> less = new IntensiveArrayList_VarvaraMatveeva<>();
        IntensiveList<E> equal = new IntensiveArrayList_VarvaraMatveeva<>();
        IntensiveList<E> greater = new IntensiveArrayList_VarvaraMatveeva<>();

        for (int i = 0; i < list.size(); i++) {
            E element = (E) list.get(i);
            int cmp = element.compareTo(pivot);
            if (cmp < 0) {
                less.add(element);
            } else if (cmp > 0) {
                greater.add(element);
            } else {
                equal.add(element);
            }
        }

        IntensiveList<E> sortedLess = quickSort(less);
        IntensiveList<E> sortedGreater = quickSort(greater);

        IntensiveList<E> result = new IntensiveArrayList_VarvaraMatveeva<>();

        for (int i = 0; i < sortedLess.size(); i++) {
            result.add(sortedLess.get(i));
        }
        for (int i = 0; i < equal.size(); i++) {
            result.add(equal.get(i));
        }
        for (int i = 0; i < sortedGreater.size(); i++) {
            result.add(sortedGreater.get(i));
        }

        return result;
    }
}
