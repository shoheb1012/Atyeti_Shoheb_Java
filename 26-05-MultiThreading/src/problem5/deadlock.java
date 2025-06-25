package problem5;

public class deadlock {

    public static void main(String[] args) throws InterruptedException {

        String name = Thread.currentThread().getName();
        System.out.println(name+" Running ");

        Thread.currentThread().join();

        Thread.interrupted();


        System.out.println("Main thread completed ");


    }
}
