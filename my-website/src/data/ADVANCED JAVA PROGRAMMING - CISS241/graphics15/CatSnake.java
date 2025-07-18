package graphics15;

import java.awt.*;
import java.awt.desktop.ScreenSleepEvent;
import java.awt.geom.*;
import javax.swing.JFrame;

/**
 * William Smolinski
 * CISS 241
 * Cat Snake assignment: Draws a scene with a cat that moves across the screen until it reaches the edge. When it is started
 * the background scene is created which includes a sun, tree with leaves, blue-white gradient sky, and green grass. The cat is 
 * also created on start and begins to move. There is a tenth of a second delay between each time the cat moves. When the cat moves
 * the program redraws the grass then draws the cat at a larger x value until it reaches the edge of the screen.
 */

public class CatSnake extends JFrame
{
	//Used to keep track if it is the first time the paint method has been called
	private boolean first = true;
	
	//The x value of the cat
	private int x = 40;
	
	public CatSnake()
	{
		setSize(750, 500);
		setVisible(true);
	}
	
	public void update(Graphics g)
	{
		paint(g);
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		int y = (getHeight() / 2) + 50;
		
		//If it is the first time the program will set everything up and it if itsn't, it will move the cat
		if(first)
		{
			//Creating the sky
			Point2D skyTopLeft = new Point2D.Float(0, 0);
			Point2D skyBottomRight = new Point2D.Float(getWidth(), getHeight() / 2);
			GradientPaint sky = new GradientPaint(skyTopLeft, Color.cyan, skyBottomRight, Color.white);
			g2.setPaint(sky);
			Rectangle2D skyBox = new Rectangle2D.Float(0, 0, getWidth(), getHeight() / 2);
			g2.fill(skyBox);
			
			//Creating the ground
			g2.setColor(Color.green);
			Rectangle2D ground = new Rectangle2D.Float(0, getHeight() / 2, getWidth(), getHeight() / 2);
			g2.fill(ground);
			
			//Creating the tree trunk
			g2.setColor(Color.darkGray);
			Rectangle2D trunk = new Rectangle2D.Float(getWidth() / 2, (getHeight() / 2) - 100, 10, 100);
			g2.fill(trunk);
			
			//Creating the tree leaves
			g2.setColor(Color.green);
			Arc2D leaves = new Arc2D.Float((getWidth() / 2) - 45, (getHeight() / 2) - 125, 100, 75, 0, 180, Arc2D.OPEN);
			g2.fill(leaves);
			
			//Creating the sun
			g2.setColor(Color.yellow);
			Ellipse2D sun = new Ellipse2D.Float(75, 50, 50, 50);
			g2.fill(sun);
			
			//Creating the cat
			g2.setColor(Color.red);
			GeneralPath cat = new GeneralPath();
			BasicStroke b1 = new BasicStroke(3);
			
			cat.moveTo(x, y);
			cat.lineTo(x += 30, y);
			cat.lineTo(x += 10, y -= 10);
			cat.lineTo(x, y += 50);
			cat.lineTo(x -= 50, y);
			cat.lineTo(x, y -= 50);
			cat.lineTo(x += 10, y += 10);
			
			g2.setStroke(b1);
			g2.draw(cat);
			
			//Creating the eyes
			g2.setColor(Color.blue);
			Ellipse2D leftEye = new Ellipse2D.Float(x, y + 10, 10, 10);
			Ellipse2D rightEye = new Ellipse2D.Float(x + 20, y + 10, 10, 10);
			g2.fill(leftEye);
			g2.fill(rightEye);
			
			first = false;
		}
		
		//Will loop until the cat is at the edge of the screen
		while(x + 50 < getWidth())
		{
			x += 10;
			
			try 
			{
				//Sleeps for a tenth of a second
				Thread.sleep(100);
			} 
			catch (InterruptedException e) 
			{
				//Do nothing
			}
			
			//Drawing over the previous drawing
			g2.setColor(Color.green);
			Rectangle2D ground = new Rectangle2D.Float(0, getHeight() / 2, getWidth(), getHeight() / 2);
			g2.fill(ground);
			
			//Creating the cat
			g2.setColor(Color.red);
			GeneralPath cat = new GeneralPath();
			BasicStroke b1 = new BasicStroke(3);
			
			cat.moveTo(x, y);
			cat.lineTo(x += 30, y);
			cat.lineTo(x += 10, y -= 10);
			cat.lineTo(x, y += 50);
			cat.lineTo(x -= 50, y);
			cat.lineTo(x, y -= 50);
			cat.lineTo(x += 10, y += 10);
			
			g2.setStroke(b1);
			g2.draw(cat);
			
			//Creating the eyes
			g2.setColor(Color.blue);
			Ellipse2D leftEye = new Ellipse2D.Float(x, y + 10, 10, 10);
			Ellipse2D rightEye = new Ellipse2D.Float(x + 20, y + 10, 10, 10);
			g2.fill(leftEye);
			g2.fill(rightEye);
			
			repaint();
		}
	}

	public static void main(String[] args)
	{
		CatSnake f = new CatSnake();
	}
}
