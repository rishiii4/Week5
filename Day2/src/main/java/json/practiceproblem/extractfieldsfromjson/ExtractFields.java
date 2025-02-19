package json.practiceproblem.extractfieldsfromjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ExtractFields {
    public static void main(String[] args) {
        // File path
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\practiceproblem\\extractfieldsfromjson\\employees.json";
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            // Printing name
            System.out.println("Name: "+jsonNode.get("name").asText());
            // Printing email
            System.out.println("Email: "+jsonNode.get("email").asText());

        } catch (Exception e) {
            // Catching exception
            System.out.println(e.getMessage());
        }
    }
}
