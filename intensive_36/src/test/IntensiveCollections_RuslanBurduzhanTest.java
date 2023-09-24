package test;

import task_1_1.impl.IntensiveArrayList_RuslanBurduzhan;
import task_1_2.impl.IntensiveCollections_RuslanBurduzhan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Класс содержит тест-кейсы для класса IntensiveCollections_RuslanBurduzhan.
 */
final class IntensiveCollections_RuslanBurduzhanTest {
    private IntensiveArrayList_RuslanBurduzhan<Integer> myCollection;
    private List<Integer> originalCollection;

    public IntensiveCollections_RuslanBurduzhanTest() {
        this.myCollection = new IntensiveArrayList_RuslanBurduzhan<>();
        this.originalCollection = new ArrayList<>();
    }

    /**
     * Метод запускает тест-кейсы и выводит результат выполнения в консоль.
     */
    public void startAll() {
        TestUtils.showTestCaseName("IntensiveCollections_RuslanBurduzhan");
        TestUtils.showTestResult("quickSort", quickSort());
        TestUtils.showTestResult("quickSortWithIndexes", quickSortWithIndexes());
        TestUtils.showTestResult("swap", swap());
    }

    private boolean quickSort() {
        refreshAll();
        IntensiveCollections_RuslanBurduzhan.quickSort(myCollection);
        Collections.sort(originalCollection);
        return TestUtils.compareElementsInCollections(myCollection, originalCollection);
    }

    private boolean quickSortWithIndexes() {
        refreshAll();
        IntensiveCollections_RuslanBurduzhan.quickSort(myCollection, 0, myCollection.size() - 1);
        Collections.sort(originalCollection);
        return TestUtils.compareElementsInCollections(myCollection, originalCollection);
    }

    private boolean swap() {
        refreshAll();
        Collections.swap(originalCollection, 0, originalCollection.size() - 1);
        IntensiveCollections_RuslanBurduzhan.swap(myCollection, 0, myCollection.size() - 1);
        return TestUtils.compareElementsInCollections(myCollection, originalCollection);
    }

    private void refreshAll() {
        myCollection.removeAll();
        originalCollection.clear();
        fillCollections();
    }

    private void fillCollections() {
        for (int i = 0; i < 25; i++) {
            int value = new Random().nextInt(100);
            myCollection.add(value);
            originalCollection.add(value);
        }
    }
}