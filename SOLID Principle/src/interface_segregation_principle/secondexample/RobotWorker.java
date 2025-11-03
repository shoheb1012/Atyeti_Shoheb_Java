package interface_segregation_principle.secondexample;

public class RobotWorker implements Worker{
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
/*
   here we are forcing this class to implement all method even robot cannot eat right
 */
