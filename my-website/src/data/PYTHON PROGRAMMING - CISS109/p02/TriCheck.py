#File: TriCheck.py
#William Smolinski

side1 = int(input("What is the length of the first side? ")) ** 2
side2 = int(input("What is the length of the second side? ")) ** 2
side3 = int(input("What is the length of the third side? ")) ** 2

if ((side1 + side2 == side3) or (side2 + side3 == side1)
    or (side3 + side1 == side2)):
    print("\nIs a right triangle")
else:
    print("\nIs not a right triangle")
