package shoppingcart.exception;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String msg) {
        super(msg);
    }
}
