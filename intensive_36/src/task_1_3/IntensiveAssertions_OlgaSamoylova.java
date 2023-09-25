package task_1_3;

import task_1_1.IntensiveList;

import java.util.Comparator;

/**
 * Проверка является ли IntensiveList отсортированным
 * @author Olga Samoylova
 */
public class IntensiveAssertions_OlgaSamoylova {

    /**
     * Проверка является ли IntensiveList отсортированным
     * @param list
     * @return true, если лист отсортирован; false, если не отсортирован
     */
    public static boolean assertSort(IntensiveList<? extends Comparable> list) {
        if (list.size() > 1) {
            Comparator c = new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if (o1.equals(o2)) {
                        return 0;
                    } else if (o1.hashCode() < o2.hashCode()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            };
            for (int i = 1; i < list.size(); i++) {
                if (c.compare(list.get(i - 1), list.get(i)) > 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
