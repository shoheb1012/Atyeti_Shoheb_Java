package dependency_inversion_principle;

public class ShoppingMall {

    private BankingCard bankingCard;

    public ShoppingMall(BankingCard bankingCard){
        this.bankingCard=bankingCard;
    }

    public void doPurchaseSomething(long amount)
    {
        bankingCard.doTranscation(amount);
    }

    public static void main(String[] args) {

        BankingCard creditCard = new CreditCard();
        BankingCard debitCard = new DebitCard();
        ShoppingMall shoppingWithCreditCard = new ShoppingMall(creditCard);
        ShoppingMall shoppingWithdebitCard = new ShoppingMall(debitCard);

        shoppingWithdebitCard.doPurchaseSomething(1200);
        shoppingWithCreditCard.doPurchaseSomething(800);

    }
}
