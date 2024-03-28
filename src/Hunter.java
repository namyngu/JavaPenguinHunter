import java.util.ArrayList;
/**
 *This class runs the main program for Java Penguin Hunter game.
 *@author Hoang Nguyen
 *@version v1.0.0
 */
public class Hunter
{
    private int fishTotal;
    private int fishNeed;
    private int fishPrem;
    private String[] fish = {"Sardine", "Mackarel", "Shrimp", "Cod"};
    private ArrayList<Weapon> weaponList;

    /**
     *Default constructor starts the game with a fish balance of 10.
     */
    public Hunter()
    {
        fishTotal = 10;
        fishNeed = 0;
        fishPrem = 0;
        weaponList = new ArrayList<Weapon>();
    }

    /**
     *This method creates a weapon based on the parameters.
     *@param name        Weapon name as a string.
     *@param damage      Weapon damage as an integer.
     *@param strong      Weapon strong against as a string.
     *@param weak        Weapon weak against as a string.
     *@param cost        Fish cost to use weapon as an integer.
     *@param minFish     Minimum fish catch as an integer.
     *@param maxFish     Maximum fish catch as an integer.
     */
    public void createWeapon(String name, int damage, String strong, String weak, int cost, int minFish, int maxFish)
    {
        try
        {
            Weapon weapon = new Weapon(name, damage, strong, weak, cost, minFish, maxFish);
            weaponList.add(weapon);
        }
        catch (Exception e)
        {
            System.out.println("Error failed to create weapon, check your parameters!");
        }
    }

    /**
     *This method displays menu options to player.
     */
    public void displayOptions()
    {
        System.out.println("Press 1 to select weapon and hunt for fish");
        System.out.println("Press 2 to borrow fish from Maurice the loan shark");
        System.out.println("Press 3 to end current turn");
    }

    /**
     *This method displays the player's state.
     *@param turn        The current turn.
     *@param debtToday   Debts owed today.
     */
    public void displayState(int turn, int debtToday)
    {
        System.out.println("\nTurn: " + turn);
        System.out.println("Food left from yesterday: " + fishTotal + " fish");
        System.out.println("Food needed for family today: " + fishNeed + " fish");
        System.out.println("Insurance premium for today: " + fishPrem + " fish");
        System.out.println("Debt owed today: " + debtToday + " fish");
        System.out.println();

    }

    /**
     *This method displays all the weapons available
     */
    public void displayWeapon()
    {
        int counter = 1;
        for(Weapon tmp : weaponList)
        {
            System.out.println("Select " + counter + ". " + tmp.display());
            counter++;
        }
    }

    /**
     *This method executes what happens when the player hunts for fish.
     *@param index       Refers to the index of the weapon used to hunt fish in the weaponList collection.
     */
    public void huntFish(int index)
    {
        Rng rng = new Rng();
        String fishHunted = fish[rng.randomInt(0, 3)];
        System.out.println("You hunted " + fishHunted + "!");

        int fishCaught = rng.randomInt(weaponList.get(index).getMinFish(), weaponList.get(index).getMaxFish());
        int cost = weaponList.get(index).getCost();

        if (weaponList.get(index).getStrong().equalsIgnoreCase(fishHunted))
        {
            System.out.println("Great job! It was super effective!");
            fishCaught = fishCaught * 2;

        }
        else if(weaponList.get(index).getWeak().equalsIgnoreCase(fishHunted))
        {
            System.out.println("Unfortunately, it wasn't very effective");
            fishCaught = (int) Math.round(fishCaught / 2.0);
        }
        else
            System.out.println("It was an average hunt");

        System.out.println("You managed to catch " + fishCaught + " fish, but it cost you " + cost + " fish to use the weapon");
        fishTotal = fishTotal + fishCaught - cost;
        System.out.println("\n" + "Fish balance is now: " + fishTotal + "\n");
    }

    /**
     *This method imports weapons from a txt file to the weaponList collection.
     *@param fileName        Name of the txt file to be imported.
     */
    public void importWeaponList(String fileName)
    {
        FileIO io = new FileIO();
        String contents = io.readFile(fileName);
        if (!contents.trim().isEmpty())
        {
            String[] weapon = contents.split("\n");
            //Swordfish,5,Sardine,Mackerel,2,3,7
            try
            {
                for (int i = 0; i < weapon.length; i++)
                {
                    String[] weaponDetails = weapon[i].split(",");
                    createWeapon(weaponDetails[0], Integer.parseInt(weaponDetails[1]), weaponDetails[2], weaponDetails[3],
                            Integer.parseInt(weaponDetails[4]), Integer.parseInt(weaponDetails[5]), Integer.parseInt(weaponDetails[6]));
                }
            }
            catch (Exception e)
            {
                System.out.println("Error unable to import weapons, check " + fileName + " format");
            }
        }
        else
            System.out.println("Error filename cannot be empty");
    }

    /**
     *The main method which begins the program execution
     *@param args        An array of string passed in as command line parameters.
     */
    public static void main(String[] args)
    {
        Hunter hunter = new Hunter();
        hunter.startProgram();

    }

