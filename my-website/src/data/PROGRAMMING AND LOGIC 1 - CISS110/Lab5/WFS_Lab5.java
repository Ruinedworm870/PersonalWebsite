/**
 * William Smolinski
 * 11/5/21
 * Lab 5 assignment, demonstrates static methods, prompts the user with a menu of options they can
 * choose and then performs the operation based on the input they entered
 */

import java.util.Scanner;

public class WFS_Lab5
{
   public static void main(String[] args)
   {
      int choice;       // The user's choice
      double value = 0; // The method's return value
      char letter;      // The user's Y or N decision
      double radius;    // The radius of the circle
      double length;    // The length of the rectangle
      double width;     // The width of the rectangle
      double height;    // The height of the triangle
      double base;      // The base of the triangle
      double side1;     // The first side of the triangle
      double side2;     // The second side of the triangle
      double side3;     // The third side of the triangle

      // Create a scanner object to read from the keyboard
      Scanner keyboard = new Scanner(System.in);

      // The do loop allows the menu to be displayed first
      do
      {
         // TASK #1 Call the printMenu method
         printMenu();
         choice = keyboard.nextInt();

         switch(choice)
         {
            case 1:
               System.out.print("Enter the radius of " +
                                "the circle: ");
               radius = keyboard.nextDouble();

               // TASK #3 Call the circleArea method and
               // store the result in the value variable
               
               value = circleArea(radius);

               System.out.println("The area of the " +
                                  "circle is " + value);
               break;
            case 2:
               System.out.print("Enter the length of " +
                                "the rectangle: ");
               length = keyboard.nextDouble();
               System.out.print("Enter the width of " +
                                "the rectangle: ");
               width = keyboard.nextDouble();

               // TASK #3 Call the rectangleArea method and
               // store the result in the value variable
               
               value = rectangleArea(length, width);

               System.out.println("The area of the " +
                                  "rectangle is " + value);
               break;
            case 3:
               System.out.print("Enter the height of " +
                                "the triangle: ");
               height = keyboard.nextDouble();
               System.out.print("Enter the base of " +
                                "the triangle: ");
               base = keyboard.nextDouble();

               // TASK #3 Call the triangleArea method and
               // store the result in the value variable
               
               value = triangleArea(base, height);

               System.out.println("The area of the " +
                                  "triangle is " + value);
               break;
            case 4:
               System.out.print("Enter the radius of " +
                                "the circle: ");
               radius = keyboard.nextDouble();

               // TASK #3 Call the circumference method and
               // store the result in the value variable
               
               value = circleCircumference(radius);

               System.out.println("The circumference " +
                                  "of the circle is " +
                                  value);
               break;
            case 5:
               System.out.print("Enter the length of " +
                                "the rectangle: ");
               length = keyboard.nextDouble();
               System.out.print("Enter the width of " +
                                "the rectangle: ");
               width = keyboard.nextDouble();

               // TASK #3 Call the perimeter method and
               // store the result in the value variable
               
               value = rectanglePerimeter(length, width);

               System.out.println("The perimeter of " +
                                  "the rectangle is " +
                                  value);
               break;
            case 6:
               System.out.print("Enter the length of " +
                                "side 1 of the " +
                                "triangle: ");
               side1 = keyboard.nextDouble();
               System.out.print("Enter the length of " +
                                "side 2 of the " +
                                "triangle: ");
               side2 = keyboard.nextDouble();
               System.out.print("Enter the length of " +
                                "side 3 of the " +
                                "triangle: ");
               side3 = keyboard.nextDouble();

               // TASK #3 Call the perimeter method and
               // store the result in the value variable
               
               value = trianglePerimeter(side1, side2, side3);

               System.out.println("The perimeter of " +
                                  "the triangle is " +
                                  value);
               break;
            default:
               System.out.println("You did not enter " +
                                  "a valid choice.");
         }
         keyboard.nextLine(); // Consume the new line

         System.out.println("Do you want to exit " +
                            "the program (Y/N)?: ");
         String answer = keyboard.nextLine();
         letter = answer.charAt(0);

      } while(letter != 'Y' && letter != 'y');
   }

   /**
    * The printMenu method displays the menu of the options the user can choose
    */
   
   // TASK #1 Create the printMenu method here
   public static void printMenu()
   {
     System.out.print("This is a geometry claculator\n" + 
                      "Choose what you would like to calculate\n" + 
                      "1. Find the area of a circle\n" + 
                      "2. Find the area of a rectangle\n" + 
                      "3. Find the area of a triangle\n" + 
                      "4. Find the circumference of a circle\n" + 
                      "5. Find the perimeter of a rectangle\n" + 
                      "6. Find the perimeter of a triangle\n" + 
                      "Enter the number of your choice: ");
   }
   
   // TASK #2 Create the value-returning methods here
   
   /**
    * circleArea method takes the radius and return the area
    * @param radius takes the radius to perform the calculations with
    * @return returns the area as a double
    */
   
   public static double circleArea(double radius)
   {
     return Math.PI * (radius * radius);
   }
   
   /**
    * rectangleArea method takes the length and width and returns the area
    * @param length length of the rectangle
    * @param width width of the rectangle
    * @return returns the area as a double
    */
   
   public static double rectangleArea(double length, double width)
   {
     return length * width;
   }
   
   /**
    * triangleArea method takes the base and height and returns the area
    * @param base base of the triangle
    * @param height height of the triangle
    * @return returns the area as a double
    */
   
   public static double triangleArea(double base, double height)
   {
     return 0.5 * (base * height);
   }
   
   /**
    * circleCircumference method takes the radius and returns the circumference
    * @param radius radius of the circle
    * @return returns the circumference as a double
    */
   
   public static double circleCircumference(double radius)
   {
     return 2 * (Math.PI * radius);
   }
   
   /**
    * rectanglePerimeter method takes the length and width and returns the perimeter
    * @param length length of the rectangle
    * @param width width of the rectangle
    * @return returns the perimeter as a double
    */
   
   public static double rectanglePerimeter(double length, double width)
   {
     return (2 * length) + (2 * width);
   }
   
   /**
    * trianglePerimeter method takes the 3 side lengths and returns the perimeter
    * @param side1 first side of the triangle
    * @param side2 second side of the trinagle
    * @param side3 third side of the triangle
    * @return returns the perimeter as a double
    */
   
   public static double trianglePerimeter(double side1, double side2, double side3)
   {
     return side1 + side2 + side3;
   }
   // TASK #4 Write javadoc comments for each method
}