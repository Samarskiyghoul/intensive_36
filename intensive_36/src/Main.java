import task_1_1.IntensiveList;
import task_1_1.impl.IntensiveArrayList_ZhirayrAvanesyan;
import task_1_2.impl.IntensiveCollections_ZhirayrAvanesyan;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {System.out.println("Hello world!");
        IntensiveList<String> list = new IntensiveArrayList_ZhirayrAvanesyan<>();
        list.add("john");
        list.add("Bob");
        list.add("Garry");
        list.add("Alex");
        list = IntensiveCollections_ZhirayrAvanesyan.quickSort(list);
        for ( int i = 0; i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}