package csvdatahandling.intermediate.modifycsvfile;

import java.io.*;

public class ModifyCSV {
    public static void main(String[] args) {
        // File path
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\intermediate\\modifycsvfile\\employee.csv";
        String modifiedFile = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\intermediate\\modifycsvfile\\modified.csv";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(modifiedFile));)
        {
            String line;
            // Skip header
            bufferedWriter.write(bufferedReader.readLine() +"\n");

            while((line = bufferedReader.readLine()) != null){
                // Array of data, using split method to split text;
                String [] data = line.split(",");
                // Check if employee is available
                if(data[2].equalsIgnoreCase("IT")){
                    int salary = Integer.parseInt(data[3]);
                    salary += (salary * 10 ) / 100;
                    bufferedWriter.write(data[0]+","+data[1]+","+data[2]+","+salary+"\n");
                }else {
                    bufferedWriter.write(data[0]+","+data[1]+","+data[2]+","+data[3]+"\n");
                }
            }
        } catch (FileNotFoundException e) {
            // Catching exception
            System.out.println("File not found : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception "+e.getMessage());
        }
    }
}