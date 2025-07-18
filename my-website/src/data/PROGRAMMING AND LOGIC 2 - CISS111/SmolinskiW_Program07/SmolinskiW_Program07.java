/**
 * William Smolinski
 * CISS 111
 * Program07 - Creates a GUI and gathers input to determine if the number entered is prime or print out the prime factors
 */

package com.example.smolinskiw_program07;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.ArrayList;

public class SmolinskiW_Program07 extends Application {

    @Override
    public void start(Stage stage) throws IOException
    {
        //Creates a label with the instructions
        Label instructions = new Label("Enter a number greater than 0:");

        //Creates a TextField to get input and sets it width to look nicer
        TextField inputText = new TextField();
        inputText.setMaxWidth(125);

        //Creates a ToggleGroup so only one radio button is selected at a time
        ToggleGroup group = new ToggleGroup();

        //Creates the radio buttons to decide what operation to perform and sets them to the ToggleGroup
        RadioButton isPrime = new RadioButton("Prime number?");
        isPrime.setToggleGroup(group);

        RadioButton primeFactors = new RadioButton("Prime factors?");
        primeFactors.setToggleGroup(group);

        //Creates a label with the output
        Label output = new Label();

        //Creates the cancel button
        Button cancelButton = new Button("Cancel");

        //Sets an event handler for the cancelButton
        cancelButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                //Closes the GUI
                stage.close();
            }
        });

        //Creates the calculate button
        Button calculateButton = new Button("Calculate");

        //Sets an event handler for the calculateButton
        calculateButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                //Determines if any radio button is pressed
                if(isPrime.isSelected() || primeFactors.isSelected())
                {
                    //Determines if the input in the TextField is valid
                    if(checkInput(inputText.getText()))
                    {
                        //Determines which button was pressed and calls there respective methods and then sets the output text
                        if(isPrime.isSelected())
                        {
                            output.setText(handleIsPrime(inputText.getText()));
                        }
                        else
                        {
                            output.setText(handlePrimeFactors(inputText.getText()));
                        }
                    }
                    else
                    {
                        //Displays that the input is invalid
                        output.setText("Input is invalid");
                    }
                }
                else
                {
                    //No option was selected
                    output.setText("No option selected");
                }
            }
        });

        //Organizes the buttons in an HBox
        HBox buttonHBox = new HBox(cancelButton, calculateButton);
        buttonHBox.setSpacing(25);
        buttonHBox.setAlignment(Pos.CENTER);

        //Creates the VBox to organize the elements vertically with spacing and centers it
        VBox vbox = new VBox(instructions, inputText, isPrime, primeFactors, output, buttonHBox);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.TOP_CENTER);

        //Creates the scene
        Scene scene = new Scene(vbox, 350, 175);

        //Sets the scene to the stage
        stage.setScene(scene);

        //Sets the title and shows the stage
        stage.setTitle("SmolinskiW_Program07");
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

    /**
     * Method to determine whether the input is valid or not
     * @param input Input in the TextField
     * @return Returns the result as a boolean
     */
    public static boolean checkInput(String input)
    {
        //Number to test if it is valid
        int num = 0;

        //Try Catch clause to get the number from the String
        try
        {
            num = Integer.parseInt(input);
        }
        catch (Exception e)
        {
            //Not a number
            return false;
        }

        //If the number is greater than 0 it is valid
        if(num > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Method to handle the calling isPrime method and returning the result as a String for output
     * @param input Input from the TextField
     * @return Returns a String to be output
     */
    public static String handleIsPrime(String input)
    {
        //int to hold the number to test
        int num = Integer.parseInt(input);

        if(isPrime(num))
        {
            return num + " is prime";
        }
        else
        {
            return num + " is not prime";
        }
    }

    /**
     * Method to determine if a number is prime or not
     * @param num Number to test if it is prime
     * @return Returns the result as a boolean
     */
    public static boolean isPrime(int num)
    {
        //If a number is even it is not prime except for 2, 1 is also not prime
        if((num % 2 == 0 && num != 2) || num == 1)
        {
            return false;
        }

        //Determines all odd numbers up to the square root of num and tests if num is evenly divisible by them
        for(int i = 3; i * i <= num; i += 2)
        {
            if(num % i == 0)
            {
                return false;
            }
        }

        return true;
    }

    public static String handlePrimeFactors(String input)
    {
        //int to hold the number to test
        int num =  Integer.parseInt(input);

        //String to hold all the prime factors from the ArrayList
        String primeFactorsString = "";

        //Declares and ArrayList to hold all the prime factors
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();

        //Calls the calculateFactors method and assigns the result to the ArrayList
        primeFactors = calculateFactors(num, primeFactors, 3);

        //If there is more than one prime factor (the number itself is not prime)
        if(primeFactors.size() > 1)
        {
            //Concatenates each prime factor in the ArrayList onto the primeFactorsString
            for(int i = 0; i < primeFactors.size(); i++)
            {
                primeFactorsString += primeFactors.get(i);

                //Will add a comma after every number but the last one
                if(i + 1 != primeFactors.size())
                {
                    primeFactorsString += ", ";
                }
            }

            return num + " has prime factors: " + primeFactorsString;
        }
        else
        {
            return num + " is prime so it has no prime factors";
        }
    }

    /**
     * Recursive method from the last assignment to get the prime factors of a number in order
     * @param num Number to gather prime factors from
     * @param factors ArrayList holding the prime factors
     * @param tracker Number to keep track of what to test dividing by next (always starts at 3)
     * @return Returns a reference to an ArrayList containing all the prime factors in order
     */
    public static ArrayList<Integer> calculateFactors(int num, ArrayList<Integer> factors, int tracker)
    {
        //If the number is prime there are no prime factors
        if(isPrime(num))
        {
            //Adds the prime number to the ArrayList without a recursive call and will end the loop
            factors.add(num);
        }
        else if(num % 2 == 0) //Will go through here until the number is not even
        {
            //Divides by 2 and adds 2 to the ArrayList of prime factors
            num /= 2;

            factors.add(2);

            //Recursive call
            calculateFactors(num, factors, tracker);
        }
        else
        {
            //Checks to see if the tracked number (always odd) can divide evenly into the number
            if(num % tracker == 0)
            {
                //Divides by the tracker num and adds it to the ArrayList of prime factors
                num /= tracker;

                factors.add(tracker);
            }
            else
            {
                //Increments onto all odd numbers (All prime numbers except for 2 are odd)
                //(Although it will increment onto non-prime numbers like 9 it will never work dividing by 9 above
                // because the prime factors of 9, which are 3 and 3, would have already been added to the prime factor
                // list and taken out of num)
                tracker += 2;
            }

            //Recursive call
            calculateFactors(num, factors, tracker);
        }

        //If it fails all cases above it returns a reference to the ArrayList
        return factors;
    }
}