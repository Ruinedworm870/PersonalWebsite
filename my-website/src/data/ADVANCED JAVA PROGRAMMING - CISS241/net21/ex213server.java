package net21;

/**
 * William Smolinski
 * CISS 241
 * Exercise 21-3: Server program to receive a Datagram message from the client and print it out to the console
 */

import java.io.*;
import java.net.*;

public class ex213server 
{
	private InetAddress host;
    private int port;
   
    public ex213server()
    {
        try
        {
            host = InetAddress.getLocalHost(); // host computer
            port = 7777;   // wait on port 7777
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
  /* Create DatagramSocket connected to port, create byte array, create
     DatagramPacket for byte array.  Wait to receive packet, then get the
     message and sender address from the packet.  Print to screen who the
     sender is, what the sender's name is, and what the message is. Close the socket.
  */	
        	
        	DatagramSocket serverSocket = new DatagramSocket(port);
        	byte[] buffer = new byte[256];
        	DatagramPacket indgp = new DatagramPacket(buffer, buffer.length);
        	
        	serverSocket.receive(indgp);
        	InetAddress senderAddress = indgp.getAddress();
        	String message = new String(indgp.getData(), 0, indgp.getLength());
        	
        	System.out.println("Sender Address: " + senderAddress);
        	System.out.println("Sender Name: " + senderAddress.getHostName());
        	System.out.println("Message: " + message);
        	
        	serverSocket.close();
        }
        catch(SocketException ss)
        {
            ss.printStackTrace();
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ex213server s = new ex213server();
        s.run();
    }
}
