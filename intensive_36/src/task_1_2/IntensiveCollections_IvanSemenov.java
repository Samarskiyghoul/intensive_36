package task_1_2;

import task_1_1.IntensiveArrayList_IvanSemenov;
import task_1_1.IntensiveList;

public class IntensiveCollections_IvanSemenov<E extends Comparable<E>> {
    public static <E extends Comparable<E>> IntensiveList<E> quickSort(IntensiveList<E> list) {
        IntensiveList<E> result = new IntensiveArrayList_IvanSemenov<>();
        if (list.size() < 2) {
            return list;
        } else {
            E pivot = (E) list.get(0);

            IntensiveList<E> less = new IntensiveArrayList_IvanSemenov<>();
            IntensiveList<E> greater = new IntensiveArrayList_IvanSemenov<>();
            for (int i = 1; i < list.size(); i++) {
                E element = (E) list.get(i);
                if (element.compareTo(pivot) <= 0) {
                    less.add(list.get(i));
                } else {
                    greater.add(list.get(i));
                }
            }
            result.add(quickSort(less));
            result.add(pivot);
            result.add(quickSort(greater));
            return result;
        }
    }
}
