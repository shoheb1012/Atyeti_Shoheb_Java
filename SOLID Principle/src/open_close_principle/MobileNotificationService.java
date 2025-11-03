package open_close_principle;

public class MobileNotificationService implements NotificationService{

    @Override
    public void sendOtp(String medium) {
        //integrate logic for any third party api which can send text to the mobile
    }

    @Override
    public void sendTransactionReport(String medium) {
        //integrate logic for any third party api which can send text to the mobile
    }
}
