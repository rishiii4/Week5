package csvdatahandling.basic.countrows;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadAndCountRows {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\basic\\countrows\\file.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            // Skipping header
            reader.readLine();

            // Initializing count
            int count = 0;
            while(reader.readLine() != null){
                count ++;
            }
            // Printing number of rows
            System.out.println("Number of Rows: "+ count);
        } catch (Exception e) {
            // Catching exception
            System.out.println(e.getMessage());
        }

    }
}
