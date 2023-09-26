package task_1_3.impl;

import task_1_1.IntensiveList;
import util.Util;

/**
 * A utility class containing a method to check that the {@link IntensiveList} is sorted.
 * @author  Aleksander Tsaregorodtsev
 * @since   1.0
 */
public class IntensiveAssertions_AlexanderTsaregorodtsev {

    /**
     * Checks that the specified list stores values in ascending order.
     * @param list a list which sorting needs to be checked
     * @return true if the list is sorted in ascending order, otherwise false
     * @param <E> a type of elements that are stored in the list (including their descendants)
     */
    public static <E extends Comparable<? super E>> boolean assertSort(IntensiveList<E> list) {

        if (list.size() < 2) {
            return true;
        }

        E prevElement = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            E currentElement = list.get(i);
             if (Util.nullSafeCompare(prevElement, currentElement) > 0) {
                return false;
            }
            prevElement = currentElement;
        }

        return true;

    }
}
