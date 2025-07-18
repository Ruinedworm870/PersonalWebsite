package net21;

/**
 * William Smolinski
 * CISS 241
 * Exercise 21-2: Server program to receive messages from a client using TCP/IP socket
 */

import java.io.*;
import java.net.*;

public class ex212server 
{
	private InetAddress host;
    private int port;
   
    public ex212server()
    {
        try
        {
            host = InetAddress.getLocalHost(); // use server computer as host
            port = 7777;  // wait on port #7777
            System.out.println("Server name is " + host.getHostName());
            System.out.println("Server address is " + host);
            System.out.println("Port is " + port);
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
  /* Create ServerSocket and Socket.  Then create BufferedReader connected to Socket.
     Print where message is coming from and print the message.  Create a PrintWriter
     connected to the Socket, then send back a message over the Socket that the message
     was received.  Close all the Sockets.
  */
        	
        	ServerSocket serverSocket = new ServerSocket(port);
        	Socket incoming = serverSocket.accept();
        	
        	BufferedReader br = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
        	PrintWriter pw = new PrintWriter(incoming.getOutputStream(), true);
        	
        	String str;
        	if(!(str = br.readLine()).equals(""))
        	{
        		System.out.println("Message is coming from: " + incoming.getInetAddress());
        		System.out.println("Message: " + str);
        		pw.println("Message received");
        	}
        	
        	incoming.close();
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ex212server s = new ex212server();
        s.run();
    }
}
