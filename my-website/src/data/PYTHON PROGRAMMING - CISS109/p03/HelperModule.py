#File: HelperModule.py
#William Smolinski

def GetString(prompt):
    valid = False

    while valid == False:
        mystring = input(prompt)

        if len(mystring) > 0:
            valid = True
        else:
            print("Your entry cannot be empty!!! Please try again.")
            
        return mystring

def GetInt(prompt):
    while True:
        try:
            inum = int(GetString(prompt))
            break
        except ValueError:
            print("That is not a valid integer!!! Please try again.")
            
    return inum

def GetFloat(prompt):
    while True:
        try:
            fnum = float(GetString(prompt))
            #Modified the script to include this to check for a positive value
            if fnum > 0:
                break
            else:
                print("Enter a value greater than 0")
        except ValueError:
            print("That is not a valid float!!! Please try again.")

    return fnum

def GetChar(prompt):
    return GetString(prompt)[0]

def GetLowerChar(prompt):
    return GetChar(prompt).lower()

def main():
    help(GetString)
    print("Your string is: " + GetString("Enter a string: "))
    help(GetInt)
    print("Youd integer is: " + str(GetInt("Enter an integer: ")))
    help(GetFloat)
    print("Your float is: " + str(GetFloat("Enter a Float: ")))
    help(GetLowerChar)
    print("Your character (lowercase) is " + str(GetLowerChar("Enter a character: ")))

if __name__ == "__main__":
    main()
