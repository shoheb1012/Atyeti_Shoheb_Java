package dependency_inversion_principle;

public class DebitCard implements BankingCard{
    @Override
    public void doTranscation(double amount) {
        System.out.println("Payment through debitCard");
    }
}
