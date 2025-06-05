import java.io.IOException;

public class Scenario4 {

    //ExceptionInInitializerError
    static
    {
        if(true)
        {
            throw new RuntimeException("Unchecked Exception");
        }

    }
  //  Here static block will be execute beofore the main method
 //program will failed at class Loading
    public static void main(String[] args) {

    }
}
