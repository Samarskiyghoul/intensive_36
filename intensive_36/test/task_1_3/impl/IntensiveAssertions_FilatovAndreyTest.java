package task_1_3.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import task_1_1.impl.IntensiveArrayList_FilatovAndrey;

class IntensiveAssertions_FilatovAndreyTest {

    static IntensiveArrayList_FilatovAndrey<String> list;
    static IntensiveArrayList_FilatovAndrey<String> sortedList;

    @BeforeAll
    static void setup() {
        list = IntensiveArrayList_FilatovAndrey
                .of("dog", "cat", "parrot", "ocelot", "hummingbird", "giraffe");
        sortedList= IntensiveArrayList_FilatovAndrey
                .of("cat", "dog", "giraffe", "hummingbird", "ocelot", "parrot");
    }

    @Test
    void assertSort() {
        boolean noSorted = IntensiveAssertions_FilatovAndrey.assertSort(list);
        boolean sorted = IntensiveAssertions_FilatovAndrey.assertSort(sortedList);
        Assertions.assertFalse(noSorted);
        Assertions.assertTrue(sorted);
    }
}