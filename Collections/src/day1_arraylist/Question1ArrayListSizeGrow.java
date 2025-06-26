package day1_arraylist;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Question1ArrayListSizeGrow {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int approxCapacity = 10;


        for (int i = 0; i < 100; i++) {
            list.add(i);

            if (i == approxCapacity) {
                System.out.println("Approximate capacity increased to: " + approxCapacity);
                approxCapacity = approxCapacity + (approxCapacity/2);
            }
        }
    }
}
