package threads14;

/* William Smolinski
 * Exercise 14-4
 * This class will define a moving ball
 */
import java.awt.*;
import javax.swing.*;

public class ball144 extends JFrame implements Runnable 
        /* since extends JFrame, must implements Runnable
           since can only extends one class */
{
    boolean stopflag;
    int x, y;
    int width, height;
    
    public ball144()
    {
        setBackground(Color.cyan);
        stopflag = false;
        x = 0;
        y = 50;
        setTitle("Ball");
        setForeground(Color.blue);
        
        width = 20;
        height = 20;
    }
    
    @Override
    public void run() 
    {
    	stopflag = false;
    	
    	//Will run until the ball is at the edge of the screen
    	while(!stopflag && x < getWidth())
    	{
    		repaint();
    	}
    	
    	//Calls end which will draw it one last time
    	end();
    }
    
    public void update(Graphics g)
    {
    	paint(g);
    }
    
    public void paint(Graphics g)
    {
    	//Draws over the entire line that the ball will travel on, covering up the previous drawing
    	g.setColor(getBackground());
    	g.fillRect(0, y, getWidth(), height);
    	
    	//Draws the new ball
    	g.setColor(getForeground());
    	g.fillOval(x, y, width, height);
    	
    	try 
    	{
    		//Sleeps for a tenth of a second
			Thread.sleep(100);
		} 
    	catch (InterruptedException e) 
    	{
			//Does nothing
    	}
    	
    	//Increments x
    	x += 5;
    }

    public void end()
    {
    	//If statement so the ball doesn't move if you press the button again after you pressed it the first time
    	if(!stopflag)
    	{
    		//Stops the while loop and draws the ball one more time
        	stopflag = true;
        	repaint();
    	}
    }
}