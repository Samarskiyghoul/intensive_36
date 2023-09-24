package test.java;

import org.example.task_1_1.IntensiveList;
import org.example.task_1_1.impl.IntensiveArrayList_AnnaOvcharuk;
import org.example.task_1_2.impl.IntensiveCollections_AnnaOvcharuk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntensiveCollectionsTest {
    private IntensiveList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new IntensiveArrayList_AnnaOvcharuk<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);
    }

    @Test
    void testQuickSort() {
        IntensiveList<Integer> sortedList = IntensiveCollections_AnnaOvcharuk.quickSort(list);

        // Выводим список до сортировки
        System.out.println("Неотсортированный список:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Выводим отсортированный список
        System.out.println("Отсортированный список:");
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
        }

        assertEquals(1, (int) sortedList.get(0));
        assertEquals(2, (int) sortedList.get(1));
        assertEquals(5, (int) sortedList.get(2));
        assertEquals(8, (int) sortedList.get(3));
    }

    @Test
    void testSortWithComparator() {
        IntensiveList<Integer> sortedList = IntensiveCollections_AnnaOvcharuk.sort(list, (a, b) -> b - a); // сортировка в обратном порядке

        // Выводим список до сортировки
        System.out.println("Неотсортированный список:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Выводим отсортированный список
        System.out.println("Отсортированный список (обратный порядок):");
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
        }

        assertEquals(8, (int) sortedList.get(0));
        assertEquals(5, (int) sortedList.get(1));
        assertEquals(2, (int) sortedList.get(2));
        assertEquals(1, (int) sortedList.get(3));
    }
}


