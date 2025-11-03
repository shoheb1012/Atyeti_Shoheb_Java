package open_close_principle;

public class EmailNotificationService implements NotificationService{
    @Override
    public void sendOtp(String medium) {
        //integration with mail sender
    }

    @Override
    public void sendTransactionReport(String medium) {
        //integration with mail sender
    }
}

