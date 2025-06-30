package day2_LinkedList;

import java.util.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {

        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        LinkedList<Integer> reversed = new LinkedList<>();
        for (Integer val : integers) {
            reversed.addFirst(val);
        }
        System.out.println(reversed);

        for (int i = 0, j = integers.size() - 1; i < j; i++, j--) {
            Integer temp = integers.get(i);
            integers.set(i, integers.get(j));
            integers.set(j, temp);
        }
        System.out.println(integers);



    }
}
