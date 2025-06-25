package shoppingcart.service;

import shoppingcart.exception.ItemNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCart {

    private final Map<String,Integer> cartItems = new HashMap<>();

    public synchronized void addItemToCart(String itemName,int itemQty)
    {
        cartItems.put(itemName,cartItems.getOrDefault(itemName,0)+itemQty);
        System.out.println("Added " + itemQty +" "+itemName + " to cart.");
    }

    public synchronized void removeItemFromCart(String itemName, int itemQty)
    {
        if(!cartItems.containsKey(itemName)||cartItems.get(itemName)<itemQty)
        {
            throw new ItemNotFoundException("Cannot checkout " + itemQty + " x " + itemName + ": Not enough quantity or item missing!");
        }

        cartItems.put(itemName,cartItems.get(itemName)-itemQty);
        System.out.println("Checked out " + itemQty + " x " + itemName);
    }

    public void showCart()
    {
        System.out.println("Remaining Cart Items:");
        Set<Map.Entry<String, Integer>> entries = cartItems.entrySet();
        for(Map.Entry<String,Integer>entry:entries)
        {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}
