package interface_segregation_principle.secondexample.solution;

import interface_segregation_principle.secondexample.Worker;

public class HumanWorker implements Eatable,Workable,Sleepable {
    @Override
    public void eat() {

    }

    @Override
    public void work() {

    }

    @Override
    public void sleep() {

    }
}
