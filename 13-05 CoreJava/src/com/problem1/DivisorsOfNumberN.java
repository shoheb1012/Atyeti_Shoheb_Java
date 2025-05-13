package com.problem1;

import java.util.ArrayList;

public class DivisorsOfNumberN {

        public static ArrayList<Integer> getAllDivisors(int n){

            ArrayList<Integer> listOfDivisors = new ArrayList<>();

            for(int i=1;i<=n;i++)
            {
                if(n%i==0)
                {
                    listOfDivisors.add(i);
                }
            }
            listOfDivisors.sort((x,y)->x-y);
            return listOfDivisors;
        }

    public static void main(String[] args) {
        ArrayList<Integer> allDivisors = getAllDivisors(10);
        System.out.println(allDivisors);

        ArrayList<Integer> allDivisors1 = getAllDivisors(100);
        System.out.println(allDivisors1);
    }
    }



