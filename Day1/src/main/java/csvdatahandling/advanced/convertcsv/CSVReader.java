package csvdatahandling.advanced.convertcsv;

import java.io.*;
import java.util.*;

public class CSVReader {
    public static void main(String[] args) {
        // Make sure this file exists
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\advanced\\convertcsv\\student.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header row if exists
            br.readLine();

            while ((line = br.readLine()) != null) {
                // Split CSV by comma
                String[] values = line.split(",");

                if (values.length < 3) {
                    System.out.println("Skipping invalid row: " + Arrays.toString(values));
                    continue; // Skip if row doesn't have enough values
                }

                String name = values[0].trim();
                int age = parseIntSafely(values[1].trim(), 0);
                double gpa = parseDoubleSafely(values[2].trim(), 0.0);

                students.add(new Student(name, age, gpa));
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Print all students
        students.forEach(System.out::println);
    }

    // Helper method to safely parse integers
    private static int parseIntSafely(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format for age: '" + value + "', setting default: " + defaultValue);
            return defaultValue;
        }
    }

    // Helper method to safely parse doubles
    private static double parseDoubleSafely(String value, double defaultValue) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format for GPA: '" + value + "', setting default: " + defaultValue);
            return defaultValue;
        }
    }
}

