package util;

/**
 * A utility class containing a method for null-safe comparing of objects that implement the {@link Comparable}
 * interface.
 * @author  Aleksander Tsaregorodtsev
 * @since   1.0
 */
public class Util {

    /**
     * Compares the objects first and second. Null is considered the smallest possible value.
     * @param first the first object to compare
     * @param second the second object to compare
     * @return  negative integer, 0 or positive integer if the first object is less than, equal to or greater than the
     *          second one respectively
     * @param <E> a type of elements first and second
     */
    public static <E extends Comparable<? super E>> int nullSafeCompare(E first, E second) {
        if (first == null) {
            if (second == null) {
                return 0;
            } else {
                return -1;
            }
        }

        if (second == null) {
            return 1;
        } else {
            return first.compareTo(second);
        }
    }
}
