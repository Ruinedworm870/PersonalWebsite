package net21;

/**
 * William Smolinski
 * CISS 241
 * Read File Over Network Onto Screen Assignment: This is the client program that will take input from the user about the port and host name
 * for the server and also gather a message which will be for a file that the server will open. The program then sends that message to the
 * specified server and awaits a response. The response will be the file line by line to then be printed to the console.
 */

import java.io.*;
import java.net.*;

public class ReadFileOverNetworkClient 
{
	private int port;
    private InetAddress host;
   
    public ReadFileOverNetworkClient(int portNumber, String hostName)
    {
        try
        {
            port = portNumber;      

            host = InetAddress.getByName(hostName);  
        }
        catch(UnknownHostException u)
        {
            u.printStackTrace();
        }
    }
   
    public void run(String mes)
    {
        try
        {
        	//Setting up the socket
        	Socket client = new Socket(host, port);
        	
        	//Sending the message to the server
        	PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
        	pw.println(mes);
        	
        	//Receiving a message from the server and printing it out
        	BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        	
        	String str;
        	while((str = br.readLine()) != null)
        	{
        		System.out.println(str);
        	}
        	
        	client.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
   
    public static void main(String[] args) throws IOException
    {
        String fileName;
        BufferedReader br = new
            BufferedReader(new InputStreamReader(System.in));
        
        //Asks the user for a file name
        System.out.print("Enter a file name:  ");
        fileName = br.readLine();
        
        //Asks the user for a port number and keeps asking until a valid int is submitted
        System.out.print("Enter a port number: ");
        int portNumber = -1;
        while(portNumber == -1)
        {
        	try 
            {
            	portNumber = Integer.parseInt(br.readLine());
    		} 
            catch (NumberFormatException e) 
            {
    			System.out.print("Not a valid port number, try again:");
    		}
        }
        
        //Asks the user for the host name of the server
        System.out.print("Enter the host name: ");
        String hostName = br.readLine();
        
        ReadFileOverNetworkClient c = new ReadFileOverNetworkClient(portNumber, hostName);
        c.run(fileName);  // call run method with string line to send to server
    }
}
