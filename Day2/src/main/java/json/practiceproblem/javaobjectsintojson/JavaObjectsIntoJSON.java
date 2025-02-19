package json.practiceproblem.javaobjectsintojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class JavaObjectsIntoJSON {
    public static void main(String[] args) {
        try {
            // List of Java objects
            List<Employee> empList = Arrays.asList(new Employee(1,"Raju"),
                    new Employee(2,"Shyam"),new Employee(3,"Baburao"),
                    new Employee(4,"Wasooli"));

            // Convert list to JSON array
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(empList);

            System.out.println(jsonArray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
