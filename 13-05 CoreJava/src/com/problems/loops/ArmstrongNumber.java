/*
    problem :
    A number is Armstrong if sum of its digits raised to the power of number of digits equals the number.
    Input: 153 → 1³ + 5³ + 3³ = 153
    Output: Armstrong
 */
package com.problems.loops;

public class ArmstrongNumber {

    public static String isArmstrongNumber(int number)
    {
        int sum=0;
        int digit=0;
        int num=number;

        while (num>0)
        {
            num/=10;
            digit++;
        }
       num=number;
        while (num>0)
        {
            int temp=num%10;
            double temp1 = Math.pow(temp, digit);
            sum+=temp1;
            num/=10;
        }
        if(number==sum)
        {
            return "Number is ArmstrongNumber";
        }
        return "Number is not ArmstrongNumber";
    }

    public static void main(String[] args) {
        String armstrongNumber = isArmstrongNumber(153);
        System.out.println(armstrongNumber);
    }
}
