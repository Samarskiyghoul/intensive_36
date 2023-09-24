package task_1_2.impl;

import task_1_1.IntensiveList;

import java.util.Random;

public class IntensiveCollections_RuslanBurduzhan {
    /**
     * Сортирует указанную коллекцию по возрастанию в соответствии с естественным порядком её элементов
     * от нижнего до верхнего индекса.
     * Все элементы в коллекции должны реализовывать Comparable интерфейс.
     * Кроме того, все элементы в коллекции должны быть взаимно сопоставимы.
     *
     * @param intensiveList коллекция для сортировки.
     * @param <E>           класс объектов в коллекции.
     * @return отсортированная по возрастанию коллекция.
     */
    public static <E extends Comparable<? super E>> IntensiveList<E> quickSort(IntensiveList<E> intensiveList) {
        if (intensiveList.size() < 2) {
            return intensiveList;
        }
        return quickSort(intensiveList, 0, intensiveList.size() - 1);
    }

    /**
     * Сортирует указанную коллекцию по возрастанию в соответствии с естественным порядком её элементов
     * от нижнего до верхнего индекса.
     * Все элементы в коллекции должны реализовывать Comparable интерфейс.
     * Кроме того, все элементы в коллекции должны быть взаимно сопоставимы.
     *
     * @param intensiveList коллекция для сортировки.
     * @param lowIndex      индекс начала сортировки.
     * @param heightIndex   индекс конца сортировки.
     * @param <E>           класс объектов в коллекции.
     * @return отсортированная по возрастанию коллекция.
     * @throws IndexOutOfBoundsException если index1 или index2 выходят за пределы диапазона
     *                                   (lowIndex < 0 || lowIndex >= size || heightIndex < 0 || heightIndex >= size).
     */
    public static <E extends Comparable<? super E>> IntensiveList<E> quickSort(IntensiveList<E> intensiveList, int lowIndex, int heightIndex) {
        if (lowIndex >= heightIndex) {
            return intensiveList;
        }
        int pivotIndex = new Random().nextInt(heightIndex - lowIndex) + lowIndex;
        E pivot = intensiveList.get(pivotIndex);
        swap(intensiveList, pivotIndex, heightIndex);
        int leftPointer = lowIndex;
        int rightPointer = heightIndex;

        while (leftPointer < rightPointer) {
            while (intensiveList.get(leftPointer).compareTo(pivot) <= 0 && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (intensiveList.get(rightPointer).compareTo(pivot) >= 0 && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(intensiveList, leftPointer, rightPointer);
        }
        swap(intensiveList, leftPointer, heightIndex);
        return quickSort(quickSort(intensiveList, lowIndex, leftPointer - 1), leftPointer + 1, heightIndex);
    }

    /**
     * Меняет местами элементы в указанных позициях в указанной коллекции.
     * Если указанные позиции равны, вызов этого метода оставляет коллекцию неизменной.
     *
     * @param intensiveList коллекция в которой нужно поменять местами элементы.
     * @param index1        индекс первого элемента.
     * @param index2        индекс второго элемента.
     * @param <E>           класс объектов в коллекции.
     * @throws IndexOutOfBoundsException если index1 или index2 выходят за пределы диапазона
     *                                   (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size).
     */
    public static <E> void swap(IntensiveList<E> intensiveList, int index1, int index2) {
        int size = intensiveList.size();
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw new IndexOutOfBoundsException(String.format("Index1: %d, Index2: %d, Size: %d", index1, index2, size));
        }
        if (index1 != index2) {
            intensiveList.set(index1, intensiveList.set(index2, intensiveList.get(index1)));
        }
    }
}