/**
 * Subclass of SportTeam
 */

public class FootballTeam extends SportsTeam
{
    //Fields
    private int minutesInAQuarter;
    private int superBowlWins;

    /**
     * Constructor
     */
    FootballTeam(String primaryCoachName, String teamName, int superBowlWins)
    {
        //Initializes all the information about the team
        setPrimaryCoachName(primaryCoachName);
        setNameOfSport("Football");
        setTeamName(teamName);
        setMaxNumberOfPlayersInPlay(11);
        setMinutesInAQuarter(15);
        setSuperBowlWins(superBowlWins);
    }

    //Setter methods

    /**
     * Setter method for minutesInAQuarter int
     * @param minutesInAQuarter int to set minutesInAQuarter to
     */
    public void setMinutesInAQuarter(int minutesInAQuarter)
    {
        this.minutesInAQuarter = minutesInAQuarter;
    }

    /**
     * Setter method for superBowlWins int
     * @param superBowlWins int to set superBowlWins to
     */
    public void setSuperBowlWins(int superBowlWins)
    {
        this.superBowlWins = superBowlWins;
    }

    //Getter methods

    /**
     * Getter method for getting minutesInAQuarter int
     * @return Returns minutesInAQuarter as an int
     */
    public int getMinutesInAQuarter()
    {
        return this.minutesInAQuarter;
    }

    /**
     * Getter method for getting superBowlWins int
     * @return Returns superBowlWins as an int
     */
    public int getSuperBowlWins()
    {
        return this.superBowlWins;
    }

    //Instance methods

    /**
     * Method for converting all information stored in the class to a String
     * @return Returns the result as a String
     */
    @Override
    public String toString()
    {
        return super.toString() + "\n"
                + "Minutes in a quarter: " + getMinutesInAQuarter() + "\n"
                + "Super bowl wins: " + getSuperBowlWins();
    }

    /**
     * Method to return all information about the sport, not the team
     * @return Returns the sport information as a String
     */
    @Override
    public String sportInfo()
    {
        return getNameOfSport() + " has a maximum of " + getMaxNumberOfPlayersInPlay() + " players in play "
                + "and " + getMinutesInAQuarter() + " minutes in a quarter.";
    }

    /**
     * Method for outputting the total super bowl wins as a String of a sentence
     * @return Returns the result as a String
     */
    public String displaySuperBowlWins()
    {
        return "The " + getTeamName() + " have " + getSuperBowlWins() + " super bowl wins.";
    }

}