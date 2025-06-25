package filewordcounter.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class FileProcessor {

    ConcurrentMap<String, Integer> wordCounts = new ConcurrentHashMap<>();

    public  void fileProcessing(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Integer wordCount = 0;
            while ((line = br.readLine())!= null) {

                String[] split = line.trim().split(" ");
                for(String word : split)
                {
                    if(!word.isEmpty())
                    {
                        wordCount++;
                    }
                }

            }
            wordCounts.put(file.getName(), wordCount);
            System.out.println("Processed " + file.getName() + ": " + wordCount + " words");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void finalSummary() {
        System.out.println("Final Word Count Summary:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " words");
        }
    }
}
