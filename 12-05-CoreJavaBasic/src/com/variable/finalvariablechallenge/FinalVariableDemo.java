package com.variable.finalvariablechallenge;

public class FinalVariableDemo {

    // final static variable
    //class level
    static final int STATIC_FINAL;

    // final instance variable
    final int INSTANCE_FINAL;

    // Static block
    static {
        STATIC_FINAL = 100; // initialization allowed here
        // STATIC_FINAL = 200; //if we re-initializing it will gives us an Error
        //Error:"Variable 'STATIC_FINAL' might already have been assigned to"
        }

    // Constructor for delayed initialization of instance final variable
    public FinalVariableDemo(int value) {
        this.INSTANCE_FINAL = value; // allowed
        /* this.INSTANCE_FINAL = 200;
            same here also re-initializing not possible if we try it will throws an error
            Variable 'INSTANCE_FINAL' might already have been assigned to
         */

    }

    public void demonstrateFinalLocalVariable() {

        //final local variable
        final int LOCAL_FINAL;
        LOCAL_FINAL = 300; // allowed
        // LOCAL_FINAL = 400; // Same here also
        System.out.println("Local final variable: " + LOCAL_FINAL);
    }

    /*
        Trying to reassign any final variable results in a compile-time error

        Another issues with Final Keyword  we can't inherit  class
        if we decalare method as final then we can not override it

     */

    public static void main(String[] args) {
        FinalVariableDemo obj = new FinalVariableDemo(150);

        System.out.println("Static final variable: " + FinalVariableDemo.STATIC_FINAL);
        System.out.println("Instance final variable: " + obj.INSTANCE_FINAL);

        obj.demonstrateFinalLocalVariable();


    }
}
