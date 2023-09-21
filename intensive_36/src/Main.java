import task_1_1.IntensiveList;
import task_1_1.impl.IntensiveArrayList_PavelSidorov;
import task_1_2.impl.IntensiveCollections_PavelSidorov;
import task_1_3.impl.IntensiveAssertions_PavelSidorov;

import java.time.LocalDate;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        IntensiveList<String> students = new IntensiveArrayList_PavelSidorov<>(1);

        System.out.println(students);

        students.add("Jack");
        System.out.println(students);

        students.add("Mike");
        System.out.println(students);

        students.removeAll();
        System.out.println(students);

        students.add("Ted");
        System.out.println(students);

        students.add("Jane");
        System.out.println(students);

        students.add("Jill");
        System.out.println(students);

        students.add(0, "Sally0");
        System.out.println(students);

        students.add(1, "Sally1");
        System.out.println(students);

        students.add(2, "Sally2");
        System.out.println(students);

        students.add(3, "Sally3");
        System.out.println(students);

        System.out.println(students.get(0) + " " + students.get(students.size() - 1));
        students = IntensiveCollections_PavelSidorov.quickSort(students);
        System.out.println("SORTED " + students);
        System.out.println("Are Students sorted? " + IntensiveAssertions_PavelSidorov.assertSort(students));

        System.out.println(students.get(0) + " " + students.get(students.size() - 1));

        System.out.println(students.set(0, "Wally0"));
        System.out.println(students);

        System.out.println(students.set(1, "Wally0"));
        System.out.println(students);

        System.out.println(students.set(2, "Wally0"));
        System.out.println(students);

        System.out.println(students.set(3, "Wally0"));
        System.out.println(students);

        System.out.println(students.remove(students.size() - 1) + " " + students);
        System.out.println(students.remove(students.size() - 1) + " " + students);
        System.out.println(students.remove(students.size() - 1) + " " + students);
        System.out.println(students.remove(3) + " " + students);
        System.out.println(students.remove(0) + " " + students);
        System.out.println(students.remove(0) + " " + students);
        System.out.println(students.remove(0) + " " + students);
//--------------

        IntensiveList<String> people = new IntensiveArrayList_PavelSidorov<>(1);
        people.add("aaa");
        people.add("456");
        people.add("456");
        people.add("456");
        people.add("567");
        people.add("bbb");
        people.add("aaa");
        people.add("ddd");
        people.add("eee");
        people.add("fff");
        people.add("ccc");
        people.add("ccc");
        people.add("ccc");
        people.add("ggg");
        people.add("123");
        people.add("234");
        people.add("345");
        people.add("aaa");
        System.out.println("unSORTED PEOPLE " + people);
        people = IntensiveCollections_PavelSidorov.quickSort(people);
        System.out.println("SORTED PEOPLE " + people);
        System.out.println("Are People sorted? " + IntensiveAssertions_PavelSidorov.assertSort(people));
//------------------

        IntensiveList<Person> persons = new IntensiveArrayList_PavelSidorov<>(1);
        Comparator<Person> personComparator =
                Comparator
                        .nullsFirst(Comparator
                                .comparing(Person::age).reversed()
                                .thenComparing(Person::name)
                                .thenComparing(Person::birthday)
                        );

        persons.add(new Person("Person to be null", 20, LocalDate.parse("2003-06-05")));
        persons.add(new Person("Peter", 20, LocalDate.parse("2003-06-05")));
        persons.add(new Person("Jane", 25, LocalDate.parse("1998-08-01")));
        persons.add(new Person("Jack", 40, LocalDate.parse("1983-12-25")));
        persons.add(null);
        persons.set(0, null);
        persons.add(new Person("Ann", 40, LocalDate.parse("1983-11-10")));
        persons.add(new Person("Ann", 40, LocalDate.parse("1983-01-05")));

        persons = IntensiveCollections_PavelSidorov.quickSort(persons, personComparator);
        System.out.println("SORTED Persons" + persons);

        System.out.println("Are Persons sorted? " + IntensiveAssertions_PavelSidorov.assertSort(persons, personComparator));
    }

}

record Person(String name, int age, LocalDate birthday) {
    @Override
    public String toString() {
        return "\nPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

}