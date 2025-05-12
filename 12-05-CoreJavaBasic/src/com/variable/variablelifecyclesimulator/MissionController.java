package com.variable.variablelifecyclesimulator;

import java.time.LocalDate;

import static com.variable.variablelifecyclesimulator.Step.totalStepsCreated;

public class MissionController {
    public static void main(String[] args) {

        System.out.println("Mission Started...");

        // Creating 5 Step objects
        for (int i = 1; i <= 5; i++) {

            // Demonstrate variable shadowing
            int stepId = i;
            String status = "PENDING";

            // Shadowing stepId inside a nested block
             /*
              instance block it will exceute before the Constructor
              in constructor first line is reserve for instance block
              so we can modify variable on object creation
            */
            {
                int stepIdShadow = stepId + 100; // New variable, not shadowing
                String statusShadow = "Working";
                System.out.println("Inside Nested Block => stepIdShadow: " + stepIdShadow + ", statusShadow: " + statusShadow);
            }

            //step instance
            Step step = new Step(stepId, status, Config.DEFAULT_TIMEOUT); // timeout increases per step
            System.out.println(step);

            // Increment static counter


        }

        System.out.println("Total Steps Created: " + totalStepsCreated);

        System.out.println("==================================================");

        //Config
        LocalDate localDate = Config.loadLocalDate();

    }

}
