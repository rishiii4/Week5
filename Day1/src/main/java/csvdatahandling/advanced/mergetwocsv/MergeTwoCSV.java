package csvdatahandling.advanced.mergetwocsv;

import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;
    int marks;
    String grade;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void addMarksAndGrade(int marks, String grade) {
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class MergeTwoCSV {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\advanced\\mergetwocsv\\student1.csv";  // Contains ID, Name, Age
        String file2 = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\advanced\\mergetwocsv\\student2.csv";  // Contains ID, Marks, Grade
        String outputFile = "merged_students.csv"; // Output file

        Map<Integer, Student> studentMap = new HashMap<>();

        // Read first CSV file
        readFirstCSV(file1, studentMap);
        // Read second CSV file and merge
        readSecondCSV(file2, studentMap);
        // Write merged data to new CSV file
        writeMergedCSV(outputFile, studentMap);
    }

    private static void readFirstCSV(String filePath, Map<Integer, Student> studentMap) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length < 3) continue;

                int id = Integer.parseInt(values[0].trim());
                String name = values[1].trim();
                int age = Integer.parseInt(values[2].trim());

                studentMap.put(id, new Student(id, name, age));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading first CSV: " + e.getMessage());
        }
    }

    private static void readSecondCSV(String filePath, Map<Integer, Student> studentMap) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length < 3) continue;

                int id = Integer.parseInt(values[0].trim());
                int marks = Integer.parseInt(values[1].trim());
                String grade = values[2].trim();

                if (studentMap.containsKey(id)) {
                    studentMap.get(id).addMarksAndGrade(marks, grade);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading second CSV: " + e.getMessage());
        }
    }

    private static void writeMergedCSV(String filePath, Map<Integer, Student> studentMap) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("ID,Name,Age,Marks,Grade\n"); // Header
            for (Student student : studentMap.values()) {
                bw.write(student + "\n");
            }
            System.out.println("Merged CSV file created: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing merged CSV: " + e.getMessage());
        }
    }
}

