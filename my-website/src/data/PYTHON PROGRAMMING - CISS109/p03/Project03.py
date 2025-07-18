#File: Project03.py
#William Smolinski

import HelperModule
import LambdaAreas

def GetTriangleArea():
    base = HelperModule.GetFloat("Enter the base of the triangle: ")

    height = HelperModule.GetFloat("Enter the height of the triangle: ")
    
    print("\nTRIANGLE: \n" +
          "Base: " + str(base) + "\n" +
          "Height: " + str(height) + "\n" +
          "Area: " + str(LambdaAreas.TriangleArea(base, height)) + "\n") 

def GetSquareArea():
    side = HelperModule.GetFloat("Enter the side length of the square: ")

    print("\nSQUARE: \n" +
          "Side length: " + str(side) + "\n" +
          "Area: " + str(LambdaAreas.SquareArea(side)) + "\n")
    
def GetRectangleArea():
    length = HelperModule.GetFloat("Enter the length of the rectangle: ")

    width = HelperModule.GetFloat("Enter the width of the rectangle: ")

    print("\nRECTANGLE: \n" +
          "Length: " + str(length) + "\n" +
          "Width: " + str(width) + "\n" +
          "Area: " + str(LambdaAreas.RectangleArea(length, width)) + "\n")

def GetCircleArea():
    radius = HelperModule.GetFloat("Enter the radius of the circle: ")

    print("\nCIRCLE: \n" +
          "Radius: " + str(radius) + "\n" +
          "Area: " + str(LambdaAreas.CircleArea(radius)) + "\n")

def GetRhombusArea():
    diagonal1 = HelperModule.GetFloat("Enter the length of the first diagonal on the rhombus: ")

    diagonal2 = HelperModule.GetFloat("Enter the length of the second diagonal on the rhombus: ")

    print("\nRHOMBUS: \n" +
          "Diagonal 1: " + str(diagonal1) + "\n" +
          "Diagonal 2: " + str(diagonal2) + "\n" +
          "Area: " + str(LambdaAreas.RhombusArea(diagonal1, diagonal2)) + "\n")

def GetTrapezoidArea():
    smallBase = HelperModule.GetFloat("Enter the length of the small base on the trapezoid: ")

    largeBase = HelperModule.GetFloat("Enter the length of the large base on the trapezoid: ")

    height = HelperModule.GetFloat("Enter the height of the trapezoid: ")

    print("\nTRAPEZOID: \n" +
          "Small base: " + str(smallBase) + "\n" +
          "Large base: " + str(largeBase) + "\n" +
          "Height: " + str(height) + "\n" +
          "Area: " + str(LambdaAreas.TrapezoidArea(smallBase, largeBase, height)) + "\n")

repeat = True
menu = """
1) Calculate the area of a Triangle
2) Calculate the area of a Square
3) Calculate the area of a Rectangle
4) Calculate the area of a Circle
5) Calculate the area of a Rhombus
6) Calculate the area of a Trapezoid
7) Exit

Enter Selection: """

while repeat:
    choice = input(menu)

    match choice:
        case "1":
            GetTriangleArea()

        case "2":
            GetSquareArea()

        case "3":
            GetRectangleArea()

        case "4":
            GetCircleArea()

        case "5":
            GetRhombusArea()

        case "6":
            GetTrapezoidArea()

        case "7":
            print("Thanks for using the program.")
            repeat = False

        case _:
            print("Not a valid choice, try again.")

        
            
            
    
