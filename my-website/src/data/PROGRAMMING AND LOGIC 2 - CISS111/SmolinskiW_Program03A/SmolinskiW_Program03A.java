/**
 * William Smolinski
 * CISS 111
 * Program03A - Shows the usage of a super class with subclasses
 */

public class SmolinskiW_Program03A
{
    public static void main(String[] args)
    {
        //Creating the objects

        BaseballTeam bostonRedSox = new BaseballTeam("Alex Cora", "Boston Red Sox", 9);
        FootballTeam pittsburghSteelers = new FootballTeam("Mike Tomlin", "Pittsburgh Steelers", 6);

        SportsTeam sportsTeam = new SportsTeam();

        //Outputting information about the subclasses

        System.out.println("BOSTON RED SOX INFO: \n");

        System.out.println("To String method:");
        System.out.println(bostonRedSox.toString() + "\n");

        System.out.println("Sport info method:");
        System.out.println(bostonRedSox.sportInfo() + "\n");

        System.out.println("Display world series wins method:");
        System.out.println(bostonRedSox.displayWorldSeriesWins() + "\n");

        System.out.println("PITTSBURGH STEELERS INFO: \n");

        System.out.println("To String method:");
        System.out.println(pittsburghSteelers.toString() + "\n");

        System.out.println("Sport info method:");
        System.out.println(pittsburghSteelers.sportInfo() + "\n");

        System.out.println("Display super bowl wins method:");
        System.out.println(pittsburghSteelers.displaySuperBowlWins() + "\n");

        //Outputting information about the superclass

        System.out.println("SUPPER CLASS METHODS: \n");

        System.out.println("To String method:");
        System.out.println(sportsTeam.toString() + "\n");

        System.out.println("Sport info method");
        System.out.println(sportsTeam.sportInfo() + "\n");

    }
}
