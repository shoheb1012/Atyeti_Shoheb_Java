package BankApplication.exceptions;

/*
      Unchechekd Exception
 */
public class UserDefinedException extends RuntimeException {

    public UserDefinedException() {

    }

    /*
         Constructor Overloading if User want through Exception with Some msg then we will use Parameterized Constructior
         or else we uysing no argument Constructor
     */
    public UserDefinedException(String msg) {
        super(msg);
    }
}
