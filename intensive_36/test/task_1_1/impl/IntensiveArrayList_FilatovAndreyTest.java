package task_1_1.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task_1_1.IntensiveList;

class IntensiveArrayList_FilatovAndreyTest {

    String one = "one";
    String two = "two";
    String three = "three";
    String four = "four";

    IntensiveList<?> testList;

    @BeforeEach
    void setup() {
        testList = new IntensiveArrayList_FilatovAndrey<>(3);
        testList.add(one);
        testList.add(two);
        testList.add(three);
    }

    @Test
    void wrongParamConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IntensiveList<?> lst = new IntensiveArrayList_FilatovAndrey<>(-1);
        });
    }

    @Test
    void size() {
        IntensiveList<?> testList = new IntensiveArrayList_FilatovAndrey<>();
        testList.add(one);
        testList.add(two);
        Assertions.assertEquals(2, testList.size());
        testList.add(three);
        testList.add(four);
        Assertions.assertEquals(4, testList.size());

    }

    @Test
    void add() {
        Assertions.assertEquals(one, testList.get(0));
        Assertions.assertEquals(two, testList.get(1));
        Assertions.assertEquals(three, testList.get(2));
    }

    @Test
    @DisplayName("add with index")
    void insert() {
        testList.add(0, "zero");
        Assertions.assertEquals("zero", testList.get(0));
        Assertions.assertEquals(one, testList.get(1));
    }

    @Test
    @DisplayName("add with wrong index")
    void insertWithWrongIndex() {
        int index = -1;
        int wrongIndex = 100;
        Assertions.assertThrows(IllegalArgumentException.class, () -> testList.get(index));
        Assertions.assertThrows(IllegalArgumentException.class, () -> testList.get(wrongIndex));
    }

    @Test
    void set() {
        Assertions.assertEquals("one", testList.get(0));
        testList.set(0, four);
        Assertions.assertEquals("four", testList.get(0));
    }

    @Test
    void remove() {
        int index = 0;
        Assertions.assertEquals("one", testList.get(index));
        testList.remove(index);
        Assertions.assertNotEquals("one", testList.get(index));
    }

    @Test
    void removeAll() {
        int size = testList.size();
        testList.removeAll();
        Assertions.assertNotEquals(size, testList.size());
    }
}