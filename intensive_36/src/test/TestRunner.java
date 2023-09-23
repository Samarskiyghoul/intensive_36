package test;


public final class TestRunner {
    /**
     * Запускает все тесты.
     */
    public static void runTest() {
        IntensiveArrayList_RuslanBurduzhanTest arrayListTest = new IntensiveArrayList_RuslanBurduzhanTest();
        IntensiveAssertions_RuslanBurduzhanTest assertionTest = new IntensiveAssertions_RuslanBurduzhanTest();
        IntensiveCollections_RuslanBurduzhanTest collectionsTest = new IntensiveCollections_RuslanBurduzhanTest();

        arrayListTest.startAll();
        collectionsTest.startAll();
        assertionTest.startAll();
    }
}
