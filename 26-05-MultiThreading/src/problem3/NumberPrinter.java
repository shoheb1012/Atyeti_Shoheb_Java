package problem3;

import java.util.logging.Logger;

public class NumberPrinter {
    private int maxNumber;
    private int number = 1;
    Logger logger = Logger.getLogger(NumberPrinter.class.getName());

    public NumberPrinter(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public synchronized void printOddNumber() {
        while (number <= maxNumber) {
            if (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    logger.warning(e.getMessage());
                }
            } else {
                System.out.println("Odd Thread " + number++);
                notify();
            }
        }
    }

    public synchronized void printEvenNumber() {
        while (number <= maxNumber) {
            if (number % 2 != 0) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    logger.warning(e.getMessage());
                }
            }
            else {
                System.out.println("Even Thread " + number++);
                notify();
            }
        }
    }
}
