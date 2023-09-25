package task_1_2.impl;

import task_1_1.IntensiveList;
import task_1_1.impl.IntensiveArrayList_SergeiTsarev;

import java.util.Comparator;

public class IntensiveCollections_SergeiTsarev {

    private static <E extends Comparable<E>> IntensiveList<E> quickSort(IntensiveList<E> list) {
        if(list == null || list.size() <=1){
            return list;
        }

        int pivotIndex = (0 + list.size()) / 2;
        E pivot = list.get(pivotIndex);

        IntensiveList<E> less = new IntensiveArrayList_SergeiTsarev<>();
        IntensiveList<E> equal = new IntensiveArrayList_SergeiTsarev<>();
        IntensiveList<E> greater = new IntensiveArrayList_SergeiTsarev<>();

        for(int i = 0; i < list.size(); i++) {
            E element = (E) list.get(i);
            int compare = element.compareTo(pivot);

            if(compare > 0){
                greater.add(element);
            }
            else if (compare < 0){
                less.add(element);
            }
            else{
                equal.add(element);
            }
        }
        IntensiveList<E> left = quickSort(less);
        IntensiveList<E> right = quickSort(greater);

        IntensiveList<E> result = new IntensiveArrayList_SergeiTsarev<>();

        for (int i = 0; i < left.size(); i++){
            result.add(left.get(i));
        }
        for (int i = 0; i < equal.size(); i++){
            result.add(equal.get(i));
        }
        for (int i = 0; i < right.size(); i++){
            result.add(left.get(i));
        }
        return result;
        }
    }
