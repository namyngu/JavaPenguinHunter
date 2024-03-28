import java.util.Scanner;

/**
 *A class that prompts the user to enter the appropriate input.
 *@author Hoang Nguyen
 *@version v1.0.0
 */
public class Input
{
    /**
     *A method that prompts the user for an input and returns it as a double.
     *@param displayMessage      Accepts a string to display to the user.
     *@return        Returns the input as a double.
     */
    public double doubleInput(String displayMessage)
    {
        Scanner console = new Scanner(System.in);
        double tmpD;
        boolean proceed = false;
        do
        {
            System.out.println(displayMessage);
            if (!console.hasNextDouble())
            {
                System.out.println("Invalid number, try again");
                console.nextLine();
            }
            else
            {
                proceed = true;
            }
        }
        while (proceed == false);
        tmpD = console.nextDouble();
        console.nextLine();
        return tmpD;
    }

    /**
     *A method that prompts the user for an input and returns it as an integer.
     *@param displayMessage      Accepts a string to display to the user.
     *@return        Returns the input as an integer.
     */
    public int intInput(String displayMessage)
    {
        Scanner console = new Scanner(System.in);
        int num;
        boolean proceed = false;
        do
        {
            System.out.println(displayMessage);
            if (console.hasNextInt())
            {
                proceed = true;
            }
            else
            {
                System.out.println("Invalid number, try again.");
                console.nextLine();
            }
        }
        while (proceed == false);

        num = console.nextInt();
        console.nextLine();
        return num;
    }

    /**
     *A method that prompts the user for an input and returns it as a string.
     *@param displayMessage      Accepts a string to display to the user.
     *@return        Returns the input as a string.
     */
    public String stringInput(String displayMessage)
    {
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        String tmpStr = console.nextLine().trim();
        return tmpStr;
    }
}