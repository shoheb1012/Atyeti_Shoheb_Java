package single_responsibility_principle;

public class BankService {

    public void credit()
    {
        //credit logic
    }
    public void debit()
    {
        //debit logic
    }
    public void printPassBook()
    {
        //printer logic
    }
    public void sendOtp(String medium)
    {
        if(medium.equals("mail"))
        {
            //Mail sender logic
        } else if (medium.equals("phone")) {
            //twillio otp sender logic
        }
    }

    public void getLoanInterestInfo(String loanType)
    {
        if(loanType.equals("home"))
        {
            //logic for home loan info
        } else if (loanType.equals("personal")) {
            //personal loan info

        }
        //or study loan or gold loan etc
    }
  /*tommorow this class might enhance for study loan or gold loan or send otp as other third party api or need chnages in printing logic
    so if we change this 3-4 implemnetion in sam class it is not following single responsibiltiy principle then the solution is make a class with single responsibilties means their own implemnetation
    example loanService for loan realted responsibilities printter service for the print responsibilities lets create this classses */

}

