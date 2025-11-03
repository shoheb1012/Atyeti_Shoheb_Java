package interface_segregation_principle;

public class Paytm implements UPIPayments{
    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

//    @Override
//    public void getCashBackAsCreditBalance() {
////paytm also not support this feature
//    }
}
/*
problem is we are forcing the class to override all the method from the interface which will not good
 */