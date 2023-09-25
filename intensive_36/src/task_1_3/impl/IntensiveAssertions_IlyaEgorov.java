package task_1_3.impl;

import task_1_1.IntensiveList;

public class IntensiveAssertions_IlyaEgorov {

    public static <Type extends Comparable<Type>> boolean assertSort(IntensiveList<Type> list) {

        // Если лист мал, то вернуть сразу тру
        if(list == null || list.size() <= 2) {
            return true;
        }

        boolean asc = true;
        boolean desc = true;

        for(int i = 1; i < list.size(); i++) {
            Type current = list.get(i);
            Type previous = list.get(i - 1);
            if(previous.compareTo(current) < 0) {
                desc = false;
            }
            if(previous.compareTo(current) > 0) {
                asc = false;
            }
        }

        return asc || desc;
    }
}