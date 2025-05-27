package problem4_custom_ThreadPool;

public class TestThreadPool {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3,2);

           MyThread thread = new MyThread();
                threadPool.submit(thread);


    }
}

