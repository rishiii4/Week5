package json.practiceproblem.parseandfilterjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ParseJSONFilterRecords {
    public static void main(String[] args) {
        // File path
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\practiceproblem\\parseandfilterjson\\employees.json";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            // Filter records based on age
            for (JsonNode val: jsonNode){
                int age = val.get("age").asInt();
                if(age>25){
                    // Print details if age is greater than 25
                    System.out.println(val);
                }
            }
        }catch (Exception e){
            // Catching exception
            System.out.println(e.getMessage());
        }
    }
}
