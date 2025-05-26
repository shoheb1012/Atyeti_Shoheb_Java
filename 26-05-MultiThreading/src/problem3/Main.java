package problem3;

public class Main
{
    public static void main(String[] args) {

        NumberPrinter numberPrinter = new NumberPrinter(20);

        Thread oddThread = new Thread(()->
        {
            numberPrinter.printOddNumber();
        });

        Thread evenThread = new Thread(()->
        {
            numberPrinter.printEvenNumber();
        });
        oddThread.start();
        evenThread.start();

    }
}