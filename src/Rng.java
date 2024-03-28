/**
 *A class that handles the generation of random numbers.
 *@author Hoang Nguyen
 *@version v1.0.0
 */
public class Rng
{
    private final int DISASTER;

    /**
     *The default constructor - randomly generates a constant number between 1-100.
     */
    public Rng()
    {
        DISASTER = randomInt(1, 100);
    }

    /**
     *A method that checks whether a disaster event has occured with a 1% chance.
     *@return        Returns a boolean specifying if a disaster has occurred.
     *Returns true if disaster has occurred, else it'll return a false.
     */
    public boolean disasterCheck()
    {
        int tmp = randomInt(1, 100);
        if (DISASTER == tmp)
            return true;
        else
            return false;
    }

    /**
     *A method to generate a pseudorandom number between the specified intervals.
     *@param min         The beginning index, inclusive.
     *@param max         The ending index, inclusive.
     @return         Returns a random integer between the specified interval.
     */
    public int randomInt(int min, int max)
    {
        int tmp = (int) (Math.random() * (max - min + 1) + min);
        return tmp;
    }
}