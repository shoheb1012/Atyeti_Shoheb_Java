package filewordcounter;

import filewordcounter.service.FileProcessor;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WordCounterMain {
    public static void main(String[] args) {
        File logDirectory = new File("C:\\Users\\ShohebPathan\\Atyeti_Shoheb_Java\\POCs on Collection Multitreading Exception\\src\\filewordcounter\\resources");

        File[] files = logDirectory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null || files.length == 0) {
            System.out.println("No log files found in Directory");
            return;
        }

        FileProcessor processor = new FileProcessor();
        ExecutorService executorService = Executors.newFixedThreadPool(files.length);

        for(File file : files)
        {
            executorService.submit(()->processor.fileProcessing(file));

        }
        executorService.shutdown();

        try{
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        processor.finalSummary();

    }
}
