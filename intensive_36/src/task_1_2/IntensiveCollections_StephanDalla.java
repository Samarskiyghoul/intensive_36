package task_1_2;

import task_1_1.IntensiveList;

public class IntensiveCollections_StephanDalla {

    public static <E extends Comparable<E>> void quickSort(IntensiveList<E> list, int left, int right) {

        if (left < right) {


            int dividedIndex = separation(list, left, right);

            quickSort(list, left, dividedIndex - 1);
            quickSort(list, dividedIndex, right);

        }
    }

    private static <E extends Comparable<E>> int separation(IntensiveList<E> list, int left, int right) {
        E pivot = list.get((int) (Math.random() * (right - left) + left));
        int leftIndex = left;
        int rightIndex = right;

        while (leftIndex <= rightIndex) {

            while (list.get(leftIndex).compareTo(pivot) < 0) { // поиск индекса элемента меньше опорного
                leftIndex++;
            }

            while (list.get(rightIndex).compareTo(pivot) > 0) { // поиск индекса элемента больше опорного
                rightIndex--;

            }

            if (leftIndex <= rightIndex) { // элементы массива меняются местами.
                swap(list, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;

            }


        }
        return leftIndex;

    }

    private static <E> void swap(IntensiveList<E> list, int index1, int index2) {
        E swapElem = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, swapElem);


    }


}

