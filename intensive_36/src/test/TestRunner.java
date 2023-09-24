package test;

/**
 * Класс TestRunner является точкой запуска всех тестов.
 */
public final class TestRunner {
    /**
     * Запускает все тесты.
     */
    public static void runTest() {
        new IntensiveArrayList_RuslanBurduzhanTest().startAll();
        new IntensiveAssertions_RuslanBurduzhanTest().startAll();
        new IntensiveCollections_RuslanBurduzhanTest().startAll();
    }
}
