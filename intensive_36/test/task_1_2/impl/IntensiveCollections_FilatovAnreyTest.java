package task_1_2.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import task_1_1.IntensiveList;
import task_1_1.impl.IntensiveArrayList_FilatovAndrey;

import java.util.stream.Stream;

class IntensiveCollections_FilatovAnreyTest {

    @ParameterizedTest
    @ArgumentsSource(IntensiveCollectionsArgumentProvider.class)
    void sortTest(IntensiveList list, IntensiveList sortedList) {
        IntensiveCollections_FilatovAnrey.quickSort(list);
        Assertions.assertEquals(sortedList, list);
    }
}

class IntensiveCollectionsArgumentProvider implements ArgumentsProvider {

    IntensiveArrayList_FilatovAndrey<String> stringList;
    IntensiveArrayList_FilatovAndrey<Integer> integerList;
    IntensiveArrayList_FilatovAndrey<String> sortedStringList;
    IntensiveArrayList_FilatovAndrey<Integer> sortedIntegerList;

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        setupData();
        return Stream.of(
                Arguments.of(stringList, sortedStringList),
                Arguments.of(integerList, sortedIntegerList)
        );
    }

    private void setupData() {
        stringList = IntensiveArrayList_FilatovAndrey
                .of("dog", "cat", "parrot", "ocelot", "hummingbird", "giraffe");

        integerList = IntensiveArrayList_FilatovAndrey.of(0, 4, 5, 2, 9, 10, 3);

        sortedStringList = IntensiveArrayList_FilatovAndrey
                .of("cat", "dog", "giraffe", "hummingbird", "ocelot", "parrot");

        sortedIntegerList = IntensiveArrayList_FilatovAndrey.of(0, 2, 3, 4, 5, 9, 10);
    }
}

