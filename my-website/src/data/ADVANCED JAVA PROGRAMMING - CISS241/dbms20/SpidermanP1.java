package dbms20;

/**
 * William Smolinski
 * CISS 241
 * Spiderman Database Part 1: Creates a derby database and adds some values then prints them out to the console. The values in 
 * the table are: ComicName, IssueNumber, IssueDate, IssueName, IssueValue, and MintCondition. The program adds 4 rows to
 * the table with a couple different Spiderman comics. The program then gathers a ResultSet of the entire table and loops
 * through the rows formatting and printing out the entire table to the console. 
 */

import java.io.*;
import java.sql.*;

public class SpidermanP1 
{
	public static void main (String[] arg)
	{
		Connection con;
		Statement stmt;
		
		String createString = "create table spidermanDerby " +
		"(ComicName varchar(20), " +
		"IssueNumber int, " +
		"IssueDate varchar(10), " +
		"IssueName varchar(40), " +
		"IssueValue double, " +
		"MintCondition varchar(5))";
		String query = "select * from spidermanDerby";
		
		try 
		{
			//Setting up the table
			SimpleDataSource.init("databasespiderman.properties");
			con = SimpleDataSource.getConnection();
			stmt = con.createStatement();
			stmt.execute(createString);
			
			//Adding to the table
			stmt.executeUpdate("insert into spidermanDerby " +
					"values('Amazing SM', 89, '10/1/70', 'Doc Ock Lives', 6.5, 'No')");
			stmt.executeUpdate("insert into spidermanDerby " +
					"values('Spectacular SM', 92, '7/1/84', 'What Is The Answer', 4.5, 'No')");
			stmt.executeUpdate("insert into spidermanDerby " +
					"values('Web Of SM', 35, '2/1/88', 'You Can Go Home Again', 4.0, 'No')");
			stmt.executeUpdate("insert into spidermanDerby " +
					"values('Amazing SM', 382, '10/1/93', 'Emerald Rage', 4.0, 'Yes')");
			
			//Printing the column names
			System.out.printf("|%-20s|%-12s|%-10s|%-25s|%-11s|%15s|\n", "Comic Name", "Issue Number", "Issue Date", "Issue Name", "Issue Value",
					"Mint Condition?");
			System.out.println("|--------------------|------------|----------|-------------------------|-----------|---------------|");
			
			//Getting the results
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				String comicName = rs.getString("ComicName");
				int issueNumber = rs.getInt("IssueNumber");
				String issueDate = rs.getString("IssueDate");
				String issueName = rs.getString("IssueName");
				double issueValue = rs.getDouble("IssueValue");
				String mintCondition = rs.getString("MintCondition");
				
				String valueFormatted = String.format("$%.2f", issueValue);
				
				//Formatting the results and printing them out
				System.out.printf("|%-20s|%12d|%10s|%-25s|%11s|%15s|\n", comicName, issueNumber, issueDate, issueName, valueFormatted, 
						mintCondition);
			}
			
			stmt.close();
			con.close();
			System.exit(0);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			System.out.println("SQLException");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
