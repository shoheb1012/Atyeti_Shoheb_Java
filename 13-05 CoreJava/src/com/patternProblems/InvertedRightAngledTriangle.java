package com.patternProblems;
/*
     *****
     ****
     ***
     **
     *

 */
public class InvertedRightAngledTriangle {

    public static void main(String[] args) {

        int n =5;

        for(int i=1;i<=n;i++)
        {
            for(int j=n;j>=i;j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
