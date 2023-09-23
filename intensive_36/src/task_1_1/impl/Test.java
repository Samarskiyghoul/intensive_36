package task_1_1.impl;

public class Test {
    public static void main(String[] args) {
        IntensiveArrayList_AntonTeslia<String> s = new IntensiveArrayList_AntonTeslia<String>();
        s.add("1");
        s.add("2");
        s.add("3");
        System.out.println("size: " + s.size());

        System.out.println("get[0]: " + s.set(0, "5") + " /after set(0, 5): " + s.get(0));

        s.add(3, "4");
        System.out.println("get[3]: " + s.get(3) + " after add size: " + s.size());

        s.remove(0);
        System.out.println("before remove: " + s.remove(0) + " after remove: " + s.get(0));

        s.removeAll();
        System.out.println("after remove all size: " + s.size() + ", get[0]: " + s.get(0));
    }
}
