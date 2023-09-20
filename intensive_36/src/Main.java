import task_1_1.IntensiveList;
import task_1_1.impl.IntensiveArrayList_PavelSidorov;
import task_1_2.impl.IntensiveCollections_PavelSidorov;

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

        IntensiveList<String> people = new IntensiveArrayList_PavelSidorov<>(1);
//        List<String> people = new ArrayList<>();

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
//        Collections.sort(people);
//        System.out.println("SORTED PEOPLE " + people);
        System.out.println("SORTED PEOPLE " + IntensiveCollections_PavelSidorov.quickSort(people));

    }
}