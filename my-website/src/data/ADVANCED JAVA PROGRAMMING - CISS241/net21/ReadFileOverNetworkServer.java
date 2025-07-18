package net21;

/**
 * William Smolinski
 * CISS 241
 * Read File Over Network Onto Screen Assignment: This is the server program that will wait on port 7777 for a message from the client.
 * The program then opens the file specified in the message from the client and sends the file back one line at a time to the client.
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ReadFileOverNetworkServer 
{
	private InetAddress host;
    private int port;
   
    public ReadFileOverNetworkServer()
    {
        try
        {
            host = InetAddress.getLocalHost(); // use server computer as host
            port = 7777;  // wait on port #7777
        }
        catch(UnknownHostException u)
        {
            u.printStackTrace();
        }
    }
   
    public void run()
    {
        try
        {
        	//Setting up the socket
        	ServerSocket serverSocket = new ServerSocket(port);
        	Socket incoming = serverSocket.accept();
        	
        	//Setting up the buffered reader and print writer to read and write to and from the socket
        	BufferedReader br = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
        	PrintWriter pw = new PrintWriter(incoming.getOutputStream(), true);
        	
        	String fileName;
        	if(!(fileName = br.readLine()).equals(""))
        	{
        		//Reading from the file
        		File file = new File(fileName);
        		Scanner inputFile = new Scanner(file);
        		
        		while (inputFile.hasNext()) 
        		{
        			//Sending the file contents back over the socket one line at a time
        			pw.println(inputFile.nextLine());
				}
        		
        		inputFile.close();
        	}
        	
        	//Closing the socket
        	incoming.close();
        	serverSocket.close();
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ReadFileOverNetworkServer s = new ReadFileOverNetworkServer();
        s.run();
    }
}
