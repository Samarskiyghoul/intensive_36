import task_1_1.IntensiveList;
import task_1_1.impl.IntensiveArrayList_BogdanEfremenko;
import task_1_2.imlp.IntensiveCollections_BogdanEfremenko;
import task_1_3.impl.IntensiveAssertions_BogdanEfremenko;

public class Main {

    public static void main(String[] args) {

        IntensiveList<Integer> listExample = new IntensiveArrayList_BogdanEfremenko<>();


        listExample.add(5);
        listExample.add(3);
        listExample.add(8);
        listExample.add(3,6);
        listExample.set(0,666);
        System.out.println(listExample.get(0));
        listExample.remove(0);


        IntensiveCollections_BogdanEfremenko.quickSort(listExample);
        System.out.println(IntensiveAssertions_BogdanEfremenko.assertSort(listExample));

        listExample.display();
        System.out.println(listExample);

        listExample.removeAll();


    }
}