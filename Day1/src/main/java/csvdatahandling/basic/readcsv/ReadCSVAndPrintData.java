package csvdatahandling.basic.readcsv;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSVAndPrintData {
    public static void main(String[] args) {
        // File Path
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\basic\\readcsv\\example.csv";

        // BufferReader to read file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine()) != null){
                String[] columns = line.split(",");
                // Printing details
                System.out.println("ID: "+ columns[0] +", Name: "+columns[1]+", Age: "+columns[2]+", Marks: "+columns[3]);
            }
        } catch (Exception e) {
            // Catching Exception
            System.out.println(e.getMessage());
        }
    }
}
