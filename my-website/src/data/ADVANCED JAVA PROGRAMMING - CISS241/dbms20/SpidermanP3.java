package dbms20;

/**
 * William Smolinski
 * CISS 241
 * Spiderman Database Part 3: Accesses the database and does a couple queries to get some data to be formatted and printed
 * out to the console. The first query gets the ComicName, IssueDate, IssueNumber, and IssueValue from all comics that have 
 * a value of 5 or more and then prints them out to the console. The second query gets the IssueName, ComicName, IssueNumber,
 * and IssueDate from all the comics that have a ComicName of Amazing SM and an IssueNumber less than 200 and then it prints them out to the console.
 */

import java.sql.*;

public class SpidermanP3 
{
	public static void main (String[] arg)
	{
		Connection con;
		Statement stmt;
		
		try 
		{
			//Connecting to the table
			con = DriverManager.getConnection("jdbc:derby:spidermanDerby");
			stmt = con.createStatement();
			
			//First query
			ResultSet rs = stmt.executeQuery("select ComicName, IssueDate, IssueNumber, IssueValue from spidermanDerby " + 
			"where IssueValue >= 5.0 order by IssueValue DESC");
			
			//Printing the column names for the first query
			System.out.println("First Query:");
			System.out.printf("|%-20s|%-12s|%-10s|%-11s|\n", "Comic Name", "Issue Number", "Issue Date", "Issue Value");
			System.out.println("|--------------------|------------|----------|-----------|");
			
			//Printing the results of the first query
			while(rs.next())
			{
				String comicName = rs.getString("ComicName");
				int issueNumber = rs.getInt("IssueNumber");
				String issueDate = rs.getString("IssueDate");
				double issueValue = rs.getDouble("IssueValue");
				
				String valueFormatted = String.format("$%.2f", issueValue);
				
				//Formatting the results and printing them out
				System.out.printf("|%-20s|%12d|%10s|%11s|\n", comicName, issueNumber, issueDate, valueFormatted);
			}
			
			//Second query
			rs = stmt.executeQuery("select IssueName, ComicName, IssueNumber, IssueDate from spidermanDerby " +
			"where ComicName = 'Amazing SM' and IssueNumber < 200");
			
			//Printing the column names for the second query
			System.out.println("\nSecond Query:");
			System.out.printf("|%-20s|%-12s|%-10s|%-40s|\n", "Comic Name", "Issue Number", "Issue Date", "Issue Name");
			System.out.println("|--------------------|------------|----------|----------------------------------------|");
			
			//Printing the results of the second query
			while(rs.next())
			{
				String issueName = rs.getString("IssueName");
				String comicName = rs.getString("ComicName");
				int issueNumber = rs.getInt("IssueNumber");
				String issueDate = rs.getString("IssueDate");
				
				//Formatting the results and printing them out
				System.out.printf("|%-20s|%12d|%10s|%-40s|\n", comicName, issueNumber, issueDate, issueName);
			}
			
			stmt.close();
			con.close();
			System.exit(0);
		} 
		catch(SQLException e)
		{
			System.out.println("SQLException");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
