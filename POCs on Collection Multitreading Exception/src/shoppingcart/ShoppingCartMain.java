package shoppingcart;

import shoppingcart.service.ShoppingCart;
import shoppingcart.task.AddToCartTask;
import shoppingcart.task.CheckoutTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShoppingCartMain {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ShoppingCart shoppingCart = new ShoppingCart();


        executorService.submit(new AddToCartTask(shoppingCart));
        executorService.submit(new CheckoutTask(shoppingCart));

        executorService.shutdown();

        executorService.awaitTermination(5, TimeUnit.MINUTES);

        shoppingCart.showCart();

    }
}
