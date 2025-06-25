package shoppingcart.task;

import shoppingcart.exception.ItemNotFoundException;
import shoppingcart.service.ShoppingCart;

public class CheckoutTask implements Runnable {

    private final ShoppingCart shoppingCart;

    public CheckoutTask(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            shoppingCart.removeItemFromCart("Apple", 2);
            shoppingCart.removeItemFromCart("Milk", 1);
            shoppingCart.removeItemFromCart("Mango", 5);
            shoppingCart.removeItemFromCart("Eggs", 1);
        } catch (ItemNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}

