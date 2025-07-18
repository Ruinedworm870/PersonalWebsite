#File: p04.py
#Name: William Smolinski

import os
from datetime import datetime
import random
import HelperModule as H

def AddFile():
    clockTicks = round((datetime.utcnow() - datetime(1970, 1, 1)).total_seconds() * 1000)
    fileName = "file_" + str(clockTicks) + ".txt"
    num = H.getInt("How many random numbers do you want? (any number 1 - 10,000) ")

    while num < 1 or num > 10000:
        num = H.getInt("Not a valid number, enter a number between 1 and 10,000 ")

    file = open("p04files/" + fileName, "w+")
    for i in range(num):
        file.write(str(random.randint(1, 200000)) + "\n")
    file.close()

def ReadDirectoryFile():
    dir = "p04files"
    filesInDir = list()
    filesInDir = os.listdir(dir)
    num = 1

    for fileName in filesInDir:
        print(str(num) + ". " + fileName)
        num += 1
    
    print(str(num) + ". Exit back to menu")

    notValidOption = True

    while notValidOption:
        openFileNum = H.getInt("\nEnter selection -> ")

        if openFileNum != num:
            if openFileNum - 1 > len(filesInDir):
                print("Not a valid selection!")
            else:
                print(str(filesInDir[openFileNum - 1]) + ":")
                f = open(dir + "/" + filesInDir[openFileNum - 1], "r")
                print(f.read())
                f.close()
                H.clickEnter("Press enter to continue")
                notValidOption = False
        else:
            notValidOption = False

def ClearDirectoty():
    dir = "p04files"
    filesInDir = list()
    filesInDir = os.listdir(dir)

    for fileName in filesInDir:
        os.remove(dir + "/" + fileName)

    H.clickEnter("Operation successful, press enter to continue")

menu = """
MENU:

1) Add a file of numbers
2) Read a file of numbers
3) Clear directory
4) Exit

Enter selection -> """
keepGoing = True

while keepGoing:
    choice = H.getChar(menu)

    match choice:
        case '1':
            AddFile()
            
        case '2':
            ReadDirectoryFile()
            
        case '3':
            ClearDirectoty()
            
        case '4':
            print("Thanks for using the program!")
            keepGoing = False
            


