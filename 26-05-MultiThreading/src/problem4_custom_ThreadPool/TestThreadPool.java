package problem4_custom_ThreadPool;

public class TestThreadPool {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3,2);
        for(int taskNumber = 1 ; taskNumber <= 7; taskNumber++) {
            Thread testTask1 = new Thread("abcd_"+taskNumber);
            threadPool.submit(testTask1);
        }


    }
}

