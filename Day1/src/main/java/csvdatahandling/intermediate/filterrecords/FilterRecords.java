package csvdatahandling.intermediate.filterrecords;

import java.io.BufferedReader;
import java.io.FileReader;

public class FilterRecords {
    public static void main(String[] args) {
        // File path
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\intermediate\\filterrecords\\records.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            // Skipping header
            br.readLine();

            while ((line = br.readLine()) != null){
                String[] columns = line.split(",");
                // Checking if marks is greater than 80
                if((Integer.parseInt(columns[3]) > 80)){
                    // Printing line
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            // Catching exception
            System.out.println(e.getMessage());
        }
    }
}
