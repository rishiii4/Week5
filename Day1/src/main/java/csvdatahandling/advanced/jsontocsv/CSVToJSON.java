package csvdatahandling.advanced.jsontocsv;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class CSVToJSON {
    public static void main(String[] args) {
        String csvFilePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\advanced\\jsontocsv\\students.csv";
        String jsonFilePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\advanced\\jsontocsv\\students.json";
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, String>> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            String[] headers = reader.readLine().split(","); // Read header
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                Map<String, String> student = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], columns[i]);
                }
                students.add(student);
            }

            // Write JSON file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), students);
            System.out.println("CSV converted to JSON successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
