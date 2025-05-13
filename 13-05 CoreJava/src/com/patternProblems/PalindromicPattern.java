package com.patternProblems;
/*
       1
      212
     32123
    4321234
   543212345
 */
public class PalindromicPattern {

    public static void main(String[] args) {

        int n=5;
        for(int i=1;i<=n;i++)
        {
            int space = n-i;
            for(int j=1;j<=space;j++)
            {
                System.out.print(" ");
            }

            for(int j=i;j>=1;j--)
            {
                System.out.print(j);
            }

            for(int j=2;j<=i;j++)
            {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}