    /**
     *The method that runs the Java Penguin Hunter program.
     */
    public void startProgram()
    {
        importWeaponList("src/weapons.txt");

        Input input = new Input();
        Validation valid = new Validation();
        Player player = new Player();

        //Prompt player name
        boolean proceed = false;
        do
        {
            String name = input.stringInput("Please enter your name: ");
            if (!valid.isBlank(name) && valid.lengthRange(name, 3, 12))
            {
                player.setName(name);
                proceed = true;
            }
            else
                System.out.println("Invalid name must be between 3-12 characters!");
        }
        while (!proceed);

        //Prompt mode to play
        proceed = false;
        do
        {
            player.setMode(input.intInput("Choose mode to play: \nEnter 1 to play Arcade \nEnter 2 to play Story mode"));

            if (valid.isIntInRange(player.getMode(), 1, 2))
                proceed = true;
            else
                System.out.println("Invalid choice, try again");
        }
        while (!proceed);

        proceed = false;
        if (player.getMode() == 1)
            System.out.println("You have selected Arcade mode.");
        else
        {
            System.out.println("You have selected Story mode.");
            do
            {
                player.setTurnPlay(input.intInput("How many turns would you like to play? (Must be greater or equal to 5 turns)"));
                if (player.getTurnPlay() >= 5)
                    proceed = true;
                else
                    System.out.println("Please choose 5 or more turns.");
            }
            while (!proceed);

            proceed = false;
            do
            {
                player.setFishGuess(input.intInput("How many fish will remain after the specified turns? (Must be greater or equal to 25 fish)"));
                if (player.getFishGuess() >= 25)
                    proceed = true;
                else
                    System.out.println("Must select 25 fish or more.");
            }
            while (!proceed);
        }
        //beginning of each turn
        Rng rng = new Rng();
        while (fishTotal >= 0 && !player.getGameEnd())
        {
            fishNeed = rng.randomInt(10, 20);
            fishPrem = rng.randomInt(1, 10);

            if (rng.disasterCheck() && (player.getTurn() != 1))
            {
                fishTotal -= rng.randomInt(50, 100);
                System.out.println("Oh no, disaster struck!");
            }
            //display state
            displayState(player.getTurn(), player.getDebtToday());

            System.out.println("Today's fish balance: " + fishTotal + "\n");

            //display menu
            boolean flag = false;
            int counter = 0;
            do
            {
                displayOptions();
                int choice = input.intInput("What should " + player.getName() + " do today?");

                switch (choice)
                {
                    case 1:
                        if (counter < 2)
                        {
                            displayWeapon();
                            int select = input.intInput("Choose your weapon");
                            if (valid.isIntInRange(select, 1, weaponList.size()))
                            {
                                huntFish(select - 1);
                                counter++;
                            }
                            else
                                System.out.println("Invalid selection, back to menu...");
                        }
                        else
                        {
                            System.out.println("You cannot hunt anymore today!");
                        }
                        break;

                    case 2:
                    {
                        int borrow = input.intInput("How much do you want to borrow?");
                        int loaned = player.addLoan(borrow);
                        fishTotal += loaned;
                        if (loaned > 0)
                            System.out.println("Success! You now have " + fishTotal + " fish.");
                        break;
                    }

                    case 3:
                    {
                        System.out.println(player.getName() + " is going to rest now!");
                        flag = true;
                        break;
                    }
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
            while (!flag);

            //End turn calculations
            fishTotal = fishTotal - fishNeed - fishPrem - player.getDebtToday();
            player.removeDebtToday();
            player.updateDebtTimeLeft();
            //Story mode - End game condition
            if (player.getMode() == 2 && (player.getTurnPlay() <= player.getTurn()))
            {
                player.setGameEnd(true);
            }
            player.addTurn();
        }

        //Resolve all outstanding debts
        fishTotal -= player.getDebtTotal();
        player.removeAllDebts();

        //End game results
        String results = "";
        //Arcade Mode
        FileIO io = new FileIO("Results.txt");
        if (player.getMode() == 1)
        {
            System.out.println("Game over! " + player.getName() + " fed the family for " + (player.getTurn() - 1 + " days."));
            results += ("Game Mode: " + "Arcade" + "\nPlayer Name: " + player.getName() + "\nFed the family for " + (player.getTurn() -1) + " turns");
        }
        //Story Mode - survived
        else if (player.getMode() == 2 && player.getGameEnd())
        {
            results += ("Game Mode: Story" + "\nPlayer Name: " + player.getName() + "\nTurns played: " + (player.getTurn() - 1) + "\nTarget Fish: " + player.getFishGuess() + "\nFish Balance: " + fishTotal);
            //Check win condition.
            int lowerBound = (int) Math.round(player.getFishGuess() * 0.9);
            int upperBound = (int) Math.round(player.getFishGuess() * 1.1);
            if (lowerBound <= fishTotal && fishTotal <= upperBound)
            {
                String tmp = ("\nCongratulations YOU WIN!!!");
                System.out.println(tmp);
                results += tmp;
            }
            else
            {
                String tmp = ("\nGood job, you survived. BUT your fish target was wrong. \nYOU LOSE!");
                System.out.println(tmp);
                results += tmp;
            }
        }
        //Story Mode - Didn't survive
        else
        {
            results += ("Game Mode: Story" + "\nPlayer Name: " + player.getName() + "\nTurns played: " + (player.getTurn() - 1) + "\nTarget Fish: " + player.getFishGuess() + "\nFish Balance: " + fishTotal);
            String tmp = ("\n" + player.getName() + " has run out of fish, Game Over! You lose.");
            System.out.println(tmp);
            results += tmp;
        }
        io.writeFile(results);
    }
}
