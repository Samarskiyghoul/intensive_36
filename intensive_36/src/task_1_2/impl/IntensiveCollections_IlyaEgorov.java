package task_1_2.impl;
import task_1_1.IntensiveList;

public class IntensiveCollections_IlyaEgorov {
    public static <Type extends Comparable<Type>> IntensiveList<Type> quickSort(IntensiveList<Type> list) {
        // В случае, если размер листа 0 или 1 вернуть его сразу
        if (list == null || list.size() <= 1) {
            return list;
        }
        recursive(list, 0, list.size() - 1);
        return list;
    }

    // Реализация алгоритма рекурсивной части быстрой сортировки
    private static <Type extends Comparable<Type>> void recursive(IntensiveList <Type> list, int wall, int high) {
        if (wall < high) {
            // Выбираем опорный элемент массива - pivot
            int mid = wall + (high - wall) / 2;
            Type pivot = list.get(mid);
            int i = wall;
            int j = high;

            while (i <= j) {
                while (list.get(i).compareTo(pivot) < 0) {
                    i++;
                }
                while (list.get(j).compareTo(pivot) > 0) {
                    j--;
                }
                if (i <= j) {
                    Type tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                    i++;
                    j--;
                }
            }

            if (i < high) {
                recursive(list, i, high);
            }
            if (j > wall) {
                recursive(list, wall, j);
            }
        }
    }
}