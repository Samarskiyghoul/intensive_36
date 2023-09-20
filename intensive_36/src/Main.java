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

        System.out.println(students.set(1, "Wally1"));
        System.out.println(students);

        System.out.println(students.set(2, "Wally2"));
        System.out.println(students);

        System.out.println(students.set(3, "Wally3"));
        System.out.println(students);

        System.out.println(students.remove(students.size() - 1) + " " + students);
        System.out.println(students.remove(students.size() - 1) + " " + students);
        System.out.println(students.remove(students.size() - 1) + " " + students);
        System.out.println(students.remove(3) + " " + students);
        System.out.println(students.remove(0) + " " + students);
        System.out.println(students.remove(0) + " " + students);
        System.out.println(students.remove(0) + " " + students);

    }
}