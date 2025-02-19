package csvdatahandling.advanced.detectduplicate;

import java.io.*;
import java.util.*;

public class DetectDuplicatesInCSV {
    public static void main(String[] args) {
        // File path
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\advanced\\detectduplicate\\file.csv";
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Set<String> uniqueIds = new HashSet<>(); // Stores unique IDs
        List<String> duplicateEntries = new ArrayList<>(); // Stores duplicate rows

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Read header
            if (line != null) {
                System.out.println("Header: " + line);
            }

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Split CSV by comma
                if (parts.length > 0) {
                    String id = parts[0].trim(); // Get ID (1st column)

                    // Check if ID already exists
                    if (!uniqueIds.add(id)) {
                        duplicateEntries.add(line);
                    }
                }
            }

            // Print duplicate records
            if (duplicateEntries.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records Found:");
                for (String duplicate : duplicateEntries) {
                    System.out.println(duplicate);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

