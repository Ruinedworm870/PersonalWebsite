package files13;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * William Smolinski
 * CISS 241
 * Assignment 2-11: The program takes an input file that contains objects of the yankees class and gathers the fields
 * from the input yankees file classes and outputs them in plain text one character at a time to an output file. The program
 * has one main try-catch block that handles exceptions that will end the program. Within the block is the while loop that will loop
 * through the input file gathering each object, one at a time, and getting the fields from that object to then write to the output file. 
 */

public class a211 
{
	public static void main(String[] args)
	{
		//Change input and output files here
		String inputFileName = "yankees.yanks";
		String outputFileName = "yankees.txt";
		
		yankees yankeesObject;
		String name, position, number;
		
		ObjectInputStream is = null;
		FileOutputStream fout = null;
		
		byte[] bytes;
		
		//Try block that will catch any issues that might close the program and the EOFException to move on
		try 
		{
			is = new ObjectInputStream(new FileInputStream(inputFileName));
			fout = new FileOutputStream(outputFileName);
			
			while(true)
			{
				//Getting the yankees object
				yankeesObject = (yankees)is.readObject();
				
				//Gathering the fields from the yankees object
				name = yankeesObject.getname() + " ";
				position = yankeesObject.getpos() + " ";
				number = Integer.toString(yankeesObject.getnum()) + "\n";
				
				//Writing the name
				bytes = name.getBytes();
				for(int i = 0; i < bytes.length; i++)
				{
					fout.write(bytes[i]);
				}
				
				//Writing the position
				bytes = position.getBytes();
				for(int i = 0; i < bytes.length; i++)
				{
					fout.write(bytes[i]);
				}
				
				//Writing the number
				bytes = number.getBytes();
				for(int i = 0; i < bytes.length; i++)
				{
					fout.write(bytes[i]);
				}
			}
		}
		catch(EOFException e)
		{
			//Do nothing, just stops the loop
		}
		catch (ClassCastException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		finally 
		{
			//Closing the streams
			
			try 
			{
				is.close();
				fout.close();
			}
			catch(IOException e)
			{
				//Error closing one of the streams
				e.printStackTrace();
				System.exit(1);
			}
		}

		System.out.println("Program completed successfully");
	}
}
