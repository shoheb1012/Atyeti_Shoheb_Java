package problem5;

public class ZomatoProblem {

        public static void main(String[] args) {


            Thread deliveryGuy = new Thread(() -> {
                try {
                    System.out.println(" Delivery guy is waiting at restaurant...");
                    Thread.sleep(10000);

                    System.out.println("🍔 Got the food, on the way!");
                } catch (InterruptedException e) {
                    System.out.println(" Order canceled! Delivery guy stops waiting.");
                }
            });


            deliveryGuy.start();



            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
            }

            System.out.println(" User canceled the order!");
            deliveryGuy.interrupt();

        }
    }


