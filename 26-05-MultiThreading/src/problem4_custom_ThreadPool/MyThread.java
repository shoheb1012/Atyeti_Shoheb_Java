package problem4_custom_ThreadPool;

public class MyThread implements Runnable{

    @Override
    public void run()
    {
        for(int i =0;i<3;i++)
        {
            System.out.println("mythread");
        }
    }
}
