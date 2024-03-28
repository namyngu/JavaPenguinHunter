/**
 *A class that handles validation checks.
 *@author Hoang Nguyen
 *@version v1.0.0
 */
public class Validation
{
    /**
     *A method to check if a string passed through as a parameter is blank.
     *@param input       The string to perform validation check on.
     *@return            Returns a boolean - true if the string is blank, false if it's not.
     */
    public boolean isBlank(String input)
    {
        if (input.trim().length() == 0)
            return true;
        else
            return false;
    }

    /**
     *A method to check if an integer is within a range.
     *@param value       The integer to perform validation check on.
     *@param min         The minimum number in the range, inclusive.
     *@param max         The maximum number in the range, inclusive.
     *@return            Returns a boolean - true if the number is within range, false if it's not.
     */
    public boolean isIntInRange(int value, int min, int max)
    {
        if (value >= min && value <= max)
            return true;
        else
            return false;
    }

    /**
     *A method to check if the string length is within a range.
     *@param input       The string to perform validation check on.
     *@param min         The minimum number in the range, inclusive.
     *@param max         The maximum number in the range, inclusive.
     *@return            Returns a boolean - true if string length is within range, false if it's not.
     */
    public boolean lengthRange(String input, int min, int max)
    {
        boolean withinRange = false;
        if ((input.trim().length() >= min) && (input.trim().length() <= max))
        {
            withinRange = true;
        }
        return withinRange;
    }
}