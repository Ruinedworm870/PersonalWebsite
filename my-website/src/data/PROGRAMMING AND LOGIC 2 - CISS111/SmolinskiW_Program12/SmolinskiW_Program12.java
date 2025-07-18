/**
 * William Smolinski
 * CISS 111
 * Program12 - Shows the use of a linked list by keeping track of high scores
 */

package com.example.smolinskiw_program12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SmolinskiW_Program12 extends Application
{
    private static HighScoreList hsList;

    @Override
    public void start(Stage stage)
    {

        //Creating the GUI

        //Top row
        Label instructions = new Label("Name:");
        instructions.setMinSize(100, 35);
        TextField input = new TextField();
        input.setPrefSize(200, 35);
        HBox topHBox = new HBox(instructions, input);
        topHBox.setSpacing(10);

        //Middle row
        Button clearButton = new Button("Clear");
        clearButton.setPrefSize(75, 35);
        Button removeButton = new Button("Remove");
        removeButton.setPrefSize(75, 35);
        Button addButton = new Button("Add");
        addButton.setPrefSize(75, 35);
        Button viewButton = new Button("View");
        viewButton.setPrefSize(75, 35);
        HBox middleHBox = new HBox(clearButton, removeButton, addButton, viewButton);
        middleHBox.setSpacing(10);

        //Bottom Row (Output)
        Label output = new Label();

        //Organizing the HBoxs into a VBox
        VBox items = new VBox(topHBox, middleHBox, output);
        items.setPadding(new Insets(10));
        items.setSpacing(10);

        //Button Events

        //Clear button clears all input that was entered so far
        clearButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                //Clears the input textField
                input.clear();

                //Makes sure that the remove button is visible
                removeButton.setVisible(true);

                //Makes sure the instructions label is set to its default text
                instructions.setText("Name:");

                //Clears output
                output.setText("");
            }
        });

        //Remove button removes the name and high score from the linked list
        removeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                //Gathers the name from the textField
                String name = input.getText();

                //Checks to make sure the textField wasn't empty
                if(!name.equals(""))
                {
                    if(removeFromList(name))
                    {
                        output.setText("Successfully removed " + name + "'s high score\n" + output.getText());
                    }
                    else
                    {
                        output.setText(name + " does not exist in the list\n" + output.getText());
                    }
                    input.clear();
                }
                else
                {
                    output.setText("Input is empty\n" + output.getText());
                }
            }
        });

        //Add button adds the name and high score to the linked list or adds to the high score
        addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                //Gathers the text from the textField
                String text = input.getText();

                //Hides the remove button and changes the instructions to enter the high score
                if(instructions.getText().equals("Name:") && !text.equals(""))
                {
                    removeButton.setVisible(false);
                    instructions.setText(text + "\nNew High Score:");
                    input.clear();
                }
                else if(!text.equals(""))
                {
                    //Gets the name that was previously entered
                    String name = instructions.getText().split("\n")[0];

                    int num = 0;
                    boolean numberSet = false;

                    //Converts the text into an int
                    try
                    {
                        num = Integer.parseInt(text);
                        numberSet = true;
                    }
                    catch(Exception e)
                    {
                        output.setText("Not a valid number\n" + output.getText());
                    }

                    if(numberSet)
                    {
                        //Runs the method to update the list and outputs the results
                        if(addToList(name, num))
                        {
                            output.setText(name + "'s high score added\n" + output.getText());
                        }
                        else
                        {
                            output.setText(name + "'s high score updated\n" + output.getText());
                        }

                        //High score has been entered and returns to default state
                        instructions.setText("Name:");
                        input.clear();
                        removeButton.setVisible(true);
                    }
                }
                else
                {
                    output.setText("Input is empty\n" + output.getText());
                }
            }
        });

        //View button outputs the names and high scores from the linked list
        viewButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                output.setText(viewList());
            }
        });

        //Displaying the scene
        Scene scene = new Scene(items, 350, 500);
        stage.setTitle("SmolinskiW_Program12");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

    /**
     * Method to check the linked list for the name
     * @param name Name to search for
     * @return Returns if the name is there or not as a boolean
     */
    public static HighScoreList getNameNode(String name)
    {
        boolean found = false;
        HighScoreList current = hsList;

        //Loops through the linked list to check for the name
        while(!found && current != null)
        {
            if(current.name.equals(name))
            {
                found = true;
            }
            else
            {
                current = current.next;
            }
        }
        return current;
    }

    /**
     * Method to create a node or update the score of an existing node and make sure it is in the correct order
     * @param name Name of the player
     * @param highScore High score of the player
     * @return Returns if the operation was successful or not as a boolean
     */
    public static boolean addToList(String name, int highScore)
    {
        //Gets the node in the linked list that has the name
        HighScoreList node = getNameNode(name);

        HighScoreList current;
        boolean found = false;
        boolean toReturn;

        //Checks for if the name is in the list or not
        if(node == null)
        {
            //If the name is not in the list it creates a new node

            node = new HighScoreList(name, highScore);

            current = hsList;

            //Makes sure the list isn't empty
            if(current != null)
            {
                //Inserts to the correct position after searching through a loop for it
                while(!found && current.next != null)
                {
                    if(current.highScore >= highScore && highScore > current.next.highScore)
                    {
                        //Inserting the node
                        current.next.prev = node;
                        node.next = current.next;
                        current.next = node;
                        node.prev = current;

                        found = true;
                    }
                    else
                    {
                        current = current.next;
                    }
                }

                //Inserting at the end or beginning of the list
                if(!found && highScore > hsList.highScore)
                {
                    //At the beginning if it has the highest high score

                    HighScoreList temp = node;
                    node = hsList;
                    hsList = temp;

                    hsList.next = node;
                    node.prev = hsList;
                    hsList.prev = null;
                }
                else if(!found)
                {
                    //At the end if it has the lowest high score
                    node.next = null;
                    current.next = node;
                    node.prev = current;
                }
            }
            else
            {
                //Adds it as the first and only item to the list
                hsList = new HighScoreList(name, highScore);
            }

            toReturn = true;
        }
        else
        {
            //If the name is in the list it updates the high score
            node.highScore = highScore;

            toReturn = false;
        }

        return toReturn;
    }

    /**
     * Method to remove a name from the list
     * @param name Name of the player
     * @return Returns if the name was removed or not as a boolean
     */
    public static boolean removeFromList(String name)
    {
        //Gets the node in the linked list that has the name
        HighScoreList node = getNameNode(name);

        //Checks for if the name is in the list or not
        if(node != null)
        {
            //Points around the node and clears where the node points to

            //Checks to see if it is on the end and changes the operations if so
            if(node.next == null)
            {
                if(node.prev == null)
                {
                    hsList = null;
                }
                else
                {
                    node.prev.next = null;
                }
            }

            if(node.prev == null)
            {
                if(node.next != null)
                {
                    node.next.prev = null;
                    hsList = node.next;
                }
            }

            node.prev = null;
            node.next = null;
            return true;
        }
        else
        {
            //The name is not in the list
            return false;
        }
    }

    /**
     * Method to get the contents of the list printed out in order
     * @return Returns the contents as a String
     */
    public static String viewList()
    {
        String output = "";

        HighScoreList current = hsList;

        //Loops through the list formatting the data into a String
        while(current != null)
        {
            output += current.name + ": " + current.highScore + "\n";
            current = current.next;
        }

        return output;
    }

}