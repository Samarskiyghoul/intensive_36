package task_1_2;

import task_1_1.impl.IntensiveArrayList_AntonTeslia;

public class Test {
    public static void main(String[] args) {
        IntensiveArrayList_AntonTeslia<Integer> list= new IntensiveArrayList_AntonTeslia<>(6);
        list.add(1);
        list.add(100);
        list.add(80);
        list.add(55);
        list.add(85);
        list.add(10);
        System.out.println(list);

        IntensiveCollections_AntonTeslia.quickSort(list);
        System.out.println(list);

    }
}
