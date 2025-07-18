/**
 * William Smolinski
 * CISS 111
 * Program09 - Uses a GUI to simulate a store and buying shirts
 */

package com.example.smolinskiw_program09;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SmolinskiW_Program09 extends Application {
    @Override
    public void start(Stage stage) throws IOException
    {
        //Array to hold the total for each size
        int[] sizeQuantities = new int[6];

        //Array to hold the prices for each size
        double[] sizePrices = new double[6];

        //PRIMARY SCENE ----------------------------------------------------------

        //Creating the MenuBar
        MenuBar menuBar = new MenuBar();

        Menu helpMenu = new Menu("Help");

        MenuItem help = new MenuItem("Open Help");
        helpMenu.getItems().add(help);

        menuBar.getMenus().add(helpMenu);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);

        //TextField to get the quantity to buy
        TextField quantity = new TextField("Quantity");
        quantity.setPrefSize(100, 35);

        //Sets up the combo boxes to select sizes
        ComboBox selectSizes = new ComboBox();
        selectSizes.getItems().addAll("XS", "S", "M", "L", "XL", "XXL");
        selectSizes.setPrefSize(75, 35);

        //Button to add the quantity to your order
        Button addButton = new Button("Add");
        addButton.setPrefSize(100, 35);

        HBox mainActions = new HBox(quantity, selectSizes, addButton);
        mainActions.setSpacing(20);

        //Creates labels to show the cart history for the last 5 quantities
        Label historyTitle = new Label("History:");

        Label history = new Label();
        history.setMaxHeight(100);
        history.setMaxWidth(300);
        //history.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        //Creates the buttons to view the cart
        Button viewCart = new Button("View Cart");
        viewCart.setPrefSize(100, 35);

        //Creates the label and button for getting the file to get the prices from
        Label selectedFile = new Label();
        selectedFile.setMinSize(195, 35);
        selectedFile.setMaxSize(195, 35);
        selectedFile.setAlignment(Pos.CENTER_LEFT);
        selectedFile.setText("FILE:");

        Button changeFile = new Button("Change");
        changeFile.setPrefSize(100, 35);

        FileChooser fileChooser = new FileChooser();

        HBox fileSection = new HBox(selectedFile, changeFile);
        fileSection.setSpacing(20);

        //VBox to organize the scene
        VBox mainSceneLayout = new VBox(mainActions, historyTitle, history, viewCart, fileSection);
        mainSceneLayout.setSpacing(10);
        mainSceneLayout.setPadding(new Insets(10));

        borderPane.setCenter(mainSceneLayout);

        //Creates the scene
        Scene mainScene = new Scene(borderPane, 340, 325);

        //Applying the stylesheet

        var result = mainScene.getStylesheets().add("myStyle.css");

        historyTitle.getStyleClass().add("label-title");
        history.getStyleClass().add("label-main");
        selectedFile.getStyleClass().add("label-main");

        addButton.getStyleClass().add("button-main");
        changeFile.getStyleClass().add("button-main");
        viewCart.getStyleClass().add("button-main");

        selectSizes.getStyleClass().add("combo-box-main");

        quantity.getStyleClass().add("text-field-main");

        //SECONDARY SCENE------------------------------------------------------------------

        //Creating the MenuBar for the secondary scene
        MenuBar menuBar2 = new MenuBar();

        Menu helpMenu2 = new Menu("Help");

        MenuItem help2 = new MenuItem("Open Help");
        helpMenu2.getItems().add(help2);

        menuBar2.getMenus().add(helpMenu2);

        BorderPane borderPane2 = new BorderPane();
        borderPane2.setTop(menuBar2);

        //Label to display the information about the order
        Label sizesAndTotals = new Label();

        //Creates the buttons for the secondary scene
        Button secondarySceneBackButton = new Button("Back");
        secondarySceneBackButton.setPrefSize(100, 35);

        Button getReceipt = new Button("Receipt");
        getReceipt.setPrefSize(100, 35);

        Button clear = new Button("Clear");
        clear.setPrefSize(100, 35);

        HBox bottomButtons = new HBox(secondarySceneBackButton, clear, getReceipt);
        bottomButtons.setSpacing(25);
        bottomButtons.setAlignment(Pos.CENTER);

        //VBox to organize the scene
        VBox secondarySceneLayout = new VBox(sizesAndTotals, bottomButtons);
        secondarySceneLayout.setPadding(new Insets(10));
        secondarySceneLayout.setSpacing(10);

        borderPane2.setCenter(secondarySceneLayout);

        Scene secondaryScene = new Scene(borderPane2, 340, 300);

        //Applying the stylesheet

        var result2 = secondaryScene.getStylesheets().add("myStyle.css");

        sizesAndTotals.getStyleClass().add("label-main");

        secondarySceneBackButton.getStyleClass().add("button-main");
        getReceipt.getStyleClass().add("button-main");
        clear.getStyleClass().add("button-main");

        //Changes the stage to the main scene
        secondarySceneBackButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                stage.setScene(mainScene);
            }
        });

        //HELP SCENE-------------------------------------------------------------------

        //Borderpane for the help scene
        BorderPane helpSceneBorderpane = new BorderPane();

        //Creates the back button
        Button helpBackButton = new Button("Back");
        helpBackButton.setPrefSize(100, 35);

        //Displays the text in the help scene
        Label displayHelp = new Label("Program09 by: William Smolinski\n" +
                "\nHOW TO USE:\n" +
                "\n1. Enter a number for the quantity and a size then hit the add button\n" +
                "\n2. It will give an error or tell you the result of the operation in the history section\n" +
                "\n3. Make sure you select a file at the bottom to use for prices\n" +
                "\n4. You can open the cart to view more details about your order and check out");

        //VBox to organize the scene
        VBox helpSceneLayout = new VBox(displayHelp, helpBackButton);
        helpSceneLayout.setSpacing(10);
        helpSceneLayout.setPadding(new Insets(10));
        helpSceneBorderpane.setCenter(helpSceneLayout);

        Scene helpScene = new Scene(helpSceneBorderpane, 600, 400);

        //Applying the stylesheet

        var result3 = helpScene.getStylesheets().add("myStyle.css");

        displayHelp.getStyleClass().add("label-help");

        helpBackButton.getStyleClass().add("button-main");

        //Changes the stage to the help scene
        help.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                stage.setScene(helpScene);
            }
        });

        //Changes the stage back to the main scene
        helpBackButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                stage.setScene(mainScene);
            }
        });

        //MAIN EVENT HANDLERS---------------------------------------------------------------

        //Handles adding new quantities to the cart
        addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                int quantityNum = 0;
                boolean validInput = false;
                String selectedSize = "";

                //Checks to see if a valid number was entered for the quantity
                try
                {
                    quantityNum = Integer.parseInt(quantity.getText());
                    validInput = true;
                }
                catch (Exception e)
                {
                    history.setText("INVALID NUMBER\n" + history.getText());
                }

                if(selectSizes.getValue() != null)
                {
                    selectedSize = (String)selectSizes.getValue();
                }
                else
                {
                    history.setText("NO SIZE SELECTED\n" + history.getText());
                    validInput = false;
                }

                int index = getSizeIndex(selectedSize);

                //Quantity can't be more than 1 million for one item to keep output looking clean
                // (and it isn't practical to buy 1 million shirts)
                if(sizeQuantities[index] + quantityNum >= 1000000)
                {
                    history.setText("TOO MANY OF THIS SIZE\n" + history.getText());
                    validInput = false;
                }

                if(validInput)
                {
                    String labelText = "";

                    //Clears the size
                    if(quantityNum == 0)
                    {
                        sizeQuantities[index] = 0;
                        labelText = selectedSize + " Cleared\n";
                    }
                    else if(quantityNum < 0) //Takes away the quantity entered
                    {
                        //Can't have a negative quantity
                        if(sizeQuantities[index] + quantityNum <= 0)
                        {
                            sizeQuantities[index] = 0;
                            labelText = selectedSize + " Cleared\n";
                        }
                        else
                        {
                            sizeQuantities[index] += quantityNum;
                            labelText = selectedSize + ": " + (sizeQuantities[index] - quantityNum) + " - " +
                                    (quantityNum * -1) + " = " + sizeQuantities[index] + "\n";
                        }
                    }
                    else //Adds the quantity
                    {
                        sizeQuantities[index] += quantityNum;
                        labelText = selectedSize + ": " + (sizeQuantities[index] - quantityNum) + " + " +
                                quantityNum + " = " + sizeQuantities[index] + "\n";
                    }

                    history.setText(labelText + history.getText());
                }
            }
        });

        //Changes the stage to the secondary scene and updates the cart info
        viewCart.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                //Check if valid file is selected and update text in secondary scene
                stage.setScene(secondaryScene);

                sizesAndTotals.setText(getNeatOutput(sizeQuantities, sizePrices));
            }
        });

        //Clears the cart
        clear.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                //Clears the array
                for(int i = 0; i < 6; i++)
                {
                    sizeQuantities[i] = 0;
                }

                history.setText("CLEARED\n" + history.getText());

                sizesAndTotals.setText(getNeatOutput(sizeQuantities, sizePrices));
            }
        });

        //Handles changing and checking the file for prices
        changeFile.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                //Set to null to initialize
                File priceFile = null;

                //Set to null to initialize
                Scanner inputFile = null;

                boolean validFile = false;
                boolean choseAFile = false;

                //Gets a file from the fileChooser
                //try-catch used to that when the user exits the fileChooser it doesn't give a massive error to the console
                try
                {
                    priceFile = fileChooser.showOpenDialog(stage);

                    selectedFile.setText(priceFile.getName());

                    choseAFile = true;
                }
                catch(Exception e)
                {
                    //No file selected
                }

                //Determines if the file is valid
                if(choseAFile)
                {
                    try
                    {
                        inputFile = new Scanner(priceFile);
                        validFile = true;
                    }
                    catch(Exception e)
                    {
                        history.setText("INVALID FILE\n" + history.getText());
                    }
                }

                String line;
                double price;

                //Used to make sure all sizes are gathered
                boolean hasSizePrice[] = new boolean[6];

                //Handles reading the file
                if(validFile)
                {
                    //Designed to take input in the format of the file provided in the assignment
                    while (inputFile.hasNext())
                    {
                        line = inputFile.nextLine();

                        price = getPrice(line);

                        //If a valid number is in the file in the correct format
                        if(price >= 0)
                        {
                            //If the line contains the size, the price gathered from that line will be the price for the size
                            //It will change the price if there is duplicate sizes with prices
                            //For example you could have 2 lines of XS with the top one being 10.00 and the bottom 11.00
                            //and the price will be set to 11.00
                            if(line.contains("XS"))
                            {
                                sizePrices[0] = price;
                                hasSizePrice[0] = true;
                            }
                            else if(line.contains("S"))
                            {
                                sizePrices[1] = price;
                                hasSizePrice[1] = true;
                            }
                            else if(line.contains("M"))
                            {
                                sizePrices[2] = price;
                                hasSizePrice[2] = true;
                            }
                            else if(line.contains("XXL"))
                            {
                                sizePrices[5] = price;
                                hasSizePrice[5] = true;
                            }
                            else if(line.contains("XL"))
                            {
                                sizePrices[4] = price;
                                hasSizePrice[4] = true;
                            }
                            else if(line.contains("L"))
                            {
                                sizePrices[3] = price;
                                hasSizePrice[3] = true;
                            }
                        }
                    }

                    boolean allSizes = true;
                    int count = 0;

                    //Loops through to make sure all sizes have a price
                    while(allSizes && count < hasSizePrice.length)
                    {
                        if(!hasSizePrice[count])
                        {
                            allSizes = false;
                        }
                        else
                        {
                            count += 1;
                        }
                    }

                    //Outputs to history if not all prices were gathered
                    if(!allSizes)
                    {
                        history.setText("NOT ALL SIZE PRICES GATHERED\n" + history.getText());
                    }
                    else
                    {
                        history.setText("FILE SUCCESSFULLY GATHERED\n" + history.getText());
                    }

                    inputFile.close();
                }
            }
        });

        getReceipt.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                //Set to null to initialize
                File outputFile = null;
                PrintWriter writeToFile = null;

                boolean validFile = false;
                boolean choseAFile = false;

                //In a try-catch to prevent a massive error from being printed to the console when the user exits the file chooser
                try
                {
                    //Lets the user choose a file for output
                    outputFile = fileChooser.showOpenDialog(stage);

                    //Makes sure the file is a .txt so that you don't mess up any other files on your system on accident
                    if(outputFile.getName().endsWith(".txt"))
                    {
                        validFile = true;
                    }
                    else
                    {
                        history.setText("NOT .txt FILE\n" + history.getText());
                    }

                    choseAFile = true;
                }
                catch (Exception e)
                {
                    //No file selected
                }

                if(choseAFile)
                {
                    //Makes sure a valid file is chosen for output
                    try
                    {
                        writeToFile = new PrintWriter(outputFile);
                    }
                    catch(Exception e)
                    {
                        history.setText("INVALID OUTPUT FILE\n" + history.getText());
                        validFile = false;
                    }
                }

                //Writes the neat output to the file
                if(validFile)
                {
                    writeToFile.println(getNeatOutput(sizeQuantities, sizePrices));

                    writeToFile.close();

                    //This also clears history
                    history.setText("RECEIPT PRINTED");

                    //Clears the cart and sets you back to the main screen

                    //Clears the array
                    for(int i = 0; i < 6; i++)
                    {
                        sizeQuantities[i] = 0;
                    }

                    sizesAndTotals.setText(getNeatOutput(sizeQuantities, sizePrices));

                    stage.setScene(mainScene);
                }
            }
        });

        //ON START-----------------------------------------------------

        //Sets the main scene to the stage
        stage.setScene(mainScene);

        //Sets the title and shows the stage
        stage.setTitle("SmolinskiW_Program09");
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

    /**
     * Method to get the index in the array for each size based on the String of the size name
     * @param size String of the size name
     * @return Returns the index in the array of that size as an int
     */
    public static int getSizeIndex(String size)
    {
        if(size.equals("XS"))
        {
            return 0;
        }
        else if(size.equals("S"))
        {
            return 1;
        }
        else if(size.equals("M"))
        {
            return 2;
        }
        else if(size.equals("L"))
        {
            return 3;
        }
        else if(size.equals("XL"))
        {
            return 4;
        }
        else
        {
            return 5;
        }
    }

    /**
     * Method to update the text of the cart
     * @param quantities int Array with the quantities of each size
     * @param prices int Array with the prices of each size
     * @return Returns a String with the output formatted nicely
     */
    public static String getNeatOutput(int[] quantities, double[] prices)
    {
        double totalWithTax = 0;

        //Gets the total with tax
        for(int i = 0; i < prices.length; i++)
        {
            totalWithTax += (prices[i] * quantities[i]);
        }

        totalWithTax *= 1.08;

        return (String.format("%s\t%10s\t%10s%.2f", "XS: ", quantities[0], " $", (prices[0] * quantities[0])) + "\n" +
                String.format("%s\t%10s\t%10s%.2f", "S: ", quantities[1], " $", (prices[1] * quantities[1])) + "\n" +
                String.format("%s\t%10s\t%10s%.2f", "M: ", quantities[2], " $", (prices[2] * quantities[2])) + "\n" +
                String.format("%s\t%10s\t%10s%.2f", "L: ", quantities[3], " $", (prices[3] * quantities[3])) + "\n" +
                String.format("%s\t%10s\t%10s%.2f", "XL: ", quantities[4], " $", (prices[4] * quantities[4])) + "\n" +
                String.format("%s\t%10s\t%10s%.2f", "XXL: ", quantities[5], " $", (prices[5] * quantities[5])) + "\n" +
                String.format("\nTotal (with 8%s tax): $%.2f", "%", totalWithTax));
    }

    /**
     * Method to get the price of the size from the line
     * @param line String of the line in the file to get the price from
     * @return Returns the price as a double
     */
    public static double getPrice(String line)
    {
        String[] splitLine = line.split(" ");

        try
        {
            return Double.parseDouble(splitLine[1]);
        }
        catch(Exception e)
        {
            //Invalid file format
            return -1;
        }
    }
}