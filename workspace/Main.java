//Jonthan Kosuhan, pd 1, jan 14 2025
//runs program, creats an array that will cycle though the differnt countries with the infomation. Also process the input by the user and tests if it matchs the right answer. Makes most of the UI system as well.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
//makes everything and 
public class Main {
    // Array of 10 Country objects
    private Country[] countryArray = new Country[10];
    // Index of the current shown country
    private int index = 0;

    // GUI elements
    private JFrame jFrame = new JFrame("Countries");
    private ImageIcon img;
    private JLabel imageLabel;
    private JLabel outputLabel;
    private JTextField input;

    public static void main(String[] args) {
        // Create the GUI
        Main gui = new Main();
        gui.loadCountries();
        gui.showCountry();
    }

    public void loadCountries() {
        // Open the data file - do not change
        File file = new File("/workspaces/Countries/workspace/countries-data.csv");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }

        // Loop through the array and read data into it
        for (int i = 0; i < countryArray.length; i++) {
            String input = scan.nextLine(); // Read the line
            String[] data = input.split(","); // Split by commas

            System.out.println("Read in " + data[2]); // Log the language

            // Create a new Country object and add it to the array
            countryArray[i] = new Country(data[0], data[1], data[2], data[3]);
        }
        scan.close();
    }

    public void showCountry() {
        // Get the current country from the array
        Country currentCountry = countryArray[index];

        // Get its image file name
        String imagefile = currentCountry.getImg();

        // Display the image in the GUI
        System.out.println("Printing image in showCountry: " + imagefile);
        img = new ImageIcon("/workspaces/Countries/workspace/" + imagefile);
        imageLabel.setIcon(img);
    }

    public void nextButtonClick() {
        // Increment the index
        index++;
        if (index > 9) {
            index = 0; // Reset to the start
        }

        // Clear the output label and call showCountry()
        outputLabel.setText("");
        showCountry();
    }

    public void reviewButtonClick() {
        // Get the current country
        Country currentCountry = countryArray[index];

        // Get the country details and print/display them
        String details = currentCountry.toString();
        System.out.println(details);
        outputLabel.setText(details);
    }

    public void quizButtonClick() {
        // Clear the output label
        outputLabel.setText("");

        // Get the current country
        Country currentCountry = countryArray[index];

        // Display a quiz question
        System.out.println("What country is this?");
        outputLabel.setText("What country is this?");

        // Get the user's answer
        String userAnswer = input.getText().trim();

        // Check if the answer is correct
        if (userAnswer.equalsIgnoreCase(currentCountry.getName())) {
            System.out.println("Correct!");
            outputLabel.setText("Correct!");
        } else {
            System.out.println("Incorrect. The correct answer is " + currentCountry.getName() + ".");
            outputLabel.setText("Incorrect. The correct answer is " + currentCountry.getName() + ".");
        }

        // Clear the input field
        input.setText("");
    }

    public Main() {
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);

        System.out.println("Printing img in main");
        // Create a new image icon
        img = new ImageIcon("/workspaces/Countries/workspace/worldmap.jpg");
        // Create a label to display image
        imageLabel = new JLabel(img);
        // And one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);
        input = new JTextField(20);
        jFrame.add(input);

        jFrame.setVisible(true);
        // Add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reviewButtonClick();
            }
        });
        quizButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quizButtonClick();
            }
        });

        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextButtonClick();
            }
        });
    }
}
