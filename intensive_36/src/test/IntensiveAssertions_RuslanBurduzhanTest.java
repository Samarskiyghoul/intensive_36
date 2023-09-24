package test;


import task_1_1.impl.IntensiveArrayList_RuslanBurduzhan;
import task_1_3.impl.IntensiveAssertions_RuslanBurduzhan;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс содержит тест-кейсы для класса IntensiveAssertions_RuslanBurduzhan.
 */
final class IntensiveAssertions_RuslanBurduzhanTest {
    private IntensiveArrayList_RuslanBurduzhan<Integer> myCollection;
    private List<Integer> originalCollection;

    public IntensiveAssertions_RuslanBurduzhanTest() {
        this.myCollection = new IntensiveArrayList_RuslanBurduzhan<>();
        this.originalCollection = new ArrayList<>();
    }

    /**
     * Метод запускает тест-кейсы и выводит результат выполнения в консоль.
     */
    public void startAll() {
        TestUtils.showTestCaseName("IntensiveAssertions_RuslanBurduzhan");
        TestUtils.showTestResult("assertSort", assertSort());
    }

    private boolean assertSort() {
        refreshAll();
        for (int i = 0; i < 25; i++) {
            myCollection.add(i);
            originalCollection.add(i);
        }
        if (!IntensiveAssertions_RuslanBurduzhan.assertSort(myCollection)) {
            return false;
        }
        myCollection.add(-123);
        return !IntensiveAssertions_RuslanBurduzhan.assertSort(myCollection);
    }

    private void refreshAll() {
        myCollection.removeAll();
        originalCollection.clear();
    }
}