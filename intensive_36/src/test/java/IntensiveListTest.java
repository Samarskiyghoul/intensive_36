package test.java;

import org.example.task_1_1.IntensiveList;
import org.example.task_1_1.impl.IntensiveArrayList_AnnaOvcharuk;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntensiveListTest {
    private IntensiveList<Integer> list;

    @Before
    public void setUp() {
        // Инициализируем динамический массив и добавляем числовые элементы
        list = new IntensiveArrayList_AnnaOvcharuk<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    @Test
    public void testAddToEnd() {
        int initialSize = list.size();
        assertTrue(list.add(10));
        assertEquals(initialSize + 1, list.size());
        assertEquals(Integer.valueOf(10), list.get(list.size() - 1));
        System.out.println("Состояние списка после добавления в конец: " + listToString(list));
    }

    @Test
    public void testAddAtIndex() {
        int initialSize = list.size();
        list.add(1, 0);

        assertEquals(initialSize + 1, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(0), list.get(1));
        assertEquals(Integer.valueOf(2), list.get(2));
        assertEquals(Integer.valueOf(3), list.get(3));
        System.out.println("Состояние списка после добавления по индексу: " + listToString(list));
    }

    @Test
    public void testGet() {
        int initialSize = list.size();

        assertEquals(initialSize, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
        System.out.println("Состояние списка: " + listToString(list));
    }

    @Test
    public void testSet() {
        int initialSize = list.size();
        Integer oldValue = list.set(3, 0); // Изменяем элемент с индексом 3

        assertEquals(initialSize, list.size());
        assertEquals(Integer.valueOf(0), list.get(3)); // Проверяем, что элемент изменился
        assertEquals(Integer.valueOf(4), oldValue); // Проверяем, что старое значение верно
        System.out.println("Состояние списка после замены элемента: " + listToString(list));
    }

    @Test
    public void testRemove() {
        int initialSize = list.size();
        int indexToRemove = 4; // Индекс элемента, который хотим удалить
        assertTrue(indexToRemove >= 0 && indexToRemove < initialSize); // Проверяем, что индекс в пределах списка

        Integer removedValue = list.remove(indexToRemove);

        assertEquals(initialSize - 1, list.size());

        // Проверяем, что удаленное значение соответствует ожидаемому
        assertEquals(Integer.valueOf(5), removedValue); // Проверяем, что удаленное значение верно

        // Также можно убедиться, что элементы сдвинулись
        assertEquals(Integer.valueOf(6), list.get(indexToRemove));
        System.out.println("Состояние списка после удаления элемента: " + listToString(list));
    }

    @Test
    public void testRemoveAll() {
        list.removeAll();

        assertEquals(0, list.size());
        System.out.println("Состояние списка после удаления всех элементов: " + listToString(list));
    }

    private String listToString(IntensiveList<Integer> list) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i));
            if (i < list.size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
