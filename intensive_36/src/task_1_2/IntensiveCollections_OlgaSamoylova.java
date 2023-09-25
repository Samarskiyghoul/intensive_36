package task_1_2;

import task_1_1.IntensiveArrayList_OlgaSamoylova;
import task_1_1.IntensiveList;

import java.util.Comparator;

/**
 * Quick sort for IntensiveList
 * @author Olga Samoylova
 */
public class IntensiveCollections_OlgaSamoylova {

    /**
     * Быстрая сортировка IntensiveList
     * @param list
     * @return отсортированный лист
     */
    public static IntensiveList quickSort(IntensiveList<? extends Comparable> list){

        IntensiveList<? extends Comparable> lessList = new IntensiveArrayList_OlgaSamoylova(list.size());
        IntensiveList<? extends Comparable> moreList = new IntensiveArrayList_OlgaSamoylova(list.size());
        Object supportItem = list.get(list.size()/2);

        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1.equals(o2)) {
                    return 0;
                } else if (o1.hashCode() < o2.hashCode()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };


        if (list.size() > 1){

            for (int i = 0; i<list.size(); i++){
                if (c.compare(list.get(i), supportItem) < 0){
                    lessList.add(list.get(i));
                }
                else if (c.compare(list.get(i), supportItem) > 0){
                    moreList.add(list.get(i));
                }
            }

            if (lessList.size() > 1){
                lessList = quickSort(lessList);
            }

            if(moreList.size()>1){
                moreList = quickSort(moreList);
            }

            lessList.add(supportItem);
            for (int i = 0; i< moreList.size(); i++){
                lessList.add(moreList.get(i));
            }

            return lessList;
        }

        else{
            return list;
        }


    }
}
