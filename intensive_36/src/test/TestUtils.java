package test;

import task_1_1.impl.IntensiveArrayList_RuslanBurduzhan;

import java.util.List;

final class TestUtils {
    private final static String ANSI_RESET = "\u001B[0m";
    private final static String ANSI_RED = "\u001B[31m";
    private final static String ANSI_GREEN = "\u001B[32m";
    private final static String ANSI_YELLOW = "\u001B[33m";

    /**
     * Выводит в консоль название тест кейса.
     *
     * @param testCaseName название тест кейса.
     */
    public static void showTestCaseName(String testCaseName) {
        System.out.printf("%s=====================================%s\n", ANSI_GREEN, ANSI_RESET);
        System.out.printf("%s%s%s\n", ANSI_YELLOW, testCaseName, ANSI_RESET);
    }

    /**
     * Выводит название и результат выполнения теста.
     *
     * @param testName   название теста.
     * @param testResult результат выполнения теста. true или false.
     */
    public static void showTestResult(String testName, boolean testResult) {
        String color = testResult ? ANSI_GREEN : ANSI_RED;
        System.out.printf("%s - %s%s%s\n", testName, color, testResult, ANSI_RESET);
    }

    /**
     * Сравнивает на равенство элементы двух коллекций.
     *
     * @param myCollection       коллекция IntensiveArrayList_RuslanBurduzhan.
     * @param originalCollection коллекция List.
     * @param <T>                класс объектов в коллекции.
     * @return если элементы в коллекциях равны возвращает true, иначе false.
     */
    public static <T> boolean compareElementsInCollections(IntensiveArrayList_RuslanBurduzhan<T> myCollection, List<T> originalCollection) {
        for (int i = 0; i < myCollection.size(); i++) {
            if (!myCollection.get(i).equals(originalCollection.get(i))) {
                return false;
            }
        }
        return true;
    }
}