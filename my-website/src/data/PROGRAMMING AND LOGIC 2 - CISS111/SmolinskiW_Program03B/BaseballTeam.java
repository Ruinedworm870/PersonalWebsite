/**
 * Subclass of SportsTeam
 */

public class BaseballTeam extends SportsTeam implements PlayersOnTeam
{
    //Fields
    private int inningsWithoutOvertime;
    private int worldSeriesWins;
    private int totalPlayersOnTeam;

    /**
     * Constructor
     */
    BaseballTeam(String primaryCoachName, String teamName, int worldSeriesWins, int totalPlayersOnTeam)
    {
        //Initializes all the information about the team
        setPrimaryCoachName(primaryCoachName);
        setNameOfSport("Baseball");
        setTeamName(teamName);
        setMaxNumberOfPlayersInPlay(13);
        setInningsWithoutOvertime(9);
        setWorldSeriesWins(worldSeriesWins);
        setTotalPlayersOnTeam(totalPlayersOnTeam);
    }

    //Setter methods

    /**
     * Setter method for inningsWithoutOvertime int
     * @param inningsWithoutOvertime int to set inningsWithoutOvertime to
     */
    public void setInningsWithoutOvertime(int inningsWithoutOvertime)
    {
        this.inningsWithoutOvertime = inningsWithoutOvertime;
    }

    /**
     * Setter method for worldSeriesWins int
     * @param worldSeriesWins int to set worldSeriesWins to
     */
    public void setWorldSeriesWins(int worldSeriesWins)
    {
        this.worldSeriesWins = worldSeriesWins;
    }

    /**
     * Setter method for totalPlayersOnTeam int
     * @param totalPlayersOnTeam int tot set totalPlayersOnTeam to
     */
    public void setTotalPlayersOnTeam(int totalPlayersOnTeam)
    {
        this.totalPlayersOnTeam = totalPlayersOnTeam;
    }

    //Getter methods

    /**
     * Getter method for getting the inningsWithoutOvertime int
     * @return Returns inningsWithoutOvertime as an int
     */
    public int getInningsWithoutOvertime()
    {
        return this.inningsWithoutOvertime;
    }

    /**
     * Getter method for getting worldSeriesWins int
     * @return Returns worldSeriesWins as an int
     */
    public int getWorldSeriesWins()
    {
        return this.worldSeriesWins;
    }

    /**
     * Getter method from the interface to get totalPlayersOnTeam int
     * @return Returns totalPlayersOnTeam as an int
     */
    public int getTotalPlayersOnTeam()
    {
        return this.totalPlayersOnTeam;
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
                + "Innings without overtime: " + getInningsWithoutOvertime() + "\n"
                + "World series wins: " + getWorldSeriesWins() + "\n"
                + "Total players on the team: " + getTotalPlayersOnTeam();
    }

    /**
     * Method to return all information about the sport, not the team
     * @return Returns the sport information as a String
     */
    @Override
    public String sportInfo()
    {
        return getNameOfSport() + " has a maximum of " + getMaxNumberOfPlayersInPlay() + " players in play "
                + "and " + getInningsWithoutOvertime() + " innings without overtime.";
    }

    /**
     * Method for outputting the total world series wins as a String of a sentence
     * @return Returns the result as a String
     */
    public String displayWorldSeriesWins()
    {
        return "The " + getTeamName() + " have " + getWorldSeriesWins() + " world series wins.";
    }

}