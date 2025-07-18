package dbms20;

/**
 * William Smolinski
 * CISS 241
 * Spiderman Database Part 2: Adds some more data to the table and updates and deletes some data before printing out to the console.
 * The program adds 4 more rows to the table with new values and then updates 3 previous entries. It updates the IssueValue of 2 
 * different comics and changes the IssueName of one of the comics that also has its IssueValue changed. The program then deletes one
 * row and adds one more at the end before getting the ResultSet and printing out the entire table to the console. 
 */

import java.sql.*;

public class SpidermanP2 
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
			
			//Adding to the table
			stmt.executeUpdate("insert into spidermanDerby " +
					"values('Amazing SM', 400, '4/1/95', 'A Death In The Family', 5.0, 'Yes')");
			stmt.executeUpdate("insert into spidermanDerby " +
					"values('Spectacular SM', 37, '12/1/79', 'Into The Hive', 6.0, 'No')");
			stmt.executeUpdate("insert into spidermanDerby " +
					"values('Amazing SM', 194, '7/1/79', 'Never Let The Black Cat Cross Your Path', 10.0, 'No')");
			stmt.executeUpdate("insert into spidermanDerby " +
					"values('Web Of SM', 125, '6/1/95', 'Searching', 4.0, 'Yes')");
			
			//Updating the table
			stmt.executeUpdate("update spidermanDerby set IssueValue = 7.0 where ComicName = 'Amazing SM' and IssueNumber = 89");
			stmt.executeUpdate("update spidermanDerby set IssueValue = 5.0 where ComicName = 'Spectacular SM' and IssueNumber = 92");
			stmt.executeUpdate("update spidermanDerby set IssueName = 'What Is The Answer?' where ComicName = 'Spectacular SM' and IssueNumber = 92");
			
			//Deleting from the table
			stmt.executeUpdate("delete from spidermanDerby where ComicName = 'Amazing SM' and IssueNumber = 382");
			
			//Adding the last record
			stmt.executeUpdate("insert into spidermanDerby " +
					"values('Amazing SM', 0, '4/2/23', 'William Smolinski', 5.0, 'Yes')");
			
			//Printing the column names
			System.out.printf("|%-20s|%-12s|%-10s|%-40s|%-11s|%15s|\n", "Comic Name", "Issue Number", "Issue Date", "Issue Name", "Issue Value",
					"Mint Condition?");
			System.out.println("|--------------------|------------|----------|----------------------------------------|-----------|---------------|");
			
			//Getting the results
			ResultSet rs = stmt.executeQuery("select * from spidermanDerby");
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
				System.out.printf("|%-20s|%12d|%10s|%-40s|%11s|%15s|\n", comicName, issueNumber, issueDate, issueName, valueFormatted, 
						mintCondition);
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
