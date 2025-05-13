package com.problems.loops;


public class MagicNumber {

    public static boolean isMagicNumber(int number) {
        int sum = number;

        while (sum > 9) {
            int temp = sum;
            sum = 0;

            // Sum the digits
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
        }

        return sum == 1;
    }

    public static void main(String[] args) {
        int num = 1729;

        if (isMagicNumber(num)) {
            System.out.println(num + " is a Magic Number");
        } else {
            System.out.println(num + " is not a Magic Number");
        }
    }
}

