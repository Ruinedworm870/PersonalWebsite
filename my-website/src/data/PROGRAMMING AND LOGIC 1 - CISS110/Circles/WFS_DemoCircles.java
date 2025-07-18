/**
 * William Smolinski
 * 11/19/21
 * Circles assignment, uses the Circle class to output information about the circle
 */

import java.util.Scanner;

public class WFS_DemoCircles
{
  public static void main(String[] args)
  {
    //Declares the Scanner to detect user input
    Scanner keyboard = new Scanner(System.in);
    
    //Asks the user for the radius and sets it to the circle object
    System.out.print("Enter the radius for the circle: ");
    WFS_Circle circle = new WFS_Circle(keyboard.nextDouble());
    
    //Displays the information about the first circle
    System.out.print("\nCircle 1:" +
                     "\nArea: " + circle.area() + 
                     "\nDiameter: " + circle.diameter() + 
                     "\nCircumference: " + circle.circumference());
    
    System.out.println();
    
    //Creates and displays information about the circle using a no-arg consructor
    WFS_Circle circle2 = new WFS_Circle();
    
    System.out.println("\nCircle 2:" + 
                       "\nArea: " + circle2.area() + 
                       "\nDiameter: " + circle2.diameter() + 
                       "\nCircumference: " + circle2.circumference());
    
    //Displays information about circle 2 after using setRadius() method
    System.out.print("\nEnter the radius for circle 2: ");
    circle2.setRadius(keyboard.nextDouble());
    
    System.out.println("\nCircle 2 UPDATED:" + 
                       "\nArea: " + circle2.area() + 
                       "\nDiameter: " + circle2.diameter() + 
                       "\nCircumference: " + circle2.circumference());
  }
}