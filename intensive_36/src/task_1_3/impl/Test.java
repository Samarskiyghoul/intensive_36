package task_1_3.impl;

import task_1_1.impl.IntensiveArrayList_AntonTeslia;

public class Test {
    public static void main(String[] args) {
        IntensiveArrayList_AntonTeslia<Integer> list = new IntensiveArrayList_AntonTeslia<>(6);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        System.out.println(list);
        System.out.println(IntensiveAssertions_AntonTeslia.assertSort(list));

        list.set(3, 100);
        System.out.println(list);
        System.out.println(IntensiveAssertions_AntonTeslia.assertSort(list));
    }
}
