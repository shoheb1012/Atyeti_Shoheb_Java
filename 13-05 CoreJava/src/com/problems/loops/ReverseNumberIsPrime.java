package com.problems.loops;

public class ReverseNumberIsPrime {

    public static int reverseNumber(int number) {
        int rev = 0;
        while (number > 0) {
            int rem = number % 10;
            rev = rev * 10 + rem;
            number = number / 10;
        }
        return rev;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int original = 23;
        int reversed = reverseNumber(original);

        System.out.println("Reversed number: " + reversed);

        if (isPrime(reversed)) {
            System.out.println(reversed + " is Prime.");
        } else {
            System.out.println(reversed + " is Not Prime.");
        }
    }
}
