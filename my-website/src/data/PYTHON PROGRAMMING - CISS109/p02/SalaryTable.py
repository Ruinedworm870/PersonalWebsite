#File: SalaryTable.py
#William Smolinski

salary = float(input("What is the starting salary? "))
increase = (float(input("What is the percentage increase per year? ")) / 100) + 1
years = int(input("How many years of experience? "))

print("\nSalary Schedule:")
print("Year".ljust(5, " ") + "\t" + "Salary".center(10, " "))

for i in range(years + 1):
    output = "{}".ljust(5, " ") + "\t$" + "{:.2f}".rjust(10, " ")
    print(output.format(i, salary))
    
    salary *= increase
