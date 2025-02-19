package csvdatahandling.advanced.readlargecsv;

import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\advanced\\readlargecsv\\large.csv";  // Replace with your actual file path
        int batchSize = 100; // Number of lines to read at a time
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                totalRecords++;

                // Process the line (for now, just print every 100th record)
                if (totalRecords % batchSize == 0) {
                    System.out.println("Processed " + totalRecords + " records...");
                }
            }

            System.out.println("Total records processed: " + totalRecords);
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}

