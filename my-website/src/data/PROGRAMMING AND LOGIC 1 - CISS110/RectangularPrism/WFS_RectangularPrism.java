/**
 * Rectangular Prism class is used to input data about a rectangular prism and receive information about it, such as volume and surface area.
 */

public class WFS_RectangularPrism
{
  //Fields
  private double length;
  private double width;
  private double height;
  
  /**
   * Constructor that sets all of the fields to 1.0
   */
  
  public WFS_RectangularPrism()
  {
    length = 1.0;
    width = 1.0;
    height = 1.0;
  }
  
  /**
   * Constructor used to set the fields to the variables passed to the method
   * @param l Length of the prism
   * @param w Width of the prism
   * @param h Height of the prism
   */
  
  public WFS_RectangularPrism(double l, double w, double h)
  {
    length = l;
    width = w;
    height = h;
  }
  
  /**
   * Used to set the length to the value passed to the method
   * @param l Length of the prism
   */
  
  public void setLength(double l)
  {
    length = l;
  }
  
  /**
   * Used to set the width to the value passed to the method
   * @param w Width of the prism
   */
  
  public void setWidth(double w)
  {
    width = w;
  }
  
  /**
   * Used to set the height to the value passed to the method
   * @param h Height of the prism
   */
  
  public void setHeight(double h)
  {
    height = h;
  }
  
  /**
   * Used to get the length of the prism
   * @return Returns the length as a double
   */
  
  public double getLength()
  {
    return length;
  }
  
  /**
   * Used to get the width of the prism
   * @return Returns the width as a double
   */
  
  public double getWidth()
  {
    return width;
  }
  
  /**
   * Used to get the height of the prism
   * @return Returns the height as a double
   */
  
  public double getHeight()
  {
    return height;
  }
  
  /**
   * Used to get the volume of the prism
   * @return Returns the volume as a double
   */
  
  public double getVolume()
  {
    return length * width * height;
  }
  
  /**
   * Used to get the surface area of the prism
   * @return Returns the surface area as a double
   */
  
  public double getSurfaceArea()
  {
    return 2 * ((width * length) + (length * height) + (height * width));
  }
  
  /**
   * Used to output the information
   * @return Returns the String
   */
  
  public String toString()
  {
    return String.format("Length: %.2f \nWidth: %.2f \nHeight: %.2f \nVolume: %.2f \nSurface Area: %.2f\n", 
                         getLength(), getWidth(), getHeight(), getVolume(), getSurfaceArea());
  }
}