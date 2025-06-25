package shoppingcart.task;

import shoppingcart.service.ShoppingCart;

public class AddToCartTask implements Runnable{

     final ShoppingCart shoppingCart;

    public AddToCartTask(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void run() {

            shoppingCart.addItemToCart("Apple", 4);
            shoppingCart.addItemToCart("Banana", 2);
            shoppingCart.addItemToCart("Milk", 1);
            shoppingCart.addItemToCart("Mango", 10);
            shoppingCart.addItemToCart("Fan", 5);
            shoppingCart.addItemToCart("tv", 2);

    }
}
