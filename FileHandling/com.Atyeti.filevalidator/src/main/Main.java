package main;

import config.Config;
import processor.FileValidationProcessor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        File logDirectory = new File(Config.directory);

        File[] files = logDirectory.listFiles();

        ExecutorService executorService = Executors.newFixedThreadPool(files.length);

        // System.out.println(files.length);
        List<Future> futures = new ArrayList<>();

        for(File file : files)
        {

            Future<?> submit = executorService.submit(() -> FileValidationProcessor.process(file));
            futures.add(submit);
            // System.out.println(file.getName());
        }
        executorService.shutdown();

        for(Future future: futures)
        {
            future.get();
        }
        //  executorService.awaitTermination(5, TimeUnit.MINUTES);
    }
}
