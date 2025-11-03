package single_responsibility_principle;

public class NotificationService {
    public void sendOtp(String medium)
    {
        if(medium.equals("mail"))
        {
            //Mail sender logic
        } else if (medium.equals("phone")) {
            //twillio otp sender logic
        }
    }
}
