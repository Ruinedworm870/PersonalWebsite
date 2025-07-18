package graphics15;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;
import java.util.Random;

/**
 * William Smolinski
 * CISS 241
 * Exercise 15-2a: draws randomly colored and thick horizontal lines down the frame
 */

public class ex152a extends JFrame
{
	//Used so that it only paints once on startup
	private boolean first = true;
	
	public ex152a()
	{
		setSize(500, 500);
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		//Won't do anything the first time it is called (was being called twice on startup and causing the lines to overlap)
		if(!first)
		{
			Graphics2D graphics2d = (Graphics2D) g;
			int yIncrement = 10;
			Color[] colors = {Color.black, Color.orange, Color.blue, Color.green, Color.darkGray, Color.cyan, Color.gray};
			Random random = new Random();
			int randomNum = 0;
			
			Line2D.Float l;
			BasicStroke b1;
			
			for(int i = 0; i < getHeight(); i += yIncrement)
			{	
				//Getting random color
				randomNum = random.nextInt(colors.length);
				graphics2d.setColor(colors[randomNum]);
				
				//Getting random width
				randomNum = random.nextInt(getWidth()) + 1;
				l = new Line2D.Float(0, i, randomNum, i);
				
				//Getting random thickness
				randomNum = random.nextInt(yIncrement) + 1;
				b1 = new BasicStroke(randomNum, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
				
				graphics2d.draw(l);
				graphics2d.setStroke(b1);
			}
		}
		else 
		{
			first = false;
		}
	}
	
	public static void main(String[] args)
	{
		ex152a f = new ex152a();
	}
}
