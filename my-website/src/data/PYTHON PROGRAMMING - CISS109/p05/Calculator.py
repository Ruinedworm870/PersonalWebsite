#File: Calculator.py
#William Smolinski

from tkinter import *

def hideFileButton():
    saveToFileBtn.grid_remove()

def showFileButton():
    saveToFileBtn.grid_configure()
    
def calculate():
    if len(firstNumEntry.get()) > 0 and len(secondNumEntry.get()) > 0:
        try:
            num1 = int(firstNumEntry.get())
            num2 = int(secondNumEntry.get())

            addition = str((num1 + num2))
            subtraction = str(num1 - num2)
            multiplication = str(num1 * num2)

            if num2 != 0:
                division = str(num1 / num2)
            else: 
                division = "Cannot divide by zero"
            
            data["v1"] = str(num1)
            data["v2"] = str(num2)
            data["+"] = addition
            data["-"] = subtraction
            data["x"] = multiplication
            data["/"] = division

            outputText("Addition: " + addition + "\n\n" +
            "Subtraction: " + subtraction + "\n\n" +
            "Multiplication: " + multiplication + "\n\n" +
            "Division: " + division, "black")

            showFileButton()
        except ValueError:
            outputText("One or more of your values is not a number!", "red")
    else:
        outputText("Please enter a value for both fields", "red")

def outputText(text, color):
    resultsLbl.configure(text = text, fg = color)

def clear():
    hideFileButton()
    resultsLbl.configure(text = "")
    firstNumEntry.delete(0, END)
    secondNumEntry.delete(0, END)

def saveToFile():
    f = open("./files/Calculations.txt", 'a+')

    f.write(str(data) + "\n")
        
    f.close()
    clear()

data = {}

#Creating the GUI

root = Tk()

root.title("p05 - Calculator")
root.geometry('300x300')

firstNumLbl = Label(root, text = "First Number: ")
firstNumLbl.grid(row = 0, column = 0, sticky = E, pady = 5)

secondNumLbl = Label(root, text = "Second Number: ")
secondNumLbl.grid(row = 1, column = 0, sticky = E, pady = 5)

firstNumEntry = Entry(root)
firstNumEntry.grid(row = 0, column = 1, columnspan = 2, pady = 5)

secondNumEntry = Entry(root)
secondNumEntry.grid(row = 1, column = 1, columnspan = 2, pady = 5)

calculateButton = Button(root, text = "Calculate", command = calculate)
calculateButton.grid(row = 2, column = 0, sticky = 'we', pady = 5, padx = 5)

clearButton = Button(root, text = "Clear", command = clear)
clearButton.grid(row = 2, column = 1, sticky = 'we', pady = 5, padx = 5)

saveToFileBtn = Button(root, text = "Save to File", command = saveToFile)
saveToFileBtn.grid(row = 2, column = 2, sticky = 'we', pady = 5, padx = 5)
hideFileButton()

resultsLbl = Label(root)
resultsLbl.grid(row = 3, column = 0, columnspan = 3, sticky = 'we', pady = 5)

root.mainloop()