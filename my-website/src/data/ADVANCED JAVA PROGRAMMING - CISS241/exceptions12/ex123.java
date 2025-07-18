package exceptions12;

/**
 * William Smolinski
 * CISS 241
 * Exercise 12-3 -> Program that takes in a grade and handles the exceptions if the input was invalid
 */

import javax.swing.JOptionPane;

public class ex123 
{
	public static void main(String[] args)
	{
		//Initializes the grade int
		int grade = 0;

		//Try catch to catch the exceptions
		try
		{
			//Gets the input from the user and attempts to parse it to an int
			grade = Integer.parseInt(JOptionPane.showInputDialog("Enter your grade (0 - 100):"));

			//Checks if the grade is in the valid range: 0 - 100
			if(grade < 0 || grade > 100)
			{
				//Not a valid number, throws a custom exception
				throw new ArithmeticException(grade + " not in range 0 - 100");
			}
			else
			{
				//Valid number, adds a bonus point and prints out the new grade
				grade += 1;
				System.out.println("New Grade: " + grade);
			}
		}
		catch(NumberFormatException e) //Catches the exception thrown when the parsing fails
		{
			System.out.println("A valid integar was not entered");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch (ArithmeticException e) //Catches the exception thrown when the grade is not within the valid range
		{
			System.out.println("Number was not in the valid range");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
