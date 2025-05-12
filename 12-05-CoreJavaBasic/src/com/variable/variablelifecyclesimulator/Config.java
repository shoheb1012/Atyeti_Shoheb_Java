package com.variable.variablelifecyclesimulator;

import java.time.LocalDate;

public class Config {

    /*
       Constant variable should be initialize at the time of declaration or else it will through and error
     */
    private final static int MAX_STEPS = 10;
    final static int DEFAULT_TIMEOUT = 1000;
    private final static LocalDate GETLOCALDATE = loadLocalDate();  //Initilazing GETLOCALDATE variable with static loadLocalDate method
    private final static int x;

    /*
     static block it will execute before the instance block and class constructor
     in JVM first layer there is loaders so while class is loading by the Application Loader
     once class loaded the static block will be executed
     */
    static {
        System.out.println("Max Steps : " + MAX_STEPS + "\nDefault Timeout : " + DEFAULT_TIMEOUT);
        System.out.println("Local Date : " + GETLOCALDATE);
        x = 10;
    }

    public static LocalDate loadLocalDate() {

        return LocalDate.now();
    }

}
