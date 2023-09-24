import task_1_1.IntensiveArrayList_IvanSemenov;
import task_1_1.IntensiveList;
import task_1_2.IntensiveCollections_IvanSemenov;
import task_1_3.IntensiveAssertions_IvanSemenov;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        IntensiveList<Integer> testList = new IntensiveArrayList_IvanSemenov<>();
        testList.add(3);
        testList.add(1);
        testList.add(15);
        testList.add(10);
        testList.add(0);
        testList.add(6);
        testList.add(10);

        IntensiveList<Integer> sortedList = IntensiveCollections_IvanSemenov.quickSort(testList);
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
        }
        System.out.println(IntensiveAssertions_IvanSemenov.assertSort(sortedList));
    }
}