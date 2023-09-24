package test.java;

import org.example.task_1_1.IntensiveList;
import org.example.task_1_1.impl.IntensiveArrayList_AnnaOvcharuk;
import org.example.task_1_3.impl.IntensiveAssertions_AnnaOvcharuk;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntensiveAssertionsTest {

    @Test
    void testAssertSortWithSortedIntList() {
        System.out.println("Тест: проверка отсортированного списка");

        IntensiveList<Integer> sortedList = new IntensiveArrayList_AnnaOvcharuk<>();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);

        System.out.println("Список:");
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
        }

        boolean isSorted = IntensiveAssertions_AnnaOvcharuk.assertSort(sortedList);

        System.out.println("Результат: " + isSorted);
        assertTrue(isSorted);
    }

    @Test
    void testAssertSortWithUnsortedIntList() {
        System.out.println("Тест: проверка неотсортированного списка");

        IntensiveList<Integer> unsortedList = new IntensiveArrayList_AnnaOvcharuk<>();
        unsortedList.add(3);
        unsortedList.add(1);
        unsortedList.add(2);

        System.out.println("Список:");
        for (int i = 0; i < unsortedList.size(); i++) {
            System.out.println(unsortedList.get(i));
        }

        boolean isSorted = IntensiveAssertions_AnnaOvcharuk.assertSort(unsortedList);

        System.out.println("Результат: " + isSorted);
        assertFalse(isSorted);
    }

    @Test
    void testAssertSortWithEmptyList() {
        System.out.println("Тест: проверка пустого списка");

        IntensiveList<Integer> emptyList = new IntensiveArrayList_AnnaOvcharuk<>();

        System.out.println("Список:");
        for (int i = 0; i < emptyList.size(); i++) {
            System.out.println(emptyList.get(i));
        }

        boolean isSorted = IntensiveAssertions_AnnaOvcharuk.assertSort(emptyList);

        System.out.println("Результат: " + isSorted);
        assertTrue(isSorted); // Пустой список считается отсортированным.
    }
}
