package com.patternProblems;
/*
     *
     **
     ***
     ****
     *****

 */
public class RightAngledTriangle  {
    public static void main(String[] args) {
        int n =5;

        for(int i=1;i<=n;i++)
        {
            for(int j=i;j>0;j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
