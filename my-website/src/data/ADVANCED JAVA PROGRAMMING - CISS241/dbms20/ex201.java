package dbms20;

/**
 * William Smolinski
 * CISS 241
 * Exercise 20-1: Creates a Derby database with yankees players and then prints it out to an output file
 */

import java.sql.*;
import java.io.*;

public class ex201 
{
	public static void main(String[] args)
	{
		Connection con;
		Statement stmt;
		
		String createString = "create table yankeesPlayersDerby " +
		"(Name varchar(20), " +
		"Position varchar(2), " +
		"Number int)";
		String query = "select * from yankeesPlayersDerby";

		try 
		{
			//Setting up the table
			SimpleDataSource.init("databaseyankees.properties");
			con = SimpleDataSource.getConnection();
			stmt = con.createStatement();
			stmt.execute(createString);
			
			//Adding to the table
			stmt.executeUpdate("insert into yankeesPlayersDerby " +
			"values('Bernie Williams', 'CF', 51)");
			stmt.executeUpdate("insert into yankeesPlayersDerby " +
					"values('Derek Jeter', 'SS', 2)");
			stmt.executeUpdate("insert into yankeesPlayersDerby " +
					"values('Mariano Rivera', 'P', 42)");
			stmt.executeUpdate("insert into yankeesPlayersDerby " +
					"values('Jason Giambi', '1B', 25)");
			stmt.executeUpdate("insert into yankeesPlayersDerby " +
					"values('Mike Mussina', 'P', 35)");
			stmt.executeUpdate("insert into yankeesPlayersDerby " +
					"values('Alfonso Soriano', '2B', 12)");
			
			//Updating the table to correct the position of Giambi
			stmt.executeUpdate("update yankeesPlayersDerby set Position = 'DH' where Name = 'Jason Giambi'");
			
			//Setting up the output file
			PrintWriter outputFile = new PrintWriter("ex201Output.txt");
			
			//Getting the results and adding them to the output file
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				String name = rs.getString("Name");
				String position = rs.getString("Position");
				int number = rs.getInt("Number");
				
				outputFile.printf("%-20s%-7s%-3d\n", name, position, number);
			}
			
			System.out.println("Success");
			
			outputFile.close();
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
