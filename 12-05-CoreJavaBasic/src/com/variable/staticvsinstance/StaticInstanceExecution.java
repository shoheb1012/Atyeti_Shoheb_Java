/*
Design a program where static and instance variables have the same name in different contexts.
 Modify them in various static and non-static methods. Track their changes across multiple objects.
 */

package com.variable.staticvsinstance;

public class StaticInstanceExecution {


        static int value = 5;
        int instanceValue = 10;

        public static void staticChange() {
            value++;
          //  instanceValue++;  //in static method instance variable not allowed beacuse the static is a JVM first layer data before object creation it in invoke
        }

        public void instanceChange() {
            value += 5;    //but in instance method we can decalare a staic variable
            instanceValue++;
        }

        public static void main(String[] args) {
            StaticInstanceExecution staticInstanceExecution = new StaticInstanceExecution();
            StaticInstanceExecution staticInstanceExecution1 = new StaticInstanceExecution();

            staticInstanceExecution1.instanceChange();
            StaticInstanceExecution.staticChange();
            System.out.println("Static: " + StaticInstanceExecution.value);
            System.out.println("Instance : " + staticInstanceExecution.value);
        }
    }


