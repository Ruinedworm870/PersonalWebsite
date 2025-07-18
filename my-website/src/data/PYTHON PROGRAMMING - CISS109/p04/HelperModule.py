#File: HelperModule.py
#prompt is the directions, or instructions for the user prompt.

#Function getString
def getString(prompt): 
    valid=False
    while valid==False:
        myString=input(prompt)
        if (len(myString)>0):
            valid=True
        else: 
            print("Your entry cannot be empty. Please try again.")
    return myString

#Function getInt
def getInt(prompt):
    while True: 
        try: 
            iNum=int(getString(prompt))
            break 
        except ValueError: 
            print("That is not a valid integer, please try again")
    return iNum 

#Function getFloat
def getFloat(prompt):
    while True: 
        try: 
            fNum=float(getString(prompt))
            break 
        except ValueError: 
            print("That is not a valid float, please try again")
    return fNum 

def getChar(prompt):
    return getString(prompt)[0]

def getLowerChar(prompt):
    return getChar(prompt).lower()

def getupperChar(prompt):
    return getChar(prompt).upper()

def clickEnter(prompt):
    input(prompt)