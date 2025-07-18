/**
 * Super class to hold information about sporting teams
 */

public class SportsTeam
{
    //Fields
    private String primaryCoachName;
    private String nameOfSport;
    private String teamName;
    private int maxNumberOfPlayersInPlay;

    /**
     * No-arg constructor
     */
    SportsTeam()
    {
        //Values to show usage of methods in the super class
        setPrimaryCoachName("Not Set");
        setNameOfSport("Not Set");
        setTeamName("Not Set");
        setMaxNumberOfPlayersInPlay(-1);
    }

    //Setter methods

    /**
     * Setter method for primaryCoachName String
     * @param primaryCoachName String to set primaryCoachName to
     */
    public void setPrimaryCoachName(String primaryCoachName)
    {
        this.primaryCoachName = primaryCoachName;
    }

    /**
     * Setter method for nameOfSport String
     * @param nameOfSport String to set nameOfSport to
     */
    public void setNameOfSport(String nameOfSport)
    {
        this.nameOfSport = nameOfSport;
    }

    /**
     * Setter method for teamName String
     * @param teamName String to set teamName to
     */
    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    /**
     * Setter method for maxNumberOfPlayersInPlay Int
     * @param maxNumberOfPlayersInPlay int to set maxNumberOfPlayersInPlay to
     */
    public void setMaxNumberOfPlayersInPlay(int maxNumberOfPlayersInPlay)
    {
        this.maxNumberOfPlayersInPlay = maxNumberOfPlayersInPlay;
    }

    //Getter methods

    /**
     * Getter method for getting the primaryCoachName String
     * @return Returns primaryCoachName as a String
     */
    public String getPrimaryCoachName()
    {
        return this.primaryCoachName;
    }

    /**
     * Getter method for getting the nameOfSport String
     * @return Returns nameOfSport as a String
     */
    public String getNameOfSport()
    {
        return this.nameOfSport;
    }

    /**
     * Getter method for getting the teamName String
     * @return Returns teamName as a String
     */
    public String getTeamName()
    {
        return this.teamName;
    }

    /**
     * Getter method for getting maxNumberOfPlayersInPlay int
     * @return Returns maxNumberOfPlayersInPlay as an int
     */
    public int getMaxNumberOfPlayersInPlay()
    {
        return this.maxNumberOfPlayersInPlay;
    }

    //Instance methods

    /**
     * Method for converting all information stored in the class to a String
     * @return Returns the result as a String
     */
    public String toString()
    {
        return "Coach name: " + getPrimaryCoachName() + "\n"
                + "Name of sport: " + getNameOfSport() + "\n"
                + "Team name: " + getTeamName() + "\n"
                + "Max players in play: " + getMaxNumberOfPlayersInPlay();
    }

    /**
     * Method to return all the information about the sport, not the team
     * @return Returns the sport information as a String
     */
    public String sportInfo()
    {
        return getNameOfSport() + " has a maximum of " + getMaxNumberOfPlayersInPlay() + " players in play.";
    }

}
