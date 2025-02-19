package csvdatahandling.advanced.jsontocsv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.*;
import java.util.List;
import java.util.Map;

public class JSONToCSV {
    public static void main(String[] args) {
        String csvFilePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\advanced\\jsontocsv\\students.csv";
        String jsonFilePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\advanced\\jsontocsv\\students.json";
        ObjectMapper objectMapper = new ObjectMapper();
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {

            // Read JSON file
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, Map.class);
            List<Map<String, String>> students = objectMapper.readValue(reader, listType);

            // Write CSV header
            writer.write("ID,Name,Age,Marks\n");

            // Write CSV data
            for (Map<String, String> student : students) {
                writer.write(student.get("ID") + "," + student.get("Name") + "," +
                        student.get("Age") + "," + student.get("Marks") + "\n");
            }

            System.out.println("JSON converted to CSV successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


