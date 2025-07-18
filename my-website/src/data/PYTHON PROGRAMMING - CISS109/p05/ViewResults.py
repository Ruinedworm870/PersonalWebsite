#File: ViewResults.py
#William Smolinski

import HelperModule

def viewAllResults(lines):
    print("\n\t****************************************************************************************************************\n")
    print("{:20} {:20} {:30} {:30} {:30} {:30}".format("Value 1", "Value 2", "+", "-", "x", "/"))

    data = {}
    for line in lines:
        data = eval(line)

        print("{:20} {:20} {:30} {:30} {:30} {:30}".format(data["v1"], data['v2'], data["+"], data["-"], data["x"], data["/"]))

    print("\n\t****************************************************************************************************************\n")

    HelperModule.clickEnter("Press enter to continue")

def viewParticularResults(lines):
    data = {}
    count = 1
    print()
    for line in lines:
        data = eval(line)
        print(str(count) + ". Value 1: " + data["v1"] + ", Value 2: " + data["v2"])
        count += 1

    print(str(count) + ". Exit to main menu")

    keepAsking = True
    while keepAsking:
        selection = HelperModule.getInt("\nEnter selection: ")

        if selection - 1 < len(lines) and selection - 1 >= 0:
            keepAsking = False
            selection -= 1
        elif selection - 1 == len(lines):
            keepAsking = False
            selection = -1
        else:
            print("Not a valid selection!")

    if selection >= 0:
        print("\n\t****************************************************************************************************************\n")
        print("\n{:20} {:20} {:30} {:30} {:30} {:30}".format("Value 1", "Value 2", "+", "-", "x", "/"))
        data = eval(lines[selection])
        print("{:20} {:20} {:30} {:30} {:30} {:30}\n".format(data["v1"], data['v2'], data["+"], data["-"], data["x"], data["/"]))
        print("\n\t****************************************************************************************************************\n")
        HelperModule.clickEnter("Press enter to continue")

    

def clearResults(filePath):
    f = open(filePath, 'w')
    f.write("")
    f.close()
    print("\nFILE CLEARED\n")

keepGoing = True
fileExists = False

menu = """
    Calculations Menu

    1. View a particular set of results
    2. View all results
    3. Clear all results
    4. Exit

    Choose an option: """

filePath = "./files/Calculations.txt"
lines = []

#Makes sure the file exists
try:
    f = open(filePath, 'r')
    fileExists = True
    lines = f.readlines()
    f.close()
except Exception:
    print("File does not exist!")

if fileExists:
    while keepGoing:
        option = HelperModule.getChar(menu)

        if option == '1':
            viewParticularResults(lines)
        elif option == '2':
            viewAllResults(lines)
        elif option == '3':
            clearResults(filePath)
        elif option == '4':
            print("\nThanks for using the program!")
            keepGoing = False
        else:
            print("\nNot a valid option!")