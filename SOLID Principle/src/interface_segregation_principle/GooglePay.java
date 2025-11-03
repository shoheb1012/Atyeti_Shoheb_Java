package interface_segregation_principle;

import interface_segregation_principle.solution.CashBackManger;

public class GooglePay implements UPIPayments, CashBackManger {
    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

    @Override
    public void getCashBackAsCreditBalance() {

    }


    //all above feature supports by the gpay
}
