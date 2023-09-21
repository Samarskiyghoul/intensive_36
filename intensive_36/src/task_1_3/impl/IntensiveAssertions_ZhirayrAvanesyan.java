package task_1_3.impl;

import task_1_1.IntensiveList;

public class IntensiveAssertions_ZhirayrAvanesyan {
    public static <E extends Comparable<E>> boolean assertSort(IntensiveList<E> list) {
        if(list == null || list.size() <= 2)
            return true;
        boolean isAsc = true;
        boolean isDesc = true;
        for(int i = 1; i < list.size(); i++){
            E current = list.get(i);
            E previous = list.get(i-1);
            if(previous.compareTo(current) < 0)
                isDesc = false;
            if(previous.compareTo(current) > 0)
                isAsc = false;
        }
        return isAsc || isDesc;
    }
}
