package practiceQuestions;

public class ThreadSafeSingletonExample {

    private static volatile ThreadSafeSingletonExample instance;

    private ThreadSafeSingletonExample(){}

    public static ThreadSafeSingletonExample getInstance()
    {
        if(instance==null)
        {
            synchronized (ThreadSafeSingletonExample.class)
            {
                instance = new ThreadSafeSingletonExample();
            }
        }
        return instance;
    }
}
