package graphics15;

import java.awt.*;
import javax.swing.*;

/**
 * William Smolinski
 * CISS 241
 * Exercise 15-10: Creates the lycos search page
 */

public class ex1510 extends JFrame
{
	JTextField search = new JTextField();
	JButton button = new JButton("Search");
	
	JCheckBox webBox = new JCheckBox("Web");
	JCheckBox imageBox = new JCheckBox("Image");
	
	JLabel image = new JLabel(new ImageIcon("graphics15/lycos.png"));
	
	Font font = new Font("Arial", Font.BOLD, 13);
	
	public ex1510()
	{
		setSize(600, 240);
		setVisible(true);
		
		//Setting up the container
		Container c = getContentPane();
		c.setBackground(Color.cyan);
		c.setLayout(null);
		
		//Creating the search bar
		search.setBounds(270, 60, 200, 25);
		add(search);
		
		//Creating the button
		button.setBounds(480, 60, 80, 25);
		button.setForeground(Color.blue);
		button.setFont(font);
		add(button);
		
		//Creating the web check box
		webBox.setBounds(270, 30, 100, 20);
		webBox.setFont(font);
		webBox.setForeground(Color.blue);
		webBox.setBackground(Color.cyan);
		webBox.setSelected(true);
		add(webBox);
		
		//Creating the image check box
		imageBox.setBounds(370, 30, 100, 20);
		imageBox.setFont(font);
		imageBox.setForeground(Color.blue);
		imageBox.setBackground(Color.cyan);
		add(imageBox);
		
		//Creating the image
		image.setBounds(5, 25, 260, 90);
		add(image);
	}
	
	public static void main(String[] args)
	{
		ex1510 f = new ex1510();
	}
}
