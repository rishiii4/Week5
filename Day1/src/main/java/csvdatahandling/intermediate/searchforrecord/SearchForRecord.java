package csvdatahandling.intermediate.searchforrecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class SearchForRecord {
    public static void main(String[] args) {
        // File path
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\intermediate\\searchforrecord\\employee.csv";

        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){

            // Taking input of name from user
            System.out.println("Enter First Name of Employee (First Letter Capital): ");
            String name = input.next();

            // Skipping header
            br.readLine();
            String line;
            while ((line = br.readLine()) != null){
                String[] columns = line.split(",");
                // Checking if name present in record
                if(columns[1].equals(name)){
                    System.out.println(line);
                }
            }

        } catch (Exception e) {
            // Catching exception
            System.out.println(e.getMessage());
        }
    }
}
