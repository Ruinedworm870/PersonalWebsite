/**
 * Circle class used to get the area, diameter, and circumference of a circle
 */

public class WFS_Circle
{
  //Declares the fields
  private double radius;
  private final double PI = 3.14159;
  
  /**
   * Constructor that sets the radius to the double entered
   * @param r Number that radius is set to
   */
  
  public WFS_Circle(double r)
  {
    radius = r;
  }
  
  /**
   * No-arg constructor that sets radius to 0.0
   */
  
  public WFS_Circle()
  {
    radius = 0.0;
  }
  
  /**
   * Sets the radius to the value passed to the method
   * @param r Number that radius is set to
   */
  
  public void setRadius(double r)
  {
    radius = r;
  }
  
  /**
   * Used to get the radius
   * @return Returns the radius field as a double
   */
  
  public double getRadius()
  {
    return radius;
  }
  
  /**
   * Used to calculate the area of the circle
   * @return Returns the area as a double
   */
  
  public double area()
  {
    return PI * radius * radius;
  }
  
  /**
   * Used to calculate the diameter of the circle
   * @return Returns the diameter as a double
   */
  
  public double diameter()
  {
    return radius * 2;
  }
  
  /**
   * Used to calculate the circumference of the circle
   * @return Returns the circumference as a double
   */
  
  public double circumference()
  {
    return 2 * PI * radius;
  }
}