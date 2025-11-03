package single_responsibility_principle;

public class LoanService {

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
}
