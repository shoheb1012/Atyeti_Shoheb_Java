package com.variable.variablelifecyclesimulator;

import java.time.LocalDateTime;

public class Step {

    //Non Static or Instance Variable
    private int stepId;
    private String status;
    private long startTime;
    private int timeout;

    //Static variables
     static int totalStepsCreated=0;


    public Step(int stepId,String status,int timeout)
    {
        this.stepId = stepId;
        this.status = status;
        this.startTime = System.currentTimeMillis();
        this.timeout = timeout;
        totalStepsCreated++;
    }

    public int getStepId() {
        return stepId;
    }

    public void updateStatus(String status)
    {
        //variable shadowing
        this.status = status;
    }
    // to fetch the current Status
    public String getStatus() {
        return status;
    }




    public void impactOfNotInitializingLocalVariable()
    {
        int count = 0;

        for(int i=0;i<5;i++)
        {
            count+=i;
        }
        System.out.print(count);
        //Above logic will work fine.
        //Now we will see if we not intilize the local varible what happen

        int count1;
        for(int i=0;i<5;i++)
        {
           // count1+=i; // here it will gives an error  :"Variable 'count1' might not have been initialized";
        }
      //  System.out.println(count1);
    }

    @Override
    public String toString() {
        return "Step{" +
                "stepId=" + stepId +
                ", status='" + status + '\'' +
                ", startTime=" + startTime +
                ", timeout=" + timeout +
                '}';
    }
}
