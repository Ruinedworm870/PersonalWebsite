package gui16;
/* William Smolinski
 * Exercise 16-4
 * This program will use a toolbar and menubar to pick a graphic
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ex164 extends JFrame implements ActionListener
{
    JButton b = new JButton("Brosius");
    JButton m = new JButton("Martinez");
    JButton j = new JButton("Jeter");
    JToolBar bar = new JToolBar(SwingConstants.VERTICAL);
    JMenuItem br = new JMenuItem("Brosius");
    JMenuItem ma = new JMenuItem("Martinez");
    JMenuItem je = new JMenuItem("Jeter");
    JMenu homers = new JMenu("Home Runs");
    JMenuBar mbar = new JMenuBar();
    Container c;
    ImageIcon bros, mart, jet;

    public ex164()
    {
        setSize(500, 500);
        c = getContentPane();
        c.setLayout(new FlowLayout());
        setJMenuBar(mbar);
        
        //Setting the hot keys
        b.setMnemonic('b');
        m.setMnemonic('m');
        j.setMnemonic('j');
        
        //Adding the buttons to the toolbar and the toolbar to the frame
        bar.add(b);
        bar.add(m);
        bar.add(j);
        c.add(bar);
        
        //Listening to the toolbar button actions
        b.addActionListener(this);
        m.addActionListener(this);
        j.addActionListener(this);
        
        //Getting the images
        bros = new ImageIcon("gui16/brosius.jpg");
        mart = new ImageIcon("gui16/martinez.jpg");
        jet = new ImageIcon("gui16/jeter.jpg");
        
        //Adding the menu items to the menu bar
        homers.add(br);
        homers.add(ma);
        homers.add(je);
        mbar.add(homers);
        
        //Listening to the menu bar buttons
        br.addActionListener(this);
        ma.addActionListener(this);
        je.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        Graphics g = getGraphics();  // to draw
        paint(g);  // clear screen

 // if click on b button or br menu item draw brosius at 100, 100, etc.    
        if (e.getSource() == b || e.getSource() == br) 
            bros.paintIcon(this, g, 100, 100);
        else if (e.getSource() == m || e.getSource() == ma)
            mart.paintIcon(this, g, 100, 100);
        else if (e.getSource() == j || e.getSource() == je)
            jet.paintIcon(this, g, 100, 100);
    }
    public static void main(String[] args)
    {
        ex164 f = new ex164();
        f.setVisible(true);
    }
}
