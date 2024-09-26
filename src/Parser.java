import java.io.*;
import java.util.Scanner;

public class Parser {

    // Create a BST tree of your class type (Note: Replace "Object" with your class type)
    private BST<CARData> mybst = new BST<>();


    public Parser(String filename) throws IOException {
        process(new File(filename));
    }

    // Implement the process method
    // Remove redundant spaces for each input command
    public void process(File input) throws IOException {

        // For file input
        String fileName;
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream("USA_cars_datasets.csv");
        inputFileNameScanner = new Scanner(inputFileNameStream); //

        // ignore first line
        inputFileNameScanner.nextLine();

        // Read the file line by line
        while (inputFileNameScanner.hasNext()) {
            String line = inputFileNameScanner.nextLine();
            String[] parts = line.split(","); // split the string into multiple parts

            // Check if the country match
            if (parts.length == 8) {
                // Date,Country/Region,Confirmed,Deaths,Recovered,Active,New cases,New deaths,New recovered,WHO Region
                // TODO: Create a new COVIDData object
                CARData data = new CARData(
                        Integer.parseInt(parts[0]), // price
                        Integer.parseInt(parts[1]), // year
                        parts[2], // brand
                        parts[3], // model
                        parts[4], // color
                        parts[5], // city / state
                        Float.parseFloat(parts[6]),
                        parts[7]
                );

                mybst.insert(data);
            }
        }
        inputFileNameStream.close(); // because I care


        Scanner scnr = new Scanner(input);

        //call operate_BST method;

        while (scnr.hasNextLine()) {
            String sentence = scnr.nextLine().trim();
            if (!sentence.isEmpty()) {
                String[] command = sentence.split("\\s+");
                operate_BST(command);
            }
        }
        scnr.close();

    }

    /**
     * Executes the appropriate operation on the BST based on the command.
     *
     * @param command the command parsed from the input file
     */
    public void operate_BST(String[] command) {
        switch (command[0]) {
            // add your cases here

            case "removeprice" -> {
                if (command.length == 2) {
                    try {
                        int price = Integer.parseInt(command[1]);
                        int flip = 0;
                        for (CARData car : mybst) {

                            if (car.getPrice() == price) {
                                flip = 1;
                                Node<CARData> removedNode = mybst.remove(car);

                                if (removedNode != null) {
                                    writeToFile("Removed " + price, "./output.txt");
                                }

                            }

                        }
                        if (flip == 0) {
                            writeToFile("Remove Failed", "./output.txt");
                        }

                    } catch (NumberFormatException e) {
                        writeToFile("Invalid Command", "./output.txt");
                    }

                } else {
                    writeToFile("Invalid Command", ",/output.txt");
                }
            }
            case "searchbrand" -> {
                if (command.length == 2) {
                    try {
                        String brand = (command[1]);
                        int flip = 0;
                        for (CARData car : mybst) {

                            if (car.getBrand().equals(brand)) {
                                flip = 1;
                                writeToFile("Found " + brand, "./output.txt");

                            }

                        }
                        if (flip == 0) {
                            writeToFile("Search Failed", "./output.txt");
                        }
                    } catch (NumberFormatException e) {
                        writeToFile("Invalid Command", "./output.txt");
                    }
                } else {
                    writeToFile("Invalid Command", "./output.txt");
                }

            }
            case "print" -> {
                StringBuilder output = new StringBuilder();
                for (CARData data : mybst) {
                    output.append(data).append("\n");
                }
                writeToFile(output.toString().trim(), "./output.txt");
            }

            // default case for Invalid Command
            default -> writeToFile("Invalid Command", "./output.txt");
        }
    }

    // Implement the writeToFile method
    // Generate the result file
    public void writeToFile(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
