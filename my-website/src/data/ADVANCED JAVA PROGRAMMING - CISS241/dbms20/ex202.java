package dbms20;

/**
 * William Smolinski
 * CISS 241
 * Exercise 20-2: Creates 2 queries for the yankees table from 20-1, uses a Derby database
 */

import java.sql.*;
import java.util.Scanner;

public class ex202 
{
	public static void main(String[] args)
	{
		Connection con;
		Statement stmt;
		Scanner keyboard = new Scanner(System.in);
		
		try 
		{
			con = DriverManager.getConnection("jdbc:derby:yankeesPlayersDerby");
			stmt = con.createStatement();
			
			//First Query
			String firstQuery = "select Name, Number, Position from yankeesPlayersDerby where Number < 20 order by Number ASC";
			ResultSet rs = stmt.executeQuery(firstQuery); 
			
			//Printing the results
			System.out.println("Players with a number less than 20 in ascending order:");
			while(rs.next())
			{
				String name = rs.getString("Name");
				int number = rs.getInt("Number");
				String position = rs.getString("Position");
				
				System.out.println(name + ", " + number + ", " + position);
			}
			
			//Asking for a position
			System.out.print("\nWhat position would you like listed? ");
			String pos = keyboard.nextLine();
			
			//Second Query
			String secondQuery = "select Name, Number from yankeesPlayersDerby where Position = '" + pos + "'";
			rs = stmt.executeQuery(secondQuery);
			
			//Printing the results
			System.out.println("\nPlayers that play position " + pos + ":");
			while(rs.next())
			{
				String name = rs.getString("Name");
				int number = rs.getInt("Number");
				
				System.out.println(name + ", " + number);
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("SQLException");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
