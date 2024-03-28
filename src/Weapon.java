/**
 *Class that contains the stats of a weapon.
 *@author Hoang Nguyen
 *@version v1.0.0
 */
public class Weapon
{
    private String name;
    private int damage;
    private String strong;
    private String weak;
    private int cost;
    private int minFish;
    private int maxFish;

    /**
     *Default constructor - creates a weapon with 0 stats.
     */
    public Weapon()
    {
        name = "unknown";
        damage = 0;
        strong = "unknown";
        weak = "unknown";
        cost = 0;
        minFish = 0;
        maxFish = 0;
    }

    /**
     *Non default-constructor - creates a weapon with specified stats.
     *@param name        Weapon name.
     *@param damage      Weapon damage.
     *@param strong      Weapon strong against.
     *@param weak        Weapon weak against.
     *@param cost        Fish cost to use weapon.
     *@param minFish     Minimum fish catch.
     *@param maxFish     Maximum fish catch.
     */
    public Weapon(String name, int damage, String strong, String weak, int cost, int minFish, int maxFish)
    {
        this.name = name;
        this.damage = damage;
        this.strong = strong;
        this.weak = weak;
        this.cost = cost;
        this.minFish = minFish;
        this.maxFish = maxFish;
    }

    /**
     *Method to display weapon stats.
     *@return    Returns weapon stats as a string.
     */
    public String display()
    {
        return ("Weapon: " + name + " |Damage: " + damage + " |Strong vs. " + strong + " |Weak vs. " + weak +
                " |Cost to use: " + cost + " |Min. Fish: " + minFish + " |Max Fish: " + maxFish + "|");
    }

    /**
     *Accessor method to get fish cost to use weapon.
     *@return        Returns number of fish cost to use weapon.
     */
    public int getCost()
    {
        return cost;
    }

    /**
     *Accessor method to get weapon damage.
     *@return        Returns weapon damage as an integer.
     */
    public int getDamage()
    {
        return damage;
    }

    /**
     *Accessor method to get maximum fish catch.
     *@return        Returns maximum fish catch as an integer.
     */
    public int getMaxFish()
    {
        return maxFish;
    }

    /**
     *Accessor method to get minimum fish catch.
     *@return        Returns minimum fish catch as an integer.
     */
    public int getMinFish()
    {
        return minFish;
    }

    /**
     *Accessor method to get weapon name.
     *@return        Returns weapon name.
     */
    public String getName()
    {
        return name;
    }

    /**
     *Accessor method to get weapon strong against.
     *@return        Returns weapon strong against as a string.
     */
    public String getStrong()
    {
        return strong;
    }

    /**
     *Accessor method to get weapon weak against.
     *@return        Returns weapon weak against as a string.
     */
    public String getWeak()
    {
        return weak;
    }
}