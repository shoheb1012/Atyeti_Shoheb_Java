package com.problems.loops;

public class FirstNPrimes {

    public static void printFirstNPrimes(int number) {
        int count = 0;
        int num = 2;

        while (count < number) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
    }


    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("First " + n + " prime numbers are:");
        printFirstNPrimes(n);
    }
}
