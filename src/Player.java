import java.util.ArrayList;
import java.util.Iterator;
/**
 *This class contains details of the Player in the Java Penguin Hunter program
 *@author Hoang Nguyen
 *@version v1.0.0
 */
public class Player
{
    private String name;
    private int turn;
    private int mode;
    private int turnPlay;
    private int fishGuess;
    private boolean gameEnd;
    ArrayList<Debt> debts;

    /**
     *The default constructor, generates a basic player named Oggy
     */
    public Player()
    {
        name = "Oggy";
        turn = 1;
        mode = 0;
        turnPlay = 0;
        fishGuess = 0;
        gameEnd = false;
        debts = new ArrayList<Debt>();
    }

    /**
     *The non-default constructor, generates a basic player with a specified name
     *@param name       The name of player.
     */
    public Player(String name)
    {
        this.name = name;
        turn = 1;
        mode = 0;
        turnPlay = 0;
        fishGuess = 0;
        gameEnd = false;
        debts = new ArrayList<Debt>();
    }

    /**
     *Method to add loan to the debts collection.
     *@param amount          Amount of fish player wishes to loan as an integer.
     @return                 Returns the amount successfully loaned as an integer.
     */
    public int addLoan(int amount)
    {
        int amountLoaned = 0;
        if (amount <= 30 && amount >= 0)
        {
            if (getTotalBorrowed() + amount <= 100)
            {
                Debt newLoan = new Debt(amount);
                debts.add(newLoan);
                amountLoaned = amount;
            }
            else
                System.out.println("Cannot borrow more than 100 fish. You have already borrowed: " + getTotalBorrowed() + " fish");
        }
        else
        {
            System.out.println("Can only borrow between 0 to 30 fish at any one time.");
        }
        return amountLoaned;
    }

    /**
     *Method to increment the current turn count by one.
     */
    public void addTurn()
    {
        turn++;
    }

    /**
     *Accessor method to check whether the game has ended.
     @return     Indicates whether the game has ended as a boolean.
     */
    public boolean getGameEnd()
    {
        return gameEnd;
    }

    /**
     *Method to get debt/loans owed today
     *@return        Returns number of fish owed today.
     */
    public int getDebtToday()
    {
        Iterator<Debt> it = debts.iterator();
        Debt tmpDebt = new Debt();
        int debtToday = 0;
        while (it.hasNext())
        {
            tmpDebt = it.next();
            if (tmpDebt.getTimeLeft() <= 0)
            {
                debtToday += tmpDebt.getLoan();
            }
        }
        return debtToday;
    }

    /**
     *Method to get total fish owed.
     *@return        Returns number of fish owed in total.
     */
    public int getDebtTotal()
    {
        int debtTotal = 0;
        for (Debt tmp : debts)
        {
            debtTotal += tmp.getLoan();
        }
        return debtTotal;
    }

    /**
     *Accessor method to get number of fish guessed at the start of game.
     *@return        Returns number of fish guessed at the start of game.
     */
    public int getFishGuess()
    {
        return fishGuess;
    }

    /**
     *Accessor method to get the current game mode
     *@return        Returns the current game mode as an integer.
     *1 means Arcade, 2 means Story Mode.
     */
    public int getMode()
    {
        return mode;
    }

    /**
     *Accessor method to get the name of player
     *@return        Returns player name as a string
     */
    public String getName()
    {
        return name;
    }

    /**
     *Method to get total number of fish borrowed
     *@return        Returns an integer for the number of fish borrowed (but not owed!)
     */
    public int getTotalBorrowed()
    {
        int totalBorrowed = 0;
        for (Debt tmp : debts)
        {
            totalBorrowed += tmp.getBorrowed();
        }
        return totalBorrowed;
    }

    /**
     *Accessor method to get current turn number.
     *@return        Returns current turn as an integer.
     */
    public int getTurn()
    {
        return turn;
    }

    /**
     *Accessor method to get number of turns to play specified at start of game
     *@return        Returns number of turns to play as an integer.
     */
    public int getTurnPlay()
    {
        return turnPlay;
    }

    /**
     *This method removes all debts in the debts collection.
     */
    public void removeAllDebts()
    {
        Iterator<Debt> it = debts.iterator();
        Debt tmpDebt = new Debt();
        while (it.hasNext())
        {
            tmpDebt = it.next();
            it.remove();
        }
    }

    /**
     *This method removes all debts owed today in the debts collection.
     */
    public void removeDebtToday()
    {
        Iterator<Debt> it = debts.iterator();
        Debt tmpDebt = new Debt();
        while (it.hasNext())
        {
            tmpDebt = it.next();
            if (tmpDebt.getTimeLeft() <= 0)
            {
                it.remove();
            }
        }
    }

    /**
     *Mutator method to set number of fish guessed at the start of game.
     *@param fishGuess       The amount of fish guessed as an integer.
     */
    public void setFishGuess(int fishGuess)
    {
        this.fishGuess = fishGuess;
    }

    /**
     *Mutator method to set whether to end the game or not.
     *@param gameEnd         Accepts ending the game condition as a boolean.
     */
    public void setGameEnd(boolean gameEnd)
    {
        this.gameEnd = gameEnd;
    }

    /**
     *Mutator method to set game mode.
     *@param mode        Accepts an integer, 1 for arcade and 2 for story mode.
     */
    public void setMode(int mode)
    {
        this.mode = mode;
    }

    /**
     *Mutator method to set name of player
     *@param name        Accepts the player name as a string.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     *Mutator method to set number of turns to play
     *@param turnPlay        Accepts number of turns to play as an integer.
     */
    public void setTurnPlay(int turnPlay)
    {
        this.turnPlay = turnPlay;
    }

    /**
     *Method to decrement number of days left to pay back all loans by 1.
     */
    public void updateDebtTimeLeft()
    {
        for (Debt tmp : debts)
        {
            tmp.decrementTimeLeft();
        }
    }
}