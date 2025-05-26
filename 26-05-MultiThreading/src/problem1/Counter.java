package problem1;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    AtomicInteger counting= new AtomicInteger(0);
    public  void sharedIntegerCounter()
    {
        for(int i =1;i<=1000;i++)
        {
            counting.incrementAndGet();
        }
    }

    public int getCounting() {
        return counting.get();
    }
}
