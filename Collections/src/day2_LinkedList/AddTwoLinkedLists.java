package day2_LinkedList;

import java.util.*;

public class AddTwoLinkedLists {

    public static LinkedList<Integer> addTwoLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;


        Iterator<Integer> it1 = l1.iterator();
        Iterator<Integer> it2 = l2.iterator();

        while (it1.hasNext() || it2.hasNext() || carry > 0) {
            int sum = carry;

            if (it1.hasNext()) {
                sum += it1.next();
            }

            if (it2.hasNext()) {
                sum += it2.next();
            }

            result.add(sum % 10);
            carry = sum / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> num1 = new LinkedList<>(Arrays.asList(2, 4, 3));
        LinkedList<Integer> num2 = new LinkedList<>(Arrays.asList(5, 6, 4));

        LinkedList<Integer> result = addTwoLists(num1, num2);

        System.out.print("Result: ");
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}

