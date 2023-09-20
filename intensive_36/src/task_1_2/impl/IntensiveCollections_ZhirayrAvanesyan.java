package task_1_2.impl;

import task_1_1.IntensiveList;

import java.util.Comparator;

public class IntensiveCollections_ZhirayrAvanesyan {
    public static <E extends Comparable<E>> IntensiveList<E> quickSort(IntensiveList<E> list) {
        if (list == null || list.size() <= 1)
            return list;
        quickSortRecursive(list, 0, list.size() - 1);
        return list;
    }
        private static <E extends Comparable<E>> void quickSortRecursive (IntensiveList <E> list,int low, int high){
            if (low < high) {
                int middle = low + (high - low) / 2;
                E pivot = list.get(middle);
                int i = low, j = high;
                while (i <= j) {
                    while (list.get(i).compareTo(pivot) < 0)
                        i++;
                    while (list.get(j).compareTo(pivot) > 0)
                        j--;
                    if (i <= j) {
                        E temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                        i++;
                        j--;
                    }
                }
                if (i < high)
                    quickSortRecursive(list, i, high);
                if (j > low)
                    quickSortRecursive(list, low, j);
            }
        }
    }
