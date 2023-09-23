package test;

import task_1_1.impl.IntensiveArrayList_RuslanBurduzhan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class IntensiveArrayList_RuslanBurduzhanTest {
    private IntensiveArrayList_RuslanBurduzhan<Employee> myCollection;
    private List<Employee> originalCollection;
    private
    List<Employee> employees;

    public IntensiveArrayList_RuslanBurduzhanTest() {
        this.myCollection = new IntensiveArrayList_RuslanBurduzhan<>();
        this.originalCollection = new ArrayList<>();
        employees = List.of(
                new Employee("Kolya", "Zaycev", 25),
                new Employee("Aleksey", "", 18),
                new Employee("Kirill", "Detroit", 56),
                new Employee("Ruslan", "Krasniy", 33),
                new Employee("Petr", "Volkov", 29)
        );
    }

    void startAll() {
        TestUtils.showTestCaseName("IntensiveArrayList_RuslanBurduzhan");
        TestUtils.showTestResult("size", size());
        TestUtils.showTestResult("add", add());
        TestUtils.showTestResult("addWithIndex", addWithIndex());
        TestUtils.showTestResult("get", get());
        TestUtils.showTestResult("set", set());
        TestUtils.showTestResult("remove", remove());
        TestUtils.showTestResult("removeAll", removeAll());
    }

    private boolean size() {
        refreshAll();
        if (myCollection.size() != originalCollection.size()) {
            return false;
        }
        fillCollections();
        return myCollection.size() == originalCollection.size();
    }

    private boolean add() {
        refreshAll();
        for (int i = 0; i < 4; i++) {
            myCollection.add(employees.get(i));
            originalCollection.add(employees.get(i));
        }
        return TestUtils.compareElementsInCollections(myCollection, originalCollection);
    }

    private boolean addWithIndex() {
        refreshAll();
        for (int i = 0; i < 4; i++) {
            myCollection.add(myCollection.size(), employees.get(i));
            originalCollection.add(originalCollection.size(), employees.get(i));
        }
        return TestUtils.compareElementsInCollections(myCollection, originalCollection);
    }

    private boolean get() {
        refreshAll();
        fillCollections();
        return myCollection.get(0).equals(myCollection.get(0));
    }

    private boolean set() {
        refreshAll();
        fillCollections();
        Employee employee = new Employee("Test", "Test", 123);
        myCollection.set(3, employee);
        originalCollection.set(3, employee);
        return TestUtils.compareElementsInCollections(myCollection, originalCollection);
    }

    private boolean remove() {
        refreshAll();
        fillCollections();
        for (int i = 0; i < 3; i++) {
            myCollection.remove(i);
            originalCollection.remove(i);
        }
        return TestUtils.compareElementsInCollections(myCollection, originalCollection);
    }

    private boolean removeAll() {
        refreshAll();
        fillCollections();
        myCollection.removeAll();
        originalCollection.clear();
        return myCollection.size() == originalCollection.size();
    }

    private void refreshAll() {
        myCollection.removeAll();
        originalCollection.clear();
    }

    private void fillCollections() {
        for (Employee employee : employees) {
            myCollection.add(employee);
            originalCollection.add(employee);
        }
    }

    private class Employee implements Comparable<Employee> {
        private String name;
        private String surname;
        private int age;

        public Employee(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        @Override
        public int compareTo(Employee otherEmployee) {
            // Сравнение по фамилии
            int surnameComparison = this.surname.compareTo(otherEmployee.surname);
            if (surnameComparison != 0) {
                return surnameComparison;
            }

            // Сравнение по имени
            int nameComparison = this.name.compareTo(otherEmployee.name);
            if (nameComparison != 0) {
                return nameComparison;
            }

            // Сравнение по возрасту
            return Integer.compare(this.age, otherEmployee.age);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname, age);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}