/**
 *This class contains the details of each individual loan/debt.
 @author Hoang Nguyen
 @version v1.0.0
 */
public class Debt
{
    private int loan;
    private int borrowed;
    private int timeLeft;

    /**
     *The default constructor creates an empty loan.
     */
    public Debt()
    {
        loan = 0;
        borrowed = 0;
        timeLeft = 3;
    }

    /**
     *Non-default constructor creates a loan with the amount specified in the parameter.
     *@param borrowed        An integer specifying the amount to be borrowed.
     */
    public Debt(int borrowed)
    {
        this.borrowed = borrowed;
        this.loan = (int) Math.round(borrowed * 1.5);
        timeLeft = 3;
    }

    /**
     *Method to reduce time left to pay back loan by 1.
     */
    public void decrementTimeLeft()
    {
        if (timeLeft > 0)
            timeLeft --;
    }

    /**
     *Accessor method to get amount borrowed.
     *@return        Returns an integer specifying the amount borrowed.
     */
    public int getBorrowed()
    {
        return borrowed;
    }

    /**
     *Accessor method to get amount owed.
     *@return        Returns an integer specifying the owed.
     */
    public int getLoan()
    {
        return loan;
    }

    /**
     *Accessor method to get time left to pay back loan.
     *@return        Returns an integer specifying the time left to pay back loan.
     */
    public int getTimeLeft()
    {
        return timeLeft;
    }

    /**
     *Mutator method to set amount borrowed.
     *@param borrowed         Accepts an integer specifying amount borrowed.
     */
    public void setBorrowed(int borrowed)
    {
        this.borrowed = borrowed;
    }

    /**
     *Mutator method to set amount owed.
     *@param loan         Accepts an integer specifying amount owed.
     */
    public void setLoan(int loan)
    {
        this.loan = loan;
    }

    /**
     *Mutator method to set time left to pay back loan.
     *@param timeLeft         Accepts an integer specifying number of time left to pay back loan.
     */
    public void setTimeLeft(int timeLeft)
    {
        this.timeLeft = timeLeft;
    }
}