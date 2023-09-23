package task_1_3.impl;

import task_1_1.IntensiveList;

import java.util.stream.IntStream;

public class IntensiveAssertions_RuslanBurduzhan {
    /**
     * Проверяет, отсортирована ли по возрастанию указанная коллекция в соответствии с естественным порядком её элементов.
     *
     * @param list коллекция для проверки.
     * @param <E>  класс объектов в коллекции.
     * @return true, если коллекция отсортирована по возрастанию, иначе возвращает false.
     */
    public static <E extends Comparable<? super E>> boolean assertSort(IntensiveList<E> list) {
        int size = list.size();
        if (size < 2) {
            return true;
        }
        return IntStream.range(0, size - 1).noneMatch(e -> list.get(e).compareTo(list.get(e + 1)) > 0);
    }
}
