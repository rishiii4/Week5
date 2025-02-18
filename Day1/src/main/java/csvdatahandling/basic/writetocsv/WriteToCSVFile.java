package csvdatahandling.basic.writetocsv;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToCSVFile {
    public static void main(String[] args) {
        // File path
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\basic\\writetocsv\\example.csv";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            // Writing informations in CSV file
            writer.write("ID, Name, Department, Salary\n");
            writer.write("1, Rishi, CSE, 80000\n");
            writer.write("2, Rohan, CSE, 80000\n");
            writer.write("3, Saini, Civil, 80000\n");
            writer.write("4, Shan, Civil, 80000\n");
            writer.write("5, Arpit, Civil, 80000\n");
            writer.write("6, Mohit, Civil, 80000\n");

            // Printing message after writing informations in file
            System.out.println("CSV File Written Successfully!");

        } catch (Exception e) {
            // Catching Exception
            System.out.println(e.getMessage());
        }
    }
}
