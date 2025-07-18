package net21;

/**
 * William Smolinski
 * CISS 241
 * Exercise 21-3: Client program to send a message to the server using a Datagram socket
 */

import java.io.*;
import java.net.*;

public class ex213client 
{
	private int port;
    private InetAddress host;
   
    public ex213client()
    {
        try
        {
            port = 7777;  // server's port number
            
            host = InetAddress.getByName("192.168.56.1");  
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
  /* Create DatagramSocket, create DatagramPacket out of message and who
     the host and port are.  Send the packet.  Close the socket
  */
        	
        	DatagramSocket clientSocket = new DatagramSocket();
        	DatagramPacket outdgp = new DatagramPacket(mes.getBytes(), mes.length(), host, port);
        	
        	clientSocket.send(outdgp);
        	
        	clientSocket.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
   
    public static void main(String[] args) throws IOException
    {
        String line;
        BufferedReader br = new
            BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a message:  ");
        line = br.readLine();
       
        ex213client c = new ex213client();
        c.run(line);  // send message to run()
    }
}
