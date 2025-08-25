package practiceQuestions;

class Resource
{
    private String name;

    public Resource(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
}
public class DemonstratesDeadlockBetweenTwoThreads {

    public static void main(String[] args) {

        Resource resource1 = new Resource("resource-1");
        Resource resource2 = new Resource("resource-2");

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() +
                        " has LOCKED " + resource1.getName());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println(Thread.currentThread().getName() +
                        " is TRYING to LOCK " + resource2.getName() + " ...");

                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() +
                            " has LOCKED " + resource2.getName());
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() +
                        " has LOCKED " + resource2.getName());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println(Thread.currentThread().getName() +
                        " is TRYING to LOCK " + resource1.getName() + " ...");

                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() +
                            " has LOCKED " + resource1.getName());
                }
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }
}