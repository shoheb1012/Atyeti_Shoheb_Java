package open_close_principle;

public interface NotificationService {

    public void sendOtp(String medium);
    public void sendTransactionReport(String medium);
}
//this interface open for any future implementation like emailNotification or mobile or whatsapp notification we need to implement our code like a anyone can reuse it with their requirements and no need to modify just extend
//if any service want we can use it instead of modfiyin it thats all about open closed principle