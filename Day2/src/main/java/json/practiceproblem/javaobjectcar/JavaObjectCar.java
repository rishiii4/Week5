package json.practiceproblem.javaobjectcar;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JavaObjectCar {
    public static void main(String[] args) {
        try {
            // Correct file path
            String filePath = "C:/Users/Lenovol/OneDrive/Documents/Desktop/Week5/Day2/src/main/java/json/practiceproblem/javaobjectcar/output.json";

            // Ensure the directory exists
            File file = new File(filePath);
            file.getParentFile().mkdirs();

            // Create Car object
            Car car1 = new Car("Harrier", "3000cc");
            Car car2 = new Car("Punch","800cc");

            // Create ObjectMapper and write JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, car1);
            objectMapper.writeValue(file, car2);

            // Print JSON output
            System.out.println("JSON Output: " + objectMapper.writeValueAsString(car1));
            System.out.println("JSON Output: " + objectMapper.writeValueAsString(car2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

