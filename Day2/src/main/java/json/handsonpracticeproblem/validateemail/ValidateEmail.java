package json.handsonpracticeproblem.validateemail;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.File;

public class ValidateEmail {
    public static void main(String[] args) {
        String dataPath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\handsonpracticeproblem\\validateemail\\data.json";
        String  schemaPath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\handsonpracticeproblem\\validateemail\\schema.json";
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Load JSON Schema
            JsonNode schemaNode = objectMapper.readTree(new File(schemaPath));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            // Load JSON Data
            JsonNode jsonData = objectMapper.readTree(new File(dataPath));

            // Validate Email
            if (schema.validate(jsonData).isSuccess()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("Invalid JSON!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
