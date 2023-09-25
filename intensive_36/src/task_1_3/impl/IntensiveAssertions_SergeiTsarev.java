package task_1_3.impl;

import task_1_1.IntensiveList;
public class IntensiveAssertions_SergeiTsarev {

    public static <E extends Comparable<E>> boolean assertSort(IntensiveList<E> list){
        if(list != null || list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).compareTo(list.get(i+1)) > 0){
                    return false;
                }
            }
        }
        return true;
    }
}
