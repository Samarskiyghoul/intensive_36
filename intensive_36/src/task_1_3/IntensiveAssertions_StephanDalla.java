package task_1_3;

import task_1_1.IntensiveList;


import static task_1_2.IntensiveCollections_StephanDalla.quickSort;

public class IntensiveAssertions_StephanDalla {

    public static <E extends Comparable<E>> boolean assertSort(IntensiveList<E> list) {
        IntensiveList<E> list1 = list;
        quickSort(list1, 0, list1.size() - 1);


        for (int i = 0; i < list.size(); i++) {
            E elemFirstList = list1.get(i);
            E elemSecondList = list.get(i);

            if (!elemFirstList.equals(elemSecondList)) {
                return false;
            }

        }
        return true;


    }
}
