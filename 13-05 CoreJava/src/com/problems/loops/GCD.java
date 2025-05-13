package com.problems.loops;

import java.util.ArrayList;

public class GCD {


    //* Input: `36, 60`
    //   * Output: `12`
    public static int findGCD(int number1 , int number2)
    {
        int gcd=0;
        for (int i=1;i<=Math.min(number1,number2);i++)
        {
           if(number1%i==0 && number2%i==0)
           {
               gcd=i;
           }
        }
        return gcd;
    }

    public static void main(String[] args) {
        int gcd = findGCD(36, 60);
        System.out.println(gcd);
    }
}
