package csvdatahandling.advanced.validatecsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class CSVValidator {

    // Regex for validating email
    private static final String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    // Regex for validating phone number
    private static final String phoneRegex = "^\\d{10}$";

    public static void main(String[] args) {
        String csvFile = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\advanced\\validatecsv\\employees.csv"; // Path to the CSV file

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            // Read the header row
            String[] header = reader.readNext();
            if (header == null || header.length < 2 || !"Email".equals(header[0]) || !"Phone Numbers".equals(header[1])) {
                System.err.println("Invalid CSV format. Expected columns: 'Email', 'Phone Numbers'.");
                return;
            }

            String[] row;
            int rowNumber = 1; // Track row number for error messages
            while ((row = reader.readNext()) != null) {
                rowNumber++;

                // Validate email
                String email = row[0];
                if (!Pattern.matches(emailRegex, email)) {
                    printInvalidRow(rowNumber, row, "Invalid email format: " + email);
                    continue;
                }

                // Validate phone number
                String phone = row[1];
                if (!Pattern.matches(phoneRegex, phone)) {
                    printInvalidRow(rowNumber, row, "Invalid phone number: " + phone);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    private static void printInvalidRow(int rowNumber, String[] row, String errorMessage) {
        System.err.println("Row " + rowNumber + " is invalid: " + errorMessage);
        System.err.println("Row data: " + String.join(", ", row));
    }
}
