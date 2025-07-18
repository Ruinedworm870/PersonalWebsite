package files13;

/* William Smolinski
 * Exercise 13-3
 * This program will input into a file using binary streams
 */

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ex133
{
    public static void main(String[] args) throws IOException
    {
    	//Sets the first 2 to null so that they are initialized and can be referenced in the finally blocks
        DataInputStream is = null;
        DataOutputStream os = null;
        
        int value;
        String filenamein, filenameout, name;
        BufferedReader br = new
            BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        
        //Initializing by setting to null
        FileOutputStream fout = null;
        FileInputStream fin = null;
        
        System.out.print("Enter output filename:  ");
        filenameout = br.readLine();

        //Sets the input file name to the same name as the output file since it just reads back the output file
        filenamein = filenameout;
        
        //Try block for the output file
        try
        {
        	//Creating the output file and setting up the output stream
            fout = new FileOutputStream(filenameout);
            os = new DataOutputStream(fout);
            
            //Initializing name so that it can be used in the while loops
            name = "";
            
            //Will exit when CTRL-Z or CTRL-D is entered
            while(!name.equals("-1"))
            {
        		System.out.print("Name: ");
            	name = br.readLine();
            	os.writeUTF(name);

            	System.out.print("Number: ");
            	value = sc.nextInt();
            	os.writeInt(value);
            }
        }
        catch(InputMismatchException e) //Catches any errors with not getting an int as the number
        {
        	System.out.println("Invalid employee number entered");
        	System.exit(1);
        }
        catch (IOException e) 
        {
			System.out.println("Couldn't open file");
			System.exit(1);
		}
        catch (NullPointerException e) 
        {
			//Empty for catching when ctrl+z or ctrl+d is entered and name is null
		}
        finally 
        {
        	//Closes the output stream
        	os.close();
        	fout.close();
		}
        
        //Try block for getting input back from the output file
        try 
        {
        	//Setting up the input file and input stream
			fin = new FileInputStream(filenamein);
			is = new DataInputStream(fin);
			
			//Printing to notify that it is reading back the file
			System.out.println("\n\nREADING BACK FROM FILE:\n");
			
			//Reseting name so that it isn't null
			name = "";
			
			//Will read the file and output the results in a readable way
			while(!name.equals("-1"))
			{
				name = is.readUTF();
				value = is.readInt();
				
				System.out.println("Employee: " + name + ", ID: " + value);
			}
		} 
        catch(EOFException e)
        {
        	//Empty so the program can continue
        }
        catch (IOException e) 
        {
			System.out.println("File does not exist");
			System.exit(1);
		}
        finally 
        {
        	//Closes the input stream
        	is.close();
        	fin.close();
        	
        	System.exit(0);
		}
    }
}
