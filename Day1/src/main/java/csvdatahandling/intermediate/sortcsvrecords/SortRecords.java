package csvdatahandling.intermediate.sortcsvrecords;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SortRecords {
    public static void main(String[] args) {
        // File path
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\intermediate\\sortcsvrecords\\employees.csv";

        try(CSVReader reader = new CSVReader(new FileReader(filePath));)
        {

            String [] line;
            ArrayList<String[]> employeeList = new ArrayList<>();
            // Skip header
            reader.readNext();
            // Read all records into the list
            while((line = reader.readNext()) != null){
                employeeList.add(line);
            }
            // Sort the list based on the salary
            employeeList.sort((o1, o2) -> Integer.compare(Integer.parseInt(o2[3].trim()), Integer.parseInt(o1[3].trim())));

            // Print the top 5 records
            for(int i = 0; i<5;i++){
                String[] data = employeeList.get(i);
                System.out.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3]);
            }

        } catch (FileNotFoundException e) {
            // Catching exception
            System.out.println("File not found : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception "+e.getMessage());
        } catch (CsvValidationException e) {
            System.out.println("Invalid CSV "+e.getMessage());
        }
    }
}
