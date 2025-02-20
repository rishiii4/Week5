package json.handsonpracticeproblem.convertcsvtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class ConvertCSVToJSON {
    public static void main(String[] args) {
        // File path
        String csvFilePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\handsonpracticeproblem\\convertcsvtojson\\file.csv";
        String jsonFilePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\handsonpracticeproblem\\convertcsvtojson\\file.json";
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, String>> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            // Read header
            String[] headers = reader.readLine().split(",");

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                // Validate the number of columns
                if (columns.length != headers.length) {
                    System.err.println("Skipping invalid row: " + line);
                    continue;
                }

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
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}