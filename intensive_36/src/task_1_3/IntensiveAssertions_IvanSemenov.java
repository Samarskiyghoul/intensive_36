package task_1_3;

import task_1_1.IntensiveList;

/**
 * 1.3 Реализовать алгоритм проверки является ли список отсортированным
 * - в пакете task_1_3.impl создать класс IntensiveAssertions_NameSurname,
 * реализовать статический метод assertSort, принимающий интерфейс IntensiveList
 * и возвращающий boolean (true - список отсортирован, false - не отсортирован).
 */
public class IntensiveAssertions_IvanSemenov {
    public static <E extends Comparable<E>> boolean assertSort(IntensiveList<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            E element = (E) list.get(i);
            E nextElement = (E) list.get(i + 1);
            if (element.compareTo(nextElement) > 0) {
                return false;
            }
        }
        return true;
    }
}
