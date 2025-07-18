/**
 * William Smolinski
 * 11/19/21
 * Rectangular Prism assignment, Used to call the Rectangular Prism class to get information about a rectangular prism
 */

public class WFS_RectangularPrismDemo
{
  public static void main(String[] args)
  {
    //Declares the two rectangular prism objects
    WFS_RectangularPrism prism1 = new WFS_RectangularPrism();
    WFS_RectangularPrism prism2 = new WFS_RectangularPrism(5, 10, 20);
    
    //Prints the information about the two prisms
    System.out.println("Prism 1 (No-Arg Constructor):");
    System.out.printf(prism1.toString());
    
    System.out.println();
    
    System.out.println("Prism 2 (Constructor with parameters):");
    System.out.printf(prism2.toString());
    
    System.out.println();
    
    //Prints information of prism1 after testing set methods
    System.out.println("Setting Prism1 length = 10, width = 20, height = 30 using set methods...");
    prism1.setLength(10);
    prism1.setWidth(20);
    prism1.setHeight(30);
    
    System.out.println("Updated Prism 1 (after testing set methods):");
    System.out.printf(prism1.toString());
    
  }
}